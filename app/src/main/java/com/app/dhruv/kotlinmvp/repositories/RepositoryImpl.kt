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
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File


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

//    @SuppressLint("CheckResult")
//    override fun doAgentKyc(
//        request: AgentKycRequest,
//        successHandler: (AgentKycResponse) -> Unit,
//        failerHandler: (Throwable?) -> Unit
//    ) {
//        val token =
//            EasyPaisaApp.getLoggedInUser()!!.apptoken.toRequestBody("text/plain".toMediaTypeOrNull())
//        val user_id =
//            EasyPaisaApp.getLoggedInUser()!!.id.toString()
//                .toRequestBody("text/plain".toMediaTypeOrNull())
//        val merchantName =
//            request.merchantName.toRequestBody("text/plain".toMediaTypeOrNull())
//        val merchantAddress =
//            request.merchantAddress.toRequestBody("text/plain".toMediaTypeOrNull())
//        val merchantCityName =
//            request.merchantCityName.toRequestBody("text/plain".toMediaTypeOrNull())
//        val merchantState =
//            request.merchantState.toRequestBody("text/plain".toMediaTypeOrNull())
//        val merchantPhoneNumber =
//            request.merchantPhoneNumber.toRequestBody("text/plain".toMediaTypeOrNull())
//        val userPan =
//            request.userPan.toRequestBody("text/plain".toMediaTypeOrNull())
//        val merchantPinCode =
//            request.merchantPinCode.toRequestBody("text/plain".toMediaTypeOrNull())
//        val merchantAadhar =
//            request.merchantAadhar.toRequestBody("text/plain".toMediaTypeOrNull())
//        val transactionType =
//            request.transactionType.toRequestBody("text/plain".toMediaTypeOrNull())
//
//        val params = HashMap<String, RequestBody>()
//        params["user_id"] = user_id
//        params["token"] = token
//        params["merchantName"] = merchantName
//        params["merchantAddress"] = merchantAddress
//        params["merchantCityName"] = merchantCityName
//        params["merchantState"] = merchantState
//        params["merchantAadhar"] = merchantAadhar
//        params["merchantPhoneNumber"] = merchantPhoneNumber
//        params["userPan"] = userPan
//        params["merchantPinCode"] = merchantPinCode
//        params["transactionType"] = transactionType
//
//        var bodyPanImage: MultipartBody.Part? = null
//        var bodyAadhaarImage: MultipartBody.Part? = null
//
//        val filePan = File(request.pancardPics)
//        val fbodyPan = filePan.asRequestBody("*/*".toMediaTypeOrNull())
//        params["pancardPics"] = fbodyPan
//        bodyPanImage = MultipartBody.Part.createFormData("pancardPics", filePan.name, fbodyPan)
//
//        val fileAadhaar = File(request.aadharPics)
//        val fbodyAadhaar = fileAadhaar.asRequestBody("*/*".toMediaTypeOrNull())
//        params["aadharPics"] = fbodyAadhaar
//        bodyAadhaarImage =
//            MultipartBody.Part.createFormData("aadharPics", fileAadhaar.name, fbodyAadhaar)
//
//        val request: Flowable<AgentKycResponse> =
//            mRestApi.doApiForAgentKyc(params, bodyPanImage, bodyAadhaarImage)
//        request
//            .subscribeOn(newThread())
//            .observeOn(mainThread())
//            .subscribe(
//                {
//                    successHandler(it)
//                }, { error ->
//                    failerHandler(error)
//                }
//            )
//    }


}