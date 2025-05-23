package com.eryaz.ottolojib4b.network.response.LicanceCheck

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class LicenceCheckResponse(

    @SerializedName("Status")
    @Expose
    var status: Boolean,

    @SerializedName("SessionId")
    @Expose
    var sessionId: String,

    @SerializedName("Message")
    @Expose
    var message: String
    )

