package com.cyberconnect.link3.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.cyber.cyberdune.viewmodel.DefaultUserProfile
import com.cyberconnect.link3.MainApplication
import com.cyberconnect.link3.R
import com.cyberconnect.link3.utils.DuneUtil
import com.cyberconnect.link3.utils.showSnackBar
import com.cyberconnect.link3.viewmodel.ApplicationViewModel

open class BaseActivity : AppCompatActivity() {

    protected val applicationViewModel: ApplicationViewModel by lazy {
        (application as MainApplication).applicationModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // In case query user profile failed earlier.
        if (applicationViewModel.isLoggedIn() && applicationViewModel.userProfile.value == DefaultUserProfile) {
            applicationViewModel.queryHeader(lifecycleScope)
        }
        applicationViewModel.initPasskeyLoginManager(this)
    }

    override fun onResume() {
        super.onResume()
        if (this !is CyberDuneLoginActivity) {
            applicationViewModel.queryHeader(lifecycleScope)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        applicationViewModel.onActivityDestroyed()
    }

    fun copyToClipboard(context: Context, view: View, content: String, description: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip: ClipData = ClipData.newPlainText(description, content)
        clipboard.setPrimaryClip(clip)
        view.showSnackBar(if (!TextUtils.isEmpty(description)) description else context.getString(R.string.event_detail_location_copied), DuneUtil.PROMPT_INFO)
    }

}