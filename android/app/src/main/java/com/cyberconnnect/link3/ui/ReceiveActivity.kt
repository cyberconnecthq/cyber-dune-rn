package com.cyberconnnect.link3.ui

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
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
import com.cyberconnnect.link3.R
import com.cyberconnnect.link3.databinding.ActivityCyberAccountBinding
import com.cyberconnnect.link3.databinding.ActivityReceiveBinding
import com.cyberconnnect.link3.utils.DuneUtil
import com.cyberconnnect.link3.utils.Web3Util
import com.cyberconnnect.link3.utils.showSnackBar
import com.cyberconnnect.link3.utils.toPx
import com.cyberconnnect.link3.utils.toWei
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class ReceiveActivity : SubBaseActivity() {

    private lateinit var binding: ActivityReceiveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityReceiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Receive"
        setSupportActionBar(binding.actionBar)

        val address = applicationViewModel.userProfile.value?.walletAddress ?: ""

        val encoder = BarcodeEncoder()
        val qrcodeWidth = 121.toPx().toInt()
        val bitmap = encoder.encodeBitmap(
            address,
            BarcodeFormat.QR_CODE,
            qrcodeWidth,
            qrcodeWidth,
            mapOf(EncodeHintType.MARGIN to 0)
        )
        binding.qrcode.load(bitmap)

        binding.address.text = address

        binding.copy.setOnClickListener {
            copyToClipboard(this, it, address, getString(R.string.address_copied))
            binding.copy.setImageResource(R.drawable.icon_copied)
        }

    }

}