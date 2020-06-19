package com.app.bhaskar.easypaisa.restapi


import com.app.bhaskar.easypaisa.response_model.*
import com.app.bhaskar.easypaisa.utils.Constants
import io.reactivex.Flowable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface RestApi {

    @POST(Constants.ApiMethod.API_LOGIN)
    fun doApiForLogin(@Body request: RequestBody): Flowable<LoginResponse>

    @POST(Constants.ApiMethod.API_FORGOT_PASSWORD)
    fun doApiForUpdatePassword(@Body request: RequestBody): Flowable<UpdatePasswordResponse>

    @POST(Constants.ApiMethod.API_SEND_TOKEN)
    fun doApiForPassResetToken(@Body request: RequestBody): Flowable<PasswordResetTokenResponse>

    @POST(Constants.ApiMethod.API_WALLET_BAL)
    fun doApiForWalletBalance(@Body request: RequestBody): Flowable<WalletBalanceResponse>

    @POST(Constants.ApiMethod.API_USER_REQ_DATA)
    fun doApiForUserRequiredData(@Body request: RequestBody): Flowable<UserRequiredDataResponse>

    /*@GET(Constants.SEARCH)
    @Headers(Constants.HEADER_CONTENT_TYPE)
    fun getTracks(@Query(Constants.PARAM_TERM) term: String): Flowable<Tracks>*/

    /*@GET(Constants.SEARCH)
    @Headers(Constants.HEADER_CONTENT_TYPE)
    fun getTracksmusicVideos(@Query(Constants.PARAM_TERM) term: String, @Query(Constants.PARAM_ENTITY) entity: String): Flowable<Tracks>*/

    /*@POST(Constants.API_LOGIN)
    @FormUrlEncoded
    fun signin(@FieldMap params: Map<String, String>): Flowable<SigninResponse>*/

    /*@POST(Constants.API_SIGN_UP)
    @Multipart
    fun signUP(@PartMap params: HashMap<String, RequestBody>): Flowable<SignUpResponse>

    @POST(Constants.API_SIGN_UP)
    @Multipart
    fun signUP(@PartMap params: HashMap<String, RequestBody>, @Part body: List<MultipartBody.Part>): Flowable<SignUpResponse>

    @POST(Constants.API_CREATE_TASK)
    @Multipart
    fun createTask(@PartMap params: HashMap<String, RequestBody>, @Part body: MultipartBody.Part): Flowable<CreateTaskResponse>*/


}
