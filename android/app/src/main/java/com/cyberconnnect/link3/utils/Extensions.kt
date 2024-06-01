package com.cyberconnnect.link3.utils

import android.content.res.Resources
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.cyberconnnect.link3.R
import com.cyberconnnect.link3.databinding.PromptToastBinding
import org.web3j.utils.Convert
import java.math.BigDecimal

fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()
fun Int.toPx(): Float = this * Resources.getSystem().displayMetrics.density


fun ByteArray.toHex(): String = joinToString("") { java.lang.Byte.toUnsignedInt(it).toString(radix = 16).padStart(2, '0') }

fun String.decodeHex(): ByteArray {
    return chunked(2)
        .map { it.toInt(16).toByte() }
        .toByteArray()
}

fun String.toWei(unit: Convert.Unit = Convert.Unit.ETHER): BigDecimal = Convert.toWei(this, unit)

fun View.showSnackBar(hint: String, type: Int = DuneUtil.PROMPT_ERROR) {
    if (!TextUtils.isEmpty(hint)) {
//        Snackbar.make(this, hint, Snackbar.LENGTH_LONG).show()
        try {
            var container: ViewGroup? = null
            if (this is FrameLayout) {
                container = this
            } else {
                var parent = this.parent
                while (parent != null && !(parent is FrameLayout && parent.id == android.R.id.content)) {
                    parent = parent.parent
                }
                container = if (parent is ViewGroup) parent else null
            }

            container?.let {
                val binding = PromptToastBinding.inflate(LayoutInflater.from(this.context), container, true)
                binding.icon.setImageResource(if (type == DuneUtil.PROMPT_ERROR) R.drawable.icon_error else R.drawable.icon_checked)
                binding.text.setTextColor(context.getColor(if (type == DuneUtil.PROMPT_ERROR) R.color.error else R.color.success))
                binding.text.text = hint
                binding.root.postDelayed({
                    container.removeView(binding.root)
                }, 3000)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}