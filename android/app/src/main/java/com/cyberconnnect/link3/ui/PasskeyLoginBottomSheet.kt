package com.cyberconnnect.link3.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.apollographql.apollo3.api.Optional
import com.cyberconnnect.link3.databinding.PasskeyLoginBottomSheetBinding
import com.cyberconnnect.link3.type.PasskeyAttestation
import com.cyberconnnect.link3.type.PasskeyTransport
import com.cyberconnnect.link3.type.RegisterTurnkeyUserRequest
import com.cyberconnnect.link3.utils.DuneUtil
import com.cyberconnnect.link3.viewmodel.ApplicationViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class PasskeyLoginBottomSheet(val theContext: Context,
                              val coroutineScope: CoroutineScope,
                              val applicationViewModel: ApplicationViewModel,
                              val isCreatingAccount: Boolean = false
): BottomSheetDialog(theContext) {

    private val binding = PasskeyLoginBottomSheetBinding.inflate(LayoutInflater.from(theContext))

    init {
        binding.closeButton.setOnClickListener { dismiss() }

        if (!isCreatingAccount) {
            coroutineScope.launch {
                applicationViewModel.passkeyLogin({
                    applicationViewModel.login(coroutineScope)
                }) {
                    binding.root.post {
                        dismiss()
                    }
                }
            }
        } else {
            coroutineScope.launch {
                try {
                    val userName = getUserName()
                    val challenge = DuneUtil.getEncodedChallenge()
                    val createResponse = JSONObject(applicationViewModel.createPasskey(userName, challenge))
                    val response = createResponse.getJSONObject("response")
                    var transports = Optional.absent<List<PasskeyTransport?>?>()
                    val transportsArray = response.getJSONArray("transports")
                    if (transportsArray.length() > 0) {
                        val list = mutableListOf<PasskeyTransport?>()
                        for (i in 0 until transportsArray.length()) {
                            list.add(
                                PasskeyTransport.safeValueOf(when(transportsArray.getString(i)){
                                "internal" -> "AUTHENTICATOR_TRANSPORT_INTERNAL"
                                "hybrid" -> "AUTHENTICATOR_TRANSPORT_HYBRID"
                                else -> "AUTHENTICATOR_TRANSPORT_INTERNAL"
                            }))
                        }
                        transports = Optional.present(list)
                    }
                    val attestation = PasskeyAttestation(
                        response.getString("attestationObject"),
                        response.getString("clientDataJSON"),
                        createResponse.getString("id"),
                        transports
                    )
                    val request = RegisterTurnkeyUserRequest(challenge, attestation, userName)
                    applicationViewModel.turnkeyUserRegister(coroutineScope, request, {
                        binding.progressGroup.visibility = View.INVISIBLE
                        binding.authenticateGroup.visibility = View.VISIBLE
                    }) {

                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    binding.root.post {
                        dismiss()
                    }
                }
            }
        }

        binding.authenticate.setOnClickListener {
            binding.progressGroup.visibility = View.VISIBLE
            binding.authenticateGroup.visibility = View.INVISIBLE
            coroutineScope.launch {
                applicationViewModel.passkeyLogin({
                    applicationViewModel.login(coroutineScope)
                }) {
                }
            }
        }

        setContentView(binding.root)
    }

    private fun getUserName(): String {
        val currentTime = LocalDateTime.now()
        return "${currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH))} CyberAccount"
    }
}