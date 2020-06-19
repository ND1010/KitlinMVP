package com.app.bhaskar.easypaisa.repositories


import android.annotation.SuppressLint
import com.app.bhaskar.easypaisa.application.MyApp
import com.app.bhaskar.easypaisa.request_model.*
import com.app.bhaskar.easypaisa.response_model.*
import com.app.bhaskar.easypaisa.restapi.RestApi
import com.app.bhaskar.easypaisa.utils.Utils
import com.pa.models.dao.ResultDataDao
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.schedulers.Schedulers.newThread


class RepositoryImpl(val localSource: ResultDataDao, val mRestApi: RestApi) : EasyPaisaRepository {


    @SuppressLint("CheckResult")
    override fun apiLoginToApp(
        request: LoginRequest,
        successHandler: (LoginResponse?) -> Unit,
        failerHandler: (Throwable?) -> Unit
    ) {
        val request: Flowable<LoginResponse> =
            mRestApi.doApiForLogin(Utils.getRequest(MyApp.getGsonWithExpose().toJson(request)))
        request
            .subscribeOn(newThread())
            .observeOn(mainThread())
            .subscribe(
                {
                    successHandler(it)
                }, { error ->
                    failerHandler(error)
                }
            )
    }

    @SuppressLint("CheckResult")
    override fun apiPasswordResetnToken(
        request: PasswordResetToeknRequest,
        successHandler: (PasswordResetTokenResponse) -> Unit,
        failerHandler: (Throwable?) -> Unit
    ) {
        val request: Flowable<PasswordResetTokenResponse> =
            mRestApi.doApiForPassResetToken(
                Utils.getRequest(
                    MyApp.getGsonWithExpose().toJson(
                        request
                    )
                )
            )
        request
            .subscribeOn(newThread())
            .observeOn(mainThread())
            .subscribe(
                {
                    successHandler(it)
                }, { error ->
                    failerHandler(error)
                }
            )
    }

    @SuppressLint("CheckResult")
    override fun apiUpdatePassword(
        request: UpdatePasswordRequest,
        successHandler: (UpdatePasswordResponse) -> Unit,
        failerHandler: (Throwable?) -> Unit
    ) {
        val request: Flowable<UpdatePasswordResponse> =
            mRestApi.doApiForUpdatePassword(
                Utils.getRequest(
                    MyApp.getGsonWithExpose().toJson(
                        request
                    )
                )
            )
        request
            .subscribeOn(newThread())
            .observeOn(mainThread())
            .subscribe(
                {
                    successHandler(it)
                }, { error ->
                    failerHandler(error)
                }
            )
    }


    @SuppressLint("CheckResult")
    override fun apiWalletBalance(
        request: WalletBalanceRequest,
        successHandler: (WalletBalanceResponse?) -> Unit,
        failerHandler: (Throwable?) -> Unit
    ) {
        val request: Flowable<WalletBalanceResponse> =
            mRestApi.doApiForWalletBalance(
                Utils.getRequest(
                    MyApp.getGsonWithExpose().toJson(
                        request
                    )
                )
            )
        request
            .subscribeOn(newThread())
            .observeOn(mainThread())
            .subscribe(
                {
                    successHandler(it)
                }, { error ->
                    failerHandler(error)
                }
            )
    }

    @SuppressLint("CheckResult")
    override fun apiUserReqData(
        request: UserRequiredDataRequest,
        succressHandler: (UserRequiredDataResponse) -> Unit,
        failerHansler: (Throwable?) -> Unit
    ) {
        val request: Flowable<UserRequiredDataResponse> =
            mRestApi.doApiForUserRequiredData(
                Utils.getRequest(
                    MyApp.getGsonWithExpose().toJson(
                        request
                    )
                )
            )
        request
            .subscribeOn(newThread())
            .observeOn(mainThread())
            .subscribe(
                {
                    succressHandler(it)
                }, { error ->
                    failerHansler(error)
                }
            )
    }


}