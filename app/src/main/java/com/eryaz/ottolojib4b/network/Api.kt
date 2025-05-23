package com.eryaz.ottolojib4b.network

import retrofit2.http.POST
import retrofit2.http.Url
import com.eryaz.ottolojib4b.network.response.GetSalesmanLogin.SalesmanLoginResponse
import com.eryaz.ottolojib4b.network.response.GetCustomerLogin.CustomerLoginResponse
import com.eryaz.ottolojib4b.network.response.LicanceCheck.LicenceCheckResponse
import com.eryaz.ottolojib4b.network.response.GetSession.GetSessionResponse
import retrofit2.Call

interface Api {
    @POST
    fun getSalesmanLoginService(@Url url: String?): Call<SalesmanLoginResponse>

    @POST
    fun getCustomerLoginService(@Url url: String?): Call<CustomerLoginResponse>

    @POST
    fun licenceCheckService(@Url url: String?): Call<LicenceCheckResponse>

    @POST
    fun getSessionService(@Url url: String?): Call<GetSessionResponse>
}