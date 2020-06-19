package com.app.bhaskar.easypaisa.request_model


import com.google.gson.annotations.SerializedName

data class WalletBalanceRequest(
    @SerializedName("apptoken")
    var apptoken: String = "",
    @SerializedName("user_id")
    var userId: String = ""
)