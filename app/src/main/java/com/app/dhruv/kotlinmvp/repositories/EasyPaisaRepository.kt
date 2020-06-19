package com.app.bhaskar.easypaisa.repositories

import com.app.bhaskar.easypaisa.request_model.*
import com.app.bhaskar.easypaisa.response_model.*


interface EasyPaisaRepository {
    fun apiLoginToApp(
        request: LoginRequest,
        successHandler: (LoginResponse?) -> Unit,
        failerHandler: (Throwable?) -> Unit
    )

    fun apiUpdatePassword(
        request: UpdatePasswordRequest,
        successHandler: (UpdatePasswordResponse) -> Unit,
        failerHandler: (Throwable?) -> Unit
    )

    fun apiPasswordResetnToken(
        request: PasswordResetToeknRequest,
        successHandler: (PasswordResetTokenResponse) -> Unit,
        failerHandler: (Throwable?) -> Unit
    )

    fun apiWalletBalance(
        request: WalletBalanceRequest,
        successHandler: (WalletBalanceResponse?) -> Unit,
        failerHandler: (Throwable?) -> Unit
    )

    fun apiUserReqData(
        request: UserRequiredDataRequest,
        succressHandler: (UserRequiredDataResponse) -> Unit,
        failerHansler: (Throwable?) -> Unit
    )
}