package com.eryaz.ottolojib4b.network.response.GetCustomerLogin

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class AuthorityUser (
    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("UserId")
    @Expose
    var userId: Int? = null,

    @SerializedName("_B2b")
    @Expose
    var b2b: Boolean? = null,

    @SerializedName("_Android")
    @Expose
    var android: Boolean? = null,

    @SerializedName("_Ios")
    @Expose
    var ios: Boolean? = null,

    @SerializedName("_CampaignStatu")
    @Expose
    var campaignStatu: Boolean? = null,

    @SerializedName("_LockUser")
    @Expose
    var lockUser: Boolean? = null,

    @SerializedName("_ProductRestoration")
    @Expose
    var productRestoration: Boolean? = null,

    @SerializedName("_RuleActive")
    @Expose
    var ruleActive: Boolean? = null,

    @SerializedName("_ShowQuantity")
    @Expose
    var showQuantity: Boolean? = null,

    @SerializedName("Field")
    @Expose
    var field: Any? = null,

    @SerializedName("Comment")
    @Expose
    var comment: Any? = null,

    @SerializedName("UpdateValue")
    @Expose
    var updateValue: Boolean? = null,

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