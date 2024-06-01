package com.cyberconnect.link3.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.cyber.cyberdune.viewmodel.DefaultUserProfile
import com.cyberconnect.link3.MainApplication
import com.cyberconnect.link3.databinding.ActivityCyberDuneBinding
import com.cyberconnect.link3.viewmodel.ApplicationViewModel

class CyberDuneLoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (applicationViewModel.isLoggedIn()) {
            startActivity(Intent(this, CyberAccountActivity::class.java))
            finish()
        }

        val binding = ActivityCyberDuneBinding.inflate(layoutInflater)
        var passkeyBottomSheet: PasskeyLoginBottomSheet? = null
        binding.passkeyCreate.setOnClickListener {
            passkeyBottomSheet = PasskeyLoginBottomSheet(this, lifecycleScope, applicationViewModel, true)
            passkeyBottomSheet?.show()
        }
        binding.passkeyLogin.setOnClickListener {
            passkeyBottomSheet = PasskeyLoginBottomSheet(this, lifecycleScope, applicationViewModel)
            passkeyBottomSheet?.show()
        }

        applicationViewModel.userProfile.observe(this) {
            if (it != DefaultUserProfile && !isFinishing) {
                startActivity(Intent(this, CyberAccountActivity::class.java))
                finish()
            }
        }
        setContentView(binding.root)
    }
}