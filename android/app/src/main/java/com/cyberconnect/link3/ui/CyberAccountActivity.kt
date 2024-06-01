package com.cyberconnect.link3.ui

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.lifecycleScope
import com.cyber.cyberdune.viewmodel.DefaultUserProfile
import com.cyberconnect.link3.R
import com.cyberconnect.link3.databinding.ActivityCyberAccountBinding
import com.cyberconnect.link3.utils.DuneUtil
import com.cyberconnect.link3.utils.Web3Util
import com.cyberconnect.link3.utils.showSnackBar
import com.cyberconnect.link3.utils.toWei
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class CyberAccountActivity : SubBaseActivity() {

    private lateinit var binding: ActivityCyberAccountBinding
    private var linkWalletToken: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCyberAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Passkey Wallet"
        setSupportActionBar(binding.actionBar)

        binding.depositBg.setOnClickListener {
            startActivity(Intent(this, ReceiveActivity::class.java))
        }
        binding.withdrawBg.setOnClickListener {
            startActivity(Intent(this, SendActivity::class.java))
        }

        applicationViewModel.userProfile.observe(this) { profile ->
            Timber.tag("hercule").i("userprofile:${applicationViewModel.userProfile.value}")
            binding.name.text = profile.walletAddress
            binding.aaCopy.setOnClickListener {
                copyToClipboard(this, it, profile.walletAddress ?: "", getString(R.string.address_copied))
                binding.aaCopy.setImageResource(R.drawable.icon_copied)
            }
            queryEthBalance()
        }

        binding.refreshWallets.setOnClickListener {
            queryEthBalance()
            val animator = ObjectAnimator.ofPropertyValuesHolder(it, PropertyValuesHolder.ofFloat(
                AdapterView.ROTATION, 0f, 360f))
            animator.duration = 500
            animator.repeatMode = ValueAnimator.REVERSE
            animator.repeatCount = 2
            animator.start()
        }

        applicationViewModel.web3jCreated.observe(this) {
            queryEthBalance()
        }
    }

    private fun queryEthBalance() {
        lifecycleScope.launch {
            val balance = Web3Util.getEthBalance(applicationViewModel.userProfile.value?.walletAddress ?: "")
            binding.messageCredit.text = "${String.format("%.7f", balance)} ETH"
        }
    }
}