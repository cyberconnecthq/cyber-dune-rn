package com.cyberconnnect.link3.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.cyberconnnect.link3.R
import com.cyberconnnect.link3.databinding.SubpageActionBarBinding

/**
 * The base Activity for sub pages whose ActionBar includes a back icon and page title.
 */
open class SubBaseActivity:  BaseActivity(){

    private lateinit var binding: SubpageActionBarBinding

    override fun setSupportActionBar(toolbar: Toolbar?) {
        super.setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        binding = SubpageActionBarBinding.inflate(LayoutInflater.from(this))
        binding.pageTitle.text = title
        binding.backClick.setOnClickListener {
            finish()
        }

        val rightView = createRightView()
        rightView?.let {
            val originLayoutParams = it.layoutParams
            val layoutParams = ConstraintLayout.LayoutParams(originLayoutParams?.width ?: LayoutParams.WRAP_CONTENT, originLayoutParams?.height ?: LayoutParams.WRAP_CONTENT)
            layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
            layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            layoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            layoutParams.marginEnd = resources.getDimensionPixelSize(R.dimen.page_general_padding)
            binding.root.addView(it, layoutParams)
        }

        supportActionBar?.setCustomView(binding.root, ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
    }

    fun changeTitle(title: String) {
        binding.pageTitle.text = title
    }

    protected open fun createRightView(): View? = null
}