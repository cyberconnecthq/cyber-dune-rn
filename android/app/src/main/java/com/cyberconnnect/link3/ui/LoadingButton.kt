package com.cyberconnnect.link3.ui

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.cyberconnnect.link3.R
import com.cyberconnnect.link3.databinding.LoadingButtonBinding
import com.cyberconnnect.link3.utils.toPx

class LoadingButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var textView: TextView
    private var progressBar: ProgressBar
    private var icon: Drawable?

    var text: String = ""
        set(value) {
            textView?.text = value
            field = value
        }

    init {
        val binding = LoadingButtonBinding.inflate(LayoutInflater.from(context), this)
        textView = binding.loadingButtonText
        progressBar = binding.loadingProgressBar

        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.loadingButton, defStyleAttr, 0)
        textView.text = a.getText(R.styleable.loadingButton_button_text)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
            a.getDimensionPixelSize(R.styleable.loadingButton_text_size, resources.getDimensionPixelSize(R.dimen.text_secondary_size))
                .toFloat()
        )
        val isTextBold = a.getBoolean(R.styleable.loadingButton_text_bold, false)
        if (isTextBold) {
            textView.setTypeface(textView.typeface, Typeface.BOLD)
        }
        a.getColorStateList(R.styleable.loadingButton_text_color)?.let {
            textView.setTextColor(it)
        }
        icon = a.getDrawable(R.styleable.loadingButton_text_icon)
        val iconLocationStart = a.getBoolean(R.styleable.loadingButton_icon_location_start, true)
        icon.let {
            if (iconLocationStart) {
                textView.setCompoundDrawablesWithIntrinsicBounds(it, null, null, null)
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, it, null)
            }
            textView.compoundDrawablePadding = 10.toPx().toInt()
        }
    }

    override fun setEnabled(enabled: Boolean) {
        textView?.isEnabled = enabled
        super.setEnabled(enabled)
    }

    override fun setSelected(selected: Boolean) {
        super.setSelected(selected)
        textView.isSelected = selected
    }

    fun hideProgress() {
        textView?.visibility = View.VISIBLE
        progressBar?.visibility = View.INVISIBLE
    }

    fun showProgress() {
        textView?.visibility = View.INVISIBLE
        progressBar?.visibility = View.VISIBLE
    }

    fun setShowIcon(show: Boolean) {
        if (show && icon != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)
            textView.compoundDrawablePadding = 10.toPx().toInt()
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
        }
    }

    fun setTextColor(color: Int) {
        textView?.setTextColor(color)
    }

    override fun performClick(): Boolean {
        return if (progressBar?.visibility == View.VISIBLE) true else super.performClick()
    }
}