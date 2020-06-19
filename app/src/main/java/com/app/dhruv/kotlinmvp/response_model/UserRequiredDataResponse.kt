package com.app.bhaskar.easypaisa.response_model


import com.google.gson.annotations.SerializedName

data class UserRequiredDataResponse(
    @SerializedName("aadharbanks")
    var aadharbanks: List<Aadharbank> = listOf(),
    @SerializedName("aepsbanks")
    var aepsbanks: List<Aepsbank> = listOf(),
    @SerializedName("agent")
    var agent: Agent? = Agent(),
    @SerializedName("state")
    var state: List<State> = listOf()
) {
    data class Aadharbank(
        @SerializedName("bankName")
        var bankName: String = "",
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("iinno")
        var iinno: String = ""
    )

    data class Aepsbank(
        @SerializedName("activeFlag")
        var activeFlag: String = "",
        @SerializedName("bankName")
        var bankName: String = "",
        @SerializedName("details")
        var details: String = "",
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("iinno")
        var iinno: String = "",
        @SerializedName("remarks")
        var remarks: String = "",
        @SerializedName("timestamp")
        var timestamp: String = ""
    )

    data class Agent(
        @SerializedName("aadharPic")
        var aadharPic: String = "",
        @SerializedName("created_at")
        var createdAt: String = "",
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("merchantAadhar")
        var merchantAadhar: String = "",
        @SerializedName("merchantAddress")
        var merchantAddress: String = "",
        @SerializedName("merchantCityName")
        var merchantCityName: String = "",
        @SerializedName("merchantLoginId")
        var merchantLoginId: String = "",
        @SerializedName("merchantLoginPin")
        var merchantLoginPin: String = "",
        @SerializedName("merchantName")
        var merchantName: String = "",
        @SerializedName("merchantPhoneNumber")
        var merchantPhoneNumber: String = "",
        @SerializedName("merchantPinCode")
        var merchantPinCode: String = "",
        @SerializedName("merchantState")
        var merchantState: String = "",
        @SerializedName("pancardPic")
        var pancardPic: String = "",
        @SerializedName("status")
        var status: String = "",
        @SerializedName("updated_at")
        var updatedAt: String = "",
        @SerializedName("user")
        var user: User = User(),
        @SerializedName("user_id")
        var userId: Int = 0,
        @SerializedName("userPan")
        var userPan: String = "",
        @SerializedName("via")
        var via: String = ""
    ) {
        data class User(
            @SerializedName("company")
            var company: Any = Any(),
            @SerializedName("id")
            var id: Int = 0,
            @SerializedName("mobile")
            var mobile: String = "",
            @SerializedName("name")
            var name: String = "",
            @SerializedName("parents")
            var parents: String = "",
            @SerializedName("role")
            var role: Role = Role(),
            @SerializedName("role_id")
            var roleId: Int = 0
        ) {
            data class Role(
                @SerializedName("created_at")
                var createdAt: String = "",
                @SerializedName("id")
                var id: Int = 0,
                @SerializedName("name")
                var name: String = "",
                @SerializedName("scheme")
                var scheme: String = "",
                @SerializedName("slug")
                var slug: String = "",
                @SerializedName("updated_at")
                var updatedAt: String = ""
            )
        }
    }

    data class State(
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("state")
        var state: String = "",
        @SerializedName("stateCode")
        var stateCode: String = "",
        @SerializedName("stateId")
        var stateId: String = ""

    ) {
        override fun toString(): String {
            return state
        }
    }
}