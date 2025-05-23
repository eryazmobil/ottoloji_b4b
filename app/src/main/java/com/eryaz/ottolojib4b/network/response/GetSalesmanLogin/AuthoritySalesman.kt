package com.eryaz.ottolojib4b.network.response.GetSalesmanLogin

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class AuthoritySalesman(
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("SalesmanId")
    @Expose
    var salesmanId: Int? = null,

    @SerializedName("B2b")
    @Expose
    var b2b: Boolean? = null,

    @SerializedName("Moderator")
    @Expose
    var moderator: Boolean? = null,

    @SerializedName("Android")
    @Expose
    var android: Boolean? = null,

    @SerializedName("Ios")
    @Expose
    var ios: Boolean? = null,

    @SerializedName("CampaignStatu")
    @Expose
    var campaignStatu: Boolean? = null,

    @SerializedName("EnteringInformation")
    @Expose
    var enteringInformation: Boolean? = null,

    @SerializedName("LockSalesman")
    @Expose
    var lockSalesman: Boolean? = null,

    @SerializedName("HidePassword")
    @Expose
    var hidePassword: Boolean? = null,

    @SerializedName("CustomerType")
    @Expose
    var customerType: Boolean? = null,

    @SerializedName("Collecting")
    @Expose
    var collecting: Boolean? = null,

    @SerializedName("CheckBasket")
    @Expose
    var checkBasket: Boolean? = null,

    @SerializedName("ProductRestoration")
    @Expose
    var productRestoration: Boolean? = null,

    @SerializedName("UpdateValue")
    @Expose
    var updateValue: Boolean? = null,

    @SerializedName("Field")
    @Expose
    var field: Any? = null,

    @SerializedName("Comment")
    @Expose
    var comment: Any? = null,

    @SerializedName("WebLogin")
    @Expose
    var webLogin: Boolean? = null,

    @SerializedName("CreateDate")
    @Expose
    var createDate: String? = null,

    @SerializedName("CreateDateStr")
    @Expose
    var createDateStr: Any? = null,

    @SerializedName("CreateId")
    @Expose
    var createId: Int? = null,

    @SerializedName("EditDate")
    @Expose
    var editDate: Any? = null,

    @SerializedName("EditDateStr")
    @Expose
    var editDateStr: Any? = null,

    @SerializedName("EditId")
    @Expose
    var editId: Int? = null,

    @SerializedName("Deleted")
    @Expose
    var deleted: Boolean? = null,

    @SerializedName("CreateName")
    @Expose
    var createName: Any? = null,

    @SerializedName("LastUpdateName")
    @Expose
    var lastUpdateName: Any? = null
)