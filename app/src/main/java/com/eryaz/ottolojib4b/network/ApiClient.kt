package com.eryaz.ottolojib4b.network

import android.annotation.SuppressLint
import com.eryaz.ottolojib4b.helper.Constant.Companion.BASEURL
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import kotlin.Throws
import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.lang.RuntimeException
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object ApiClient {
    private var retrofit: Retrofit? = null

    // Create a trust manager that does not validate certificate chains
    private val unsafeOkHttpClient: OkHttpClient

    // Install the all-trusting trust manager

    // Create an ssl socket factory with our all-trusting manager
    .Builder
        get() = try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts = arrayOf<TrustManager>(
                @SuppressLint("CustomX509TrustManager")
                object : X509TrustManager {
                    @SuppressLint("TrustAllX509TrustManager")
                    @Throws(CertificateException::class)
                    override fun checkClientTrusted(
                        chain: Array<X509Certificate>,
                        authType: String
                    ) {
                    }

                    @SuppressLint("TrustAllX509TrustManager")
                    @Throws(CertificateException::class)
                    override fun checkServerTrusted(
                        chain: Array<X509Certificate>,
                        authType: String
                    ) {
                    }

                    override fun getAcceptedIssuers(): Array<X509Certificate> {
                        return arrayOf()
                    }
                }
            )

            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())

            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = sslContext.socketFactory
            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier { hostname, session1 -> true }
            builder
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    /*
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(2,TimeUnit.MINUTES)
                .writeTimeout(2,TimeUnit.MINUTES)
                .readTimeout(2,TimeUnit.MINUTES)
                .build();*/
    @JvmStatic
    val client: Retrofit?
        get() {
            val gson = GsonBuilder()
                .create()
            /*
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(2,TimeUnit.MINUTES)
                .writeTimeout(2,TimeUnit.MINUTES)
                .readTimeout(2,TimeUnit.MINUTES)
                .build();*/if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(unsafeOkHttpClient.build())
                    .build()
            }
            return retrofit
        }

}