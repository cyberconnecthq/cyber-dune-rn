package com.cyberconnnect.link3.login

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import android.util.Base64
import androidx.credentials.CreatePublicKeyCredentialRequest
import androidx.credentials.CreatePublicKeyCredentialResponse
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetPublicKeyCredentialOption
import androidx.credentials.PublicKeyCredential
import androidx.credentials.exceptions.CreateCredentialCancellationException
import androidx.credentials.exceptions.CreateCredentialCustomException
import androidx.credentials.exceptions.CreateCredentialException
import androidx.credentials.exceptions.CreateCredentialInterruptedException
import androidx.credentials.exceptions.CreateCredentialProviderConfigurationException
import androidx.credentials.exceptions.CreateCredentialUnknownException
import androidx.credentials.exceptions.NoCredentialException
import androidx.credentials.exceptions.publickeycredential.CreatePublicKeyCredentialDomException
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.cyberconnnect.link3.ApolloClient
import com.cyberconnnect.link3.TurnkeyUserLoginQuery
import com.cyberconnnect.link3.type.ForwardTurnkeyRequest
import com.cyberconnnect.link3.type.TurnkeyRequestType
import com.cyberconnnect.link3.type.TurnkeyStamp
import com.cyberconnnect.link3.type.TurnkeyUserLoginResponse_Status
import com.cyberconnnect.link3.utils.Web3Util
import com.cyberconnnect.link3.utils.decodeHex
import com.cyberconnnect.link3.utils.toHex
import com.cyberconnnect.link3.viewmodel.ApplicationViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import org.web3j.crypto.Keys
import org.web3j.crypto.RawTransaction
import org.web3j.crypto.Sign
import org.web3j.crypto.TransactionEncoder
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.core.methods.response.EthGetTransactionCount
import org.web3j.protocol.core.methods.response.EthSendTransaction
import org.web3j.tx.gas.DefaultGasProvider
import timber.log.Timber
import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.SecureRandom


class PasskeyLoginManager(applicationViewModel: ApplicationViewModel, var credentialId: String): AbstractLoginManager(applicationViewModel) {

    val TURNKEY_ORG_ID = if (ApolloClient.debug) "f583a354-edd1-4e33-bc59-1dacedd9c7d9" else "889d8cfa-e41c-410a-a097-252ca1ab0500"
    val RPID = "link3.to"
    val TURNKEY_BASE_URL = "https://api.turnkey.com"
    val TURNKEY_SIGN_URL = "$TURNKEY_BASE_URL/public/v1/submit/sign_raw_payload"
    val TURNKEY_SIGN_TRANSACTION_URL = "$TURNKEY_BASE_URL/public/v1/submit/sign_transaction"

    private lateinit var credentialManager: CredentialManager
    private lateinit var context: Context
    private var authenticationResponseJson: String? = ""

    override fun doInit(context: Context) {
        this.context = context
        credentialManager = CredentialManager.create(context)
//        Timber.tag("hercule").i("[passkey] init: $context")
    }

    override fun doOnActivityDestroyed() {
//        Timber.tag("hercule").i("[passkey] uninit: $context")
        if (context is Activity && (context as Activity).isFinishing) {
            context = context.applicationContext
            credentialManager = CredentialManager.create(context)
        }
    }

    override fun login(scope: CoroutineScope, onSuccess: (token: String?) -> Unit) {
        scope.launch {
            try {
                val credentialJson = JSONObject(authenticationResponseJson)
                val forwardTurnkeyRequest = ForwardTurnkeyRequest(
                    TurnkeyRequestType.WHO_AM_I,
                    "$TURNKEY_BASE_URL/public/v1/query/whoami",
                    "{\"organizationId\":\"$TURNKEY_ORG_ID\"}",
                    TurnkeyStamp("X-Stamp-Webauthn", credentialToTurnkey(authenticationResponseJson))
                )
                val loginQuery = TurnkeyUserLoginQuery(forwardTurnkeyRequest)
                val loginResponse = ApolloClient.apolloClient.query(loginQuery).execute()
                Timber.tag("hercule").i("[passkey] login result: ${loginResponse.data}")
                if (loginResponse.data?.turnkeyUserLogin?.status == TurnkeyUserLoginResponse_Status.SUCCESS) {
                    credentialId = credentialJson.getString("id")
                    onSuccess(loginResponse.data?.turnkeyUserLogin?.user?.privateInfo?.accessToken)
                } else {
                    applicationViewModel.loginFail(LOGIN_FAIL_INVALID_PASSKEY)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun logout() {
    }

    override fun cancelLogin() {
    }

    override fun contractCall(
        contractAddress: String,
        from: String,
        data: String,
        chainId: String,
        value: String,
        success: () -> Unit,
        fail: (errorCode: Int) -> Unit
    ) {
        runBlocking {
            try {
                val web3j = Web3Util.web3jInstance!!
                val ethGetTransactionCount: EthGetTransactionCount = web3j.ethGetTransactionCount(from, DefaultBlockParameterName.LATEST).sendAsync().get()
                val nonce: BigInteger = ethGetTransactionCount.transactionCount
                val maxPriorityFeePerGas = web3j.ethMaxPriorityFeePerGas().sendAsync().get().maxPriorityFeePerGas

                val rawTx = RawTransaction.createTransaction(
                    chainId.substring(chainId.indexOf(':') + 1).toLong(),
                    nonce,
                    DefaultGasProvider.GAS_LIMIT,
                    contractAddress,
                    value.substring(2).toBigInteger(16),
                    data,
                    maxPriorityFeePerGas,
                    maxPriorityFeePerGas.add(BigInteger("270")),
                )

                Timber.tag("hercule").i("[passkey] raw transaction hash: ${TransactionEncoder.encode(rawTx).toHex()}")
//
                val paramsJson = JSONObject()
                    .put("signWith", Keys.toChecksumAddress(from))
                    .put("type", "TRANSACTION_TYPE_ETHEREUM")
                    .put("unsignedTransaction", TransactionEncoder.encode(rawTx).toHex())
                val bodyJson = JSONObject()
                    .put("type", "ACTIVITY_TYPE_SIGN_TRANSACTION_V2")
                    .put("organizationId", applicationViewModel.userProfile.value?.subOrgId)
                    .put("timestampMs", "${System.currentTimeMillis()}")
                    .put("parameters", paramsJson)
                val bodyJsonString = bodyJson.toString()

                val webauthnHeader = credentialToTurnkey(getSavedCredentials(bodyJsonString))

                val request  = Request.Builder()
                    .url(TURNKEY_SIGN_TRANSACTION_URL)
                    .header("X-Stamp-Webauthn", webauthnHeader)
                    .post(bodyJsonString.toRequestBody("text/plain".toMediaType()))
                    .build()

                val call = ApolloClient.okHttpClient.newCall(request)
                val responseJson = JSONObject(call.execute().body?.string())
                Timber.tag("hercule").i("[passkey] sign transaction result: $responseJson")

                val hash = responseJson.getJSONObject("activity")
                    .getJSONObject("result")
                    .getJSONObject("signTransactionResult")
                    .getString("signedTransaction")
                val ethSendTransaction: EthSendTransaction = web3j.ethSendRawTransaction("0x$hash").send()

                if (ethSendTransaction.error != null) {
                    Timber.tag("hercule").i("[passkey] send transaction error code (${ethSendTransaction.error.code}): ${ethSendTransaction.error.message}")
                    fail(when (ethSendTransaction.error.code) {
                        -32000 -> AbstractLoginManager.CONTRACT_CALL_ERROR_INSUFFICIENT_BALANCE
                        else -> AbstractLoginManager.CONTRACT_CALL_ERROR_EXCEPTION
                    })
                } else {
                    val transactionHash = ethSendTransaction.transactionHash
                    Timber.tag("hercule").i("[passkey] send transaction:$transactionHash")
                    success()
                }
            } catch (e: Exception) {
                fail(CONTRACT_CALL_ERROR_EXCEPTION)
            }

        }
    }

    override fun signMessage(
        chainId: Int,
        message: String,
        success: (signature: String) -> Unit,
        fail: (errorCode: Int) -> Unit
    ) {
        if (context is LifecycleOwner) {
            (context as LifecycleOwner).lifecycleScope.launch(Dispatchers.IO) {
                try {
                    val messageBytes = if (message.startsWith("0x")) message.substring(2).decodeHex() else message.decodeHex()
                    val paramsJson = JSONObject()
                        .put("signWith", Keys.toChecksumAddress(applicationViewModel.userProfile.value?.walletAddress))
                        .put("encoding", "PAYLOAD_ENCODING_HEXADECIMAL")
                        .put("payload", Sign.getEthereumMessageHash(messageBytes).toHex())
                        .put("hashFunction", "HASH_FUNCTION_NO_OP")
                    val bodyJson = JSONObject()
                        .put("type", "ACTIVITY_TYPE_SIGN_RAW_PAYLOAD_V2")
                        .put("organizationId", applicationViewModel.userProfile.value?.subOrgId)
                        .put("timestampMs", "${System.currentTimeMillis()}")
                        .put("parameters", paramsJson)
                    val bodyJsonString = bodyJson.toString()

                    val webauthnHeader = credentialToTurnkey(getSavedCredentials(bodyJsonString))

                    val request  = Request.Builder()
                        .url(TURNKEY_SIGN_URL)
                        .header("X-Stamp-Webauthn", webauthnHeader)
                        .post(bodyJsonString.toRequestBody("text/plain".toMediaType()))
                        .build()

                    val call = ApolloClient.okHttpClient.newCall(request)
                    val responseJson = JSONObject(call.execute().body?.string())
                    Timber.tag("hercule").i("[passkey] sign request result: $responseJson")
                    val signResultRaw = responseJson
                        .getJSONObject("activity")
                        .getJSONObject("result")
                        .getJSONObject("signRawPayloadResult")
                    val signResult = generateSignature(signResultRaw.getString("r"), signResultRaw.getString("s"), signResultRaw.getString("v").toInt() + 27)
                    Timber.tag("hercule").i("[passkey] sign message result: $signResult")
                    success(signResult)
                } catch (e: Exception) {
                    e.printStackTrace()
                    fail(SIGN_FAIL)
                }
            }
        }
    }

    private fun generateSignature(r: String, s: String, v: Int): String {
        return "0x$r$s${v.toString(16)}"
    }

    private fun credentialToTurnkey(credential: String?): String {
        return try {
            val credentialJson = JSONObject(credential)
            val credentialResponse = credentialJson.getJSONObject("response")
            val result = JSONObject()
                .put("authenticatorData", credentialResponse.getString("authenticatorData"))
                .put("clientDataJson", credentialResponse.getString("clientDataJSON"))
                .put("signature", credentialResponse.getString("signature"))
                .put("credentialId", credentialJson.getString("id"))
            result.toString()
        } catch (e: Exception) {
            ""
        }
    }

    suspend fun createPasskey(cyberSubDomain: String, challenge: String): String? {
        val registrationRequestString = """
            {
                "challenge": "$challenge",
                "rp": {
                    "id": "$RPID",
                    "name": "Link3 App"
                },
                "pubKeyCredParams": [
                    {
                        "type": "public-key",
                        "alg": -7
                    }
                ],
                "authenticatorSelection": {
                    "authenticatorAttachment": "platform",
                    "residentKey": "required"
                },
                "user": {
                       "id": "${getEncodedUserId()}",
                       "name": "$cyberSubDomain",
                       "displayName": "$cyberSubDomain"
                   }
            }
        """.trimIndent()
        val request = CreatePublicKeyCredentialRequest(registrationRequestString)
        var response: CreatePublicKeyCredentialResponse? = null
        try {
            response = credentialManager.createCredential(context, request) as CreatePublicKeyCredentialResponse
        } catch (e: CreateCredentialException) {
            handlePasskeyFailure(e)
            if (e.message?.contains("provider") == true) {
                applicationViewModel.loginFail(LOGIN_FAIL_NO_PASSKEY_PROVIDER)
            }
        }
        return response?.registrationResponseJson
    }

    suspend fun fetchCredential(): String? {
        authenticationResponseJson = getSavedCredentials("{\"organizationId\":\"$TURNKEY_ORG_ID\"}")
        return authenticationResponseJson
    }

    private fun getEncodedUserId(): String {
        val random = SecureRandom()
        val bytes = ByteArray(64)
        random.nextBytes(bytes)
        return Base64.encodeToString(
            bytes,
            Base64.NO_WRAP or Base64.URL_SAFE or Base64.NO_PADDING
        )
    }

    private fun handlePasskeyFailure(e: CreateCredentialException) {
        val msg = when (e) {
            is CreatePublicKeyCredentialDomException -> {
                // Handle the passkey DOM errors thrown according to the
                // WebAuthn spec using e.domError
                "An error occurred while creating a passkey, please check logs for additional details."
            }
            is CreateCredentialCancellationException -> {
                // The user intentionally canceled the operation and chose not
                // to register the credential.
                "The user intentionally canceled the operation and chose not to register the credential. Check logs for additional details."
            }
            is CreateCredentialInterruptedException -> {
                // Retry-able error. Consider retrying the call.
                "The operation was interrupted, please retry the call. Check logs for additional details."
            }
            is CreateCredentialProviderConfigurationException -> {
                // Your app is missing the provider configuration dependency.
                // Most likely, you're missing "credentials-play-services-auth".
                "Your app is missing the provider configuration dependency. Check logs for additional details."
            }
            is CreateCredentialUnknownException -> {
                "An unknown error occurred while creating passkey. Check logs for additional details."
            }
            is CreateCredentialCustomException -> {
                // You have encountered an error from a 3rd-party SDK. If you
                // make the API call with a request object that's a subclass of
                // CreateCustomCredentialRequest using a 3rd-party SDK, then you
                // should check for any custom exception type constants within
                // that SDK to match with e.type. Otherwise, drop or log the
                // exception.
                "An unknown error occurred from a 3rd party SDK. Check logs for additional details."
            }
            else -> {
                Timber.tag("hercule").i("Unexpected exception type ${e::class.java.name}")
                "An unknown error occurred."
            }
        }
        Timber.tag("hercule").i("createPasskey failed with exception: $msg with ${e.message}")
    }

    private suspend fun getSavedCredentials(payload: String?): String? {
        val requestJsonString = """
            {
              "challenge": "${if (!TextUtils.isEmpty(payload)) getChallengeFromPayload(payload ?: "{\"organizationId\":\"$TURNKEY_ORG_ID\"}") else getEncodedChallenge()}",
              "timeout": 1800000,
              "userVerification": "required",
              "rpId": "$RPID"
            }
        """.trimIndent()
        val getPublicKeyCredentialOption = GetPublicKeyCredentialOption(requestJsonString, null)
        val result = try {
            credentialManager.getCredential(
                context,
                GetCredentialRequest(
                    listOf(
                        getPublicKeyCredentialOption,
                    )
                )
            )
        } catch (e: Exception) {
            Timber.tag("hercule").i("getCredential failed with exception: ${e.message}")
            if (e is NoCredentialException) {
                applicationViewModel.loginFail(LOGIN_FAIL_NO_PASSKEY)
            }
            return null
        }

        if (result.credential is PublicKeyCredential) {
            val cred = result.credential as PublicKeyCredential
            Timber.tag("hercule").i("get crendential:${cred.authenticationResponseJson}")
            return cred.authenticationResponseJson
        }
        return null
    }

    private fun getChallengeFromPayload(payload: String): String {
        val messageBuffer = payload.toByteArray(StandardCharsets.UTF_8)
        val digest = MessageDigest.getInstance("SHA-256").digest(messageBuffer)
        return Base64.encodeToString(
            digest.toHex().toByteArray(),
            Base64.NO_WRAP or Base64.URL_SAFE or Base64.NO_PADDING
        )
    }

    private fun getEncodedChallenge(): String {
        val random = SecureRandom()
        val bytes = ByteArray(32)
        random.nextBytes(bytes)
        return Base64.encodeToString(
            bytes,
            Base64.NO_WRAP or Base64.URL_SAFE or Base64.NO_PADDING
        )
    }
}