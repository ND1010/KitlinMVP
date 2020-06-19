package com.app.bhaskar.easypaisa.response_model


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message")
    var message: String = "",
    @SerializedName("status")
    var status: String = "",
    @SerializedName("userdata")
    var userdata: Userdata = Userdata()
) {
    data class Userdata(
        @SerializedName("aadhar")
        var aadhar: String = "",
        @SerializedName("aadharpic")
        var aadharpic: String = "",
        @SerializedName("account")
        var account: String = "",
        @SerializedName("address")
        var address: String = "",
        @SerializedName("aepsbalance")
        var aepsbalance: Double = 0.0,
        @SerializedName("aepsidcharge")
        var aepsidcharge: Int = 0,
        @SerializedName("aepslimit")
        var aepslimit: Int = 0,
        @SerializedName("aepslocked")
        var aepslocked: Int = 0,
        @SerializedName("apptoken")
        var apptoken: String = "",
        @SerializedName("balance")
        var balance: Double = 0.0,
        @SerializedName("bank")
        var bank: String = "",
        @SerializedName("callback")
        var callback: String = "",
        @SerializedName("city")
        var city: String = "",
        @SerializedName("company_data")
        var companyData: String = "",
        @SerializedName("company_id")
        var companyId: Int = 0,
        @SerializedName("created_at")
        var createdAt: String = "",
        @SerializedName("distributor")
        var distributor: Any = Any(),
        @SerializedName("email")
        var email: String = "",
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("ifsc")
        var ifsc: String = "",
        @SerializedName("kyc")
        var kyc: String = "",
        @SerializedName("lockedbalance")
        var lockedbalance: Int = 0,
        @SerializedName("logincount")
        var logincount: Int = 0,
        @SerializedName("md")
        var md: Int = 0,
        @SerializedName("mobile")
        var mobile: String = "",
        @SerializedName("name")
        var name: String = "",
        @SerializedName("otp")
        var otp: String = "",
        @SerializedName("pancard")
        var pancard: String = "",
        @SerializedName("pancardpic")
        var pancardpic: String = "",
        @SerializedName("parent_id")
        var parentId: Int = 0,
        @SerializedName("parents")
        var parents: String = "",
        @SerializedName("payout")
        var payout: Any = Any(),
        @SerializedName("payoutmode")
        var payoutmode: String = "",
        @SerializedName("pincode")
        var pincode: String = "",
        @SerializedName("profilepic")
        var profilepic: String = "",
        @SerializedName("remark")
        var remark: Any = Any(),
        @SerializedName("resetpwd")
        var resetpwd: String = "",
        @SerializedName("retailer")
        var retailer: Any = Any(),
        @SerializedName("role")
        var role: Role = Role(),
        @SerializedName("role_id")
        var roleId: Int = 0,
        @SerializedName("scheme_id")
        var schemeId: Int = 0,
        @SerializedName("settlement")
        var settlement: String = "",
        @SerializedName("shopname")
        var shopname: String = "",
        @SerializedName("state")
        var state: String = "",
        @SerializedName("status_id")
        var statusId: Int = 0,
        @SerializedName("tokenamount")
        var tokenamount: Int = 0,
        @SerializedName("updated_at")
        var updatedAt: String = "",
        @SerializedName("utiid")
        var utiid: String = "",
        @SerializedName("utiidstatus")
        var utiidstatus: String = "",
        @SerializedName("utiidtxnid")
        var utiidtxnid: Int = 0
    ) {
        data class Role(
            @SerializedName("created_at")
            var createdAt: String = "",
            @SerializedName("id")
            var id: Int = 0,
            @SerializedName("role_slug")
            var roleSlug: String = "",
            @SerializedName("role_title")
            var roleTitle: String = "",
            @SerializedName("scheme")
            var scheme: Int = 0,
            @SerializedName("updated_at")
            var updatedAt: String = ""
        )
    }
}