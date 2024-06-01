package com.cyberconnect.link3.ui

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.lifecycleScope
import coil.load
import com.cyber.cyberdune.viewmodel.DefaultUserProfile
import com.cyberconnect.link3.R
import com.cyberconnect.link3.databinding.ActivityCyberAccountBinding
import com.cyberconnect.link3.databinding.ActivityReceiveBinding
import com.cyberconnect.link3.databinding.ActivitySendBinding
import com.cyberconnect.link3.utils.Chains
import com.cyberconnect.link3.utils.DuneUtil
import com.cyberconnect.link3.utils.Web3Util
import com.cyberconnect.link3.utils.showSnackBar
import com.cyberconnect.link3.utils.toPx
import com.cyberconnect.link3.utils.toWei
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class SendActivity : SubBaseActivity() {

    private lateinit var binding: ActivitySendBinding

    private val scanLauncher = registerForActivityResult(ScanContract()) { scanResult ->
        Timber.tag("hercule").i("scan qr code: ${scanResult.contents}")

        binding.address.setText(scanResult.contents.substring(scanResult.contents.indexOf("0x")))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySendBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Send"
        setSupportActionBar(binding.actionBar)

        binding.send.setOnClickListener {
            val address = binding.address.text.toString()
            val amount = binding.amount.text.toString()
            AlertDialog.Builder(this)
                .setTitle("Send to")
                .setMessage("Address: $address\n\nAmount: $amount ETH")
                .setPositiveButton("Confirm") {_, _ ->
                    lifecycleScope.launch(Dispatchers.IO) {
                        applicationViewModel.contractCall(
                            address,
                            applicationViewModel.userProfile.value?.walletAddress ?: "",
                            "",
                            Chains.Cyber.chainReference,
                            "0x${amount.toWei().toBigInteger().toString(16)}",
                            {
                                binding.root.post {
                                    binding.root.showSnackBar("Successfully sent!", DuneUtil.PROMPT_INFO)
                                }
                            }
                        ) {

                        }
                    }
                }
                .show()
        }

        binding.scan.setOnClickListener {
            scanLauncher.launch(ScanOptions().setOrientationLocked(false))
        }

    }

}