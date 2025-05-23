package com.eryaz.ottolojib4b.network.response.GetCustomerLogin

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Salesman (
    @SerializedName("AuthoritySalesman")
    @Expose
    var authoritySalesman: Any? = null,

    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("Code")
    @Expose
    var code: String? = null,

    @SerializedName("Name")
    @Expose
    var name: String? = null,

    @SerializedName("Tel1")
    @Expose
    var tel1: String? = null,

    @SerializedName("Tel2")
    @Expose
    var tel2: String? = null,

    @SerializedName("Email")
    @Expose
    var email: String? = null,

    @SerializedName("EmailShort")
    @Expose
    var emailShort: String? = null,

    @SerializedName("PicturePath")
    @Expose
    var picturePath: Any? = null,

    @SerializedName("Password")
    @Expose
    var password: String? = null,

    @SerializedName("Prefix")
    @Expose
    var prefix: String? = null,

    @SerializedName("Message")
    @Expose
    var message: String? = null,

    @SerializedName("NumberOfUserB2b")
    @Expose
    var numberOfUserB2b: Int? = null,

    @SerializedName("NumberOfUserAndroid")
    @Expose
    var numberOfUserAndroid: Int? = null,

    @SerializedName("NumberOfUserIos")
    @Expose
    var numberOfUserIos: Int? = null,

    @SerializedName("IntervalTime")
    @Expose
    var intervalTime: Int? = null,

    @SerializedName("NumberOfUser")
    @Expose
    var numberOfUser: Int? = null,

    @SerializedName("CustomerType")
    @Expose
    var customerType: Boolean? = null,

    @SerializedName("NumberOfUserModerator")
    @Expose
    var numberOfUserModerator: Int? = null,

    @SerializedName("AvatarPath")
    @Expose
    var avatarPath: String? = null,

    @SerializedName("Avatar")
    @Expose
    var avatar: Any? = null,

    @SerializedName("LoginIp")
    @Expose
    var loginIp: Any? = null,

    @SerializedName("LoginTime")
    @Expose
    var loginTime: String? = null,

    @SerializedName("TerminalNo")
    @Expose
    var terminalNo: Int? = null,

    @SerializedName("Locked")
    @Expose
    var locked: Boolean? = null,

    @SerializedName("TryCount")
    @Expose
    var tryCount: Int? = null,

    @SerializedName("TryCountStr")
    @Expose
    var tryCountStr: Int? = null,

    @SerializedName("IsAutoLock")
    @Expose
    var isAutoLock: Boolean? = null,

    @SerializedName("SalesmanMode")
    @Expose
    var salesmanMode: Int? = null,

    @SerializedName("SalesmanModeInt")
    @Expose
    var salesmanModeInt: Int? = null,

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