package com.app.bhaskar.easypaisa.request_model


import com.google.gson.annotations.SerializedName

data class AgentKycRequest(
    @SerializedName("aadharPics")
    var aadharPics: String = "",
    @SerializedName("merchantAadhar")
    var merchantAadhar: String = "",
    @SerializedName("merchantAddress")
    var merchantAddress: String = "",
    @SerializedName("merchantCityName")
    var merchantCityName: String = "",
    @SerializedName("merchantName")
    var merchantName: String = "",
    @SerializedName("merchantPhoneNumber")
    var merchantPhoneNumber: String = "",
    @SerializedName("merchantPinCode")
    var merchantPinCode: String = "",
    @SerializedName("merchantState")
    var merchantState: String = "",
    @SerializedName("pancardPics")
    var pancardPics: String = "",
    @SerializedName("token")
    var token: String = "",
    @SerializedName("transactionType")
    var transactionType: String = "",
    @SerializedName("user_id")
    var userId: String = "",
    @SerializedName("userPan")
    var userPan: String = ""
)