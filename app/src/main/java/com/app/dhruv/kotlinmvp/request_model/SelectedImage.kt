package com.app.bhaskar.easypaisa.request_model


import com.google.gson.annotations.SerializedName

data class SelectedImage(
    @SerializedName("photo_pancard")
    var photo_pancard: String? = "",
    @SerializedName("photo_aadhaarcard")
    var photo_aadhaarcard: String? = ""
)