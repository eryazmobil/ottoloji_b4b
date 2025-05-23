package com.eryaz.ottolojib4b.network.response.GetCustomerLogin

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Users (
    @SerializedName("AuthorityUser")
    @Expose
    var authorityUser: AuthorityUser? = null,

    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("CustomerId")
    @Expose
    var customerId: Int? = null,

    @SerializedName("Code")
    @Expose
    var code: String? = null,

    @SerializedName("Name")
    @Expose
    var name: String? = null,

    @SerializedName("Password")
    @Expose
    var password: String? = null,

    @SerializedName("RuleCode")
    @Expose
    var ruleCode: String? = null,

    @SerializedName("Type")
    @Expose
    var type: Boolean? = null,

    @SerializedName("Tel")
    @Expose
    var tel: String? = null,

    @SerializedName("City")
    @Expose
    var city: Any? = null,

    @SerializedName("Gsm")
    @Expose
    var gsm: Any? = null,

    @SerializedName("Mail")
    @Expose
    var mail: String? = null,

    @SerializedName("Latitude")
    @Expose
    var latitude: String? = null,

    @SerializedName("Longitude")
    @Expose
    var longitude: String? = null,

    @SerializedName("Rate")
    @Expose
    var rate: Int? = null,

    @SerializedName("Status")
    @Expose
    var status: Boolean? = null,

    @SerializedName("AvatarPath")
    @Expose
    var avatarPath: String? = null,

    @SerializedName("Avatar")
    @Expose
    var avatar: String? = null,

    @SerializedName("OrderTotal")
    @Expose
    var orderTotal: Int? = null,

    @SerializedName("LastLoginDate")
    @Expose
    var lastLoginDate: Any? = null,

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
    var lastUpdateName: Any? = null,
)