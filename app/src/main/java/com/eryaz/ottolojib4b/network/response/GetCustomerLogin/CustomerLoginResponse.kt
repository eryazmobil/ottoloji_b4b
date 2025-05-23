package com.eryaz.ottolojib4b.network.response.GetCustomerLogin

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class CustomerLoginResponse (
    @SerializedName("Users")
    @Expose
    var users: Users? = null,

    @SerializedName("AuthorityCustomer")
    @Expose
    var authorityCustomer: AuthorityCustomer? = null,

    @SerializedName("Salesman")
    @Expose
    var salesman: Salesman? = null,

    @SerializedName("Id")
    @Expose
    var id: Int? = null,

    @SerializedName("EntegreId")
    @Expose
    var entegreId: Int? = null,

    @SerializedName("SalesmanIdInt")
    @Expose
    var salesmanIdInt: Int? = null,

    @SerializedName("SalesmanId")
    @Expose
    var salesmanId: Int? = null,

    @SerializedName("ShipmentId")
    @Expose
    var shipmentId: Int? = null,

    @SerializedName("Code")
    @Expose
    var code: String? = null,

    @SerializedName("B2bCode")
    @Expose
    var b2bCode: String? = null,

    @SerializedName("Name")
    @Expose
    var name: String? = null,

    @SerializedName("NameShort")
    @Expose
    var nameShort: String? = null,

    @SerializedName("AddressFull")
    @Expose
    var addressFull: String? = null,

    @SerializedName("Address")
    @Expose
    var address: String? = null,

    @SerializedName("City")
    @Expose
    var city: String? = null,

    @SerializedName("Town")
    @Expose
    var town: String? = null,

    @SerializedName("Country")
    @Expose
    var country: Any? = null,

    @SerializedName("TaxOffice")
    @Expose
    var taxOffice: String? = null,

    @SerializedName("TaxNumber")
    @Expose
    var taxNumber: String? = null,

    @SerializedName("Mail")
    @Expose
    var mail: String? = null,

    @SerializedName("CampaignStatu")
    @Expose
    var campaignStatu: Boolean? = null,

    @SerializedName("Status")
    @Expose
    var status: Boolean? = null,

    @SerializedName("ReportCode5")
    @Expose
    var reportCode5: String? = null,

    @SerializedName("PaymentType")
    @Expose
    var paymentType: Int? = null,

    @SerializedName("Tel1")
    @Expose
    var tel1: String? = null,

    @SerializedName("Tel2")
    @Expose
    var tel2: Any? = null,

    @SerializedName("Fax1")
    @Expose
    var fax1: Any? = null,

    @SerializedName("Gsm1")
    @Expose
    var gsm1: Any? = null,

    @SerializedName("Gsm2")
    @Expose
    var gsm2: Any? = null,

    @SerializedName("Notes")
    @Expose
    var notes: Any? = null,

    @SerializedName("RuleCode")
    @Expose
    var ruleCode: String? = null,

    @SerializedName("RuleValue")
    @Expose
    var ruleValue: String? = null,

    @SerializedName("Password")
    @Expose
    var password: Any? = null,

    @SerializedName("NumberOfUser")
    @Expose
    var numberOfUser: Int? = null,

    @SerializedName("NumberOfUserAndroid")
    @Expose
    var numberOfUserAndroid: Int? = null,

    @SerializedName("NumberOfUserIos")
    @Expose
    var numberOfUserIos: Int? = null,

    @SerializedName("IsEnteringInformationPermitted")
    @Expose
    var isEnteringInformationPermitted: Boolean? = null,

    @SerializedName("RiskLimit")
    @Expose
    var riskLimit: Int? = null,

    @SerializedName("CreditLimit")
    @Expose
    var creditLimit: Int? = null,

    @SerializedName("SpecialInstallment")
    @Expose
    var specialInstallment: Boolean? = null,

    @SerializedName("PaymentOnOrder")
    @Expose
    var paymentOnOrder: Boolean? = null,

    @SerializedName("PaymentOnOrderManuel")
    @Expose
    var paymentOnOrderManuel: Boolean? = null,

    @SerializedName("IsCurrentAccountStatu")
    @Expose
    var isCurrentAccountStatu: Boolean? = null,

    @SerializedName("CurrentAccountPassword")
    @Expose
    var currentAccountPassword: String? = null,

    @SerializedName("CurrencyType")
    @Expose
    var currencyType: String? = null,

    @SerializedName("TerminalNo")
    @Expose
    var terminalNo: Int? = null,

    @SerializedName("LoginTime")
    @Expose
    var loginTime: String? = null,

    @SerializedName("LoginIp")
    @Expose
    var loginIp: Any? = null,

    @SerializedName("VatRate")
    @Expose
    var vatRate: Int? = null,

    @SerializedName("IsVatRateActive")
    @Expose
    var isVatRateActive: Boolean? = null,

    @SerializedName("CampaignCode")
    @Expose
    var campaignCode: Any? = null,

    @SerializedName("IsCampaignCodeActive")
    @Expose
    var isCampaignCodeActive: Boolean? = null,

    @SerializedName("IsEditCurrentAccountStatu")
    @Expose
    var isEditCurrentAccountStatu: Boolean? = null,

    @SerializedName("IsConfirmKvkk")
    @Expose
    var isConfirmKvkk: Int? = null,

    @SerializedName("DueDay")
    @Expose
    var dueDay: String? = null,

    @SerializedName("LockBalance")
    @Expose
    var lockBalance: Int? = null,

    @SerializedName("VehicleType")
    @Expose
    var vehicleType: String? = null,

    @SerializedName("ReportCode1")
    @Expose
    var reportCode1: Any? = null,

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