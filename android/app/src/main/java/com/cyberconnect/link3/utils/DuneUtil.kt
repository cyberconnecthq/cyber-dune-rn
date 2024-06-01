package com.cyberconnect.link3.utils

import android.util.Base64
import java.security.SecureRandom

object DuneUtil {

    const val PROMPT_INFO = 1
    const val PROMPT_ERROR = 2

    fun getEncodedChallenge(): String {
        val random = SecureRandom()
        val bytes = ByteArray(32)
        random.nextBytes(bytes)
        return Base64.encodeToString(
            bytes,
            Base64.NO_WRAP or Base64.URL_SAFE or Base64.NO_PADDING
        )
    }
}