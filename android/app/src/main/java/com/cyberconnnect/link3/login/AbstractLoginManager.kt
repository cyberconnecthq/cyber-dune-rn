package com.cyberconnnect.link3.login

import android.content.Context
import com.cyberconnnect.link3.LoginMutation
import com.cyberconnnect.link3.viewmodel.ApplicationViewModel
import kotlinx.coroutines.CoroutineScope

abstract class AbstractLoginManager(val applicationViewModel: ApplicationViewModel) {

    companion object {
        const val CONTRACT_CALL_ERROR_UNAUTHORIZED = 7000
        const val CONTRACT_CALL_ERROR_WALLET = 7001
        const val CONTRACT_CALL_ERROR_EXCEPTION = 7002
        const val CONTRACT_CALL_ERROR_INSUFFICIENT_BALANCE = 7003
        const val SIGN_ERROR = 7004
        const val SIGN_FAIL = 7005

        const val LOGIN_FAIL_NONE = 0
        const val LOGIN_FAIL_WALLET_CANCEL = 1
        const val LOGIN_FAIL_INVALID_PASSKEY = 2
        const val LOGIN_FAIL_NO_PASSKEY = 3
        const val LOGIN_FAIL_NO_PASSKEY_PROVIDER = 4
        const val LOGIN_FAIL_UNSUPPORTED_API = 5
    }

    abstract fun doInit(context: Context)
    abstract fun doOnActivityDestroyed()
    abstract fun login(scope: CoroutineScope, onSuccess: (token: String?) -> Unit)
    abstract fun logout()
    abstract fun cancelLogin()
    abstract fun contractCall(contractAddress: String, from: String, data: String, chainId: String, value: String, success: () -> Unit, fail: (errorCode: Int) -> Unit)
    abstract fun signMessage(chainId: Int, message: String, success: (signature: String) -> Unit, fail: (errorCode: Int) -> Unit)
}