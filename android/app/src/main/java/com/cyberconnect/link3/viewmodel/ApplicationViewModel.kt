package com.cyberconnect.link3.viewmodel

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cyber.cyberdune.viewmodel.DefaultUserProfile
import com.cyber.cyberdune.viewmodel.UserProfile
import com.cyberconnect.link3.ApolloClient
import com.cyberconnect.link3.HeaderQuery
import com.cyberconnect.link3.TurnkeyUserRegisterMutation
import com.cyberconnect.link3.fragment.Price
import com.cyberconnect.link3.login.AbstractLoginManager
import com.cyberconnect.link3.login.PasskeyLoginManager
import com.cyberconnect.link3.type.Attestation_Status
import com.cyberconnect.link3.type.Attestation_Type
import com.cyberconnect.link3.type.HeadlineType
import com.cyberconnect.link3.type.MeResponse_Status
import com.cyberconnect.link3.type.PersonalDisplayName_Type
import com.cyberconnect.link3.type.RegisterTurnkeyUserRequest
import com.cyberconnect.link3.type.RegisterTurnkeyUserResponse_Status
import com.cyberconnect.link3.utils.Web3Util
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.web3j.crypto.Keys
import timber.log.Timber
import kotlin.math.pow

class ApplicationViewModel: ViewModel() {

    companion object Const {
        const val PREF_KEY_SIGNING_KEY_REGISTERED = "signing_key_registered_"
        const val PREF_KEY_ACCESS_TOKEN = "access_token"
        const val PREF_KEY_WALLET = "wallet"
        const val PREF_KEY_DARK_MODE = "dark_mode"
        const val PREF_KEY_SPLASH_GUIDE_VERSION = "splash_guide_version"
        const val PREF_KEY_NOTIFICATION_PERMISSION_VERSION = "notification_permission_version"
        const val PREF_KEY_FCM_TOKEN = "fcm_token"
        const val PREF_KEY_UUID = "uuid_"
        const val PREF_KEY_PAIRING_TOPIC = "pairing_topic"
        const val PREF_KEY_CREDENTIAL_ID = "credential_id"
        const val PREF_KEY_FIRST_CONNECT = "first_connect_"
        const val PREF_KEY_PAID_DM_GUIDE = "paid_dm_guide"
        const val PREF_KEY_FIRST_REPLY_CONGRATULATION = "first_reply_congratulation"
        const val PREF_KEY_ONBOARDING_VERIFIED = "onboarding_verified_"
        const val PREF_KEY_SHOW_ONBOARDING = "show_onboarding_"

        const val SPLASH_GUIDE_VERSION = 1
        const val NOTIFICATION_PERMISSION_REQUEST_VERSION = 1
        const val HISTORY_PREF_KEY = "search_history"
    }

    private val _userProfile = MutableLiveData<UserProfile>()
    val userProfile: LiveData<UserProfile>
        get() = _userProfile

    private val _loginFailType = MutableLiveData<Int>()
    val loginFailType: LiveData<Int>
        get() = _loginFailType

    private val _web3jCreated = MutableLiveData<Boolean>()
    val web3jCreated: LiveData<Boolean>
        get() = _web3jCreated

    private lateinit var context: Context
    private lateinit var loginManager: AbstractLoginManager
    private lateinit var passkeyLoginManager: PasskeyLoginManager
    private var accessToken: String? = null
    lateinit var sharedPref: SharedPreferences

    fun init(context: Context) {
        this.context = context
        sharedPref =
            context.getSharedPreferences("com.cyberconnect.link3.preference", Context.MODE_PRIVATE)
        accessToken = sharedPref.getString(PREF_KEY_ACCESS_TOKEN, "")

        val credentialId = sharedPref.getString(PREF_KEY_CREDENTIAL_ID, "") ?: ""
        passkeyLoginManager = PasskeyLoginManager(this, credentialId)
        loginManager = passkeyLoginManager

        if (!TextUtils.isEmpty(accessToken)) {
            ApolloClient.accessToken = accessToken!!
        }

        GlobalScope.launch(Dispatchers.Default) {
            Web3Util.createWeb3j {
                _web3jCreated.postValue(true)
            }
        }
    }

    fun contractCall(
        contractAddress: String,
        from: String,
        params: String,
        chainId: String,
        value: String,
        success: () -> Unit,
        fail: (errorCode: Int) -> Unit
    ) {
        loginManager.contractCall(contractAddress, from, params, chainId, value, success, fail)
    }

    fun initPasskeyLoginManager(context: Context) {
        passkeyLoginManager.doInit(context)
    }

    suspend fun createPasskey(userName: String, challenge: String): String? {
        loginManager = passkeyLoginManager
        return passkeyLoginManager.createPasskey(userName, challenge)
    }

    suspend fun passkeyLogin(success: () -> Unit, fail: () -> Unit) {
        loginManager = passkeyLoginManager
        val credentialData = passkeyLoginManager.fetchCredential()
        withContext(Dispatchers.Main) {
            if (!TextUtils.isEmpty(credentialData)) {
                success()
            } else {
                fail()
            }
        }
    }

    fun login(scope: CoroutineScope) {
        loginManager.login(scope) { token ->
            accessToken = token ?: ""
            sharedPref.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply()
            if (loginManager is PasskeyLoginManager) {
                sharedPref.edit()
                    .putString(PREF_KEY_CREDENTIAL_ID, passkeyLoginManager.credentialId).apply()
            }
            ApolloClient.accessToken = accessToken!!
            queryHeader(scope)
        }
    }

    fun turnkeyUserRegister(
        scope: CoroutineScope,
        input: RegisterTurnkeyUserRequest,
        success: () -> Unit,
        fail: () -> Unit
    ) {
        scope.launch {
            try {
                val mutation = TurnkeyUserRegisterMutation(input)
                val response = ApolloClient.apolloClient.mutation(mutation).execute()
                Timber.tag("hercule").i("turnkeyUserRegister result: ${response.data}")
                if (response.data?.turnkeyUserRegister?.status == RegisterTurnkeyUserResponse_Status.SUCCESS) {
                    withContext(Dispatchers.Main) {
                        success()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        fail()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    fail()
                }
            }
        }
    }

    fun isLoggedIn() = !TextUtils.isEmpty(accessToken)

    fun logout() {
        accessToken = ""
        ApolloClient.accessToken = ""
        sharedPref.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken)
            .remove(PREF_KEY_PAIRING_TOPIC)
            .remove(PREF_KEY_CREDENTIAL_ID)
            .remove(HISTORY_PREF_KEY)
            .apply()
        _userProfile.value = DefaultUserProfile
        loginManager.logout()
    }

    fun loginFail(type: Int) {
        _loginFailType.postValue(type)
    }

    fun onActivityDestroyed() {
        loginManager.doOnActivityDestroyed()
        passkeyLoginManager.doOnActivityDestroyed()
    }

    fun queryHeader(scope: CoroutineScope) {
        scope.launch {
            try {
                val query = HeaderQuery()
                val response = ApolloClient.apolloClient.query(query).execute()

                withContext(Dispatchers.Main) {
                    when (response.data?.me?.status) {
                        MeResponse_Status.SUCCESS -> {
                            val userData = response.data?.me?.data
                            accessToken = userData?.privateInfo?.accessToken ?: ""
                            val address = userData?.privateInfo?.address as String?
                            sharedPref.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).putString(
                                PREF_KEY_WALLET, address).apply()
                            _userProfile.value = UserProfile(
                                accessToken = accessToken,
                                walletAddress = address,
                                userId = userData?.id ?: "",
                                subOrgId = userData?.turnkeyUserInfo?.subOrgId ?: "",
                            )
                        }

                        MeResponse_Status.NOT_LOGIN -> {
                            if (isLoggedIn()) {
                                logout()
                            }
                        }

                        else -> {}
                    }

                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}