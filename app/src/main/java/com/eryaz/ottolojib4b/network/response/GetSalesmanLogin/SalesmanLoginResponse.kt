package com.eryaz.ottolojib4b.network.response.GetSalesmanLogin

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class SalesmanLoginResponse(
    @SerializedName("AuthoritySalesman")
    @Expose
    var authoritySalesman: AuthoritySalesman,

    @SerializedName("Id")
    @Expose
    var id: Int,

    @SerializedName("Code")
    @Expose
    var code: String,

    @SerializedName("Name")
    @Expose
    var name: String,

    @SerializedName("Tel1")
    @Expose
    var tel1: String,

    @SerializedName("Tel2")
    @Expose
    var tel2: String,

    @SerializedName("Email")
    @Expose
    var email: String,

    @SerializedName("EmailShort")
    @Expose
    var emailShort: String,

    @SerializedName("PicturePath")
    @Expose
    var picturePath: String,

    @SerializedName("Password")
    @Expose
    var password: String,

    @SerializedName("Prefix")
    @Expose
    var prefix: Any,

    @SerializedName("Message")
    @Expose
    var message: Any,

    @SerializedName("NumberOfUserB2b")
    @Expose
    var numberOfUserB2b: Int,

    @SerializedName("NumberOfUserAndroid")
    @Expose
    var numberOfUserAndroid: Int,

    @SerializedName("NumberOfUserIos")
    @Expose
    var numberOfUserIos: Int,

    @SerializedName("IntervalTime")
    @Expose
    var intervalTime: Int,

    @SerializedName("NumberOfUser")
    @Expose
    var numberOfUser: Int,

    @SerializedName("CustomerType")
    @Expose
    var customerType: Boolean,

    @SerializedName("NumberOfUserModerator")
    @Expose
    var numberOfUserModerator: Int,

    @SerializedName("AvatarPath")
    @Expose
    var avatarPath: String,

    @SerializedName("Avatar")
    @Expose
    var avatar: Any,

    @SerializedName("LoginIp")
    @Expose
    var loginIp: Any,

    @SerializedName("LoginTime")
    @Expose
    var loginTime: String,

    @SerializedName("TerminalNo")
    @Expose
    var terminalNo: Int,

    @SerializedName("Locked")
    @Expose
    var locked: Boolean,

    @SerializedName("TryCount")
    @Expose
    var tryCount: Int,

    @SerializedName("TryCountStr")
    @Expose
    var tryCountStr: Int,

    @SerializedName("IsAutoLock")
    @Expose
    var isAutoLock: Boolean,

    @SerializedName("SalesmanMode")
    @Expose
    var salesmanMode: Int,

    @SerializedName("SalesmanModeInt")
    @Expose
    var salesmanModeInt: Int,

    @SerializedName("CreateDate")
    @Expose
    var createDate: String,

    @SerializedName("CreateDateStr")
    @Expose
    var createDateStr: Any,

    @SerializedName("CreateId")
    @Expose
    var createId: Int,

    @SerializedName("EditDate")
    @Expose
    var editDate: Any,

    @SerializedName("EditDateStr")
    @Expose
    var editDateStr: Any,

    @SerializedName("EditId")
    @Expose
    var editId: Int,

    @SerializedName("Deleted")
    @Expose
    var deleted: Boolean,

    @SerializedName("CreateName")
    @Expose
    var createName: Any,

    @SerializedName("LastUpdateName")
    @Expose
    var lastUpdateName: Any
   )