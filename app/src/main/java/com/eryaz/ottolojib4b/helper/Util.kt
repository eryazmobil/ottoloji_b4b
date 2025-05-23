package com.eryaz.ottolojib4b.helper

import android.content.Context
import com.eryaz.ottolojib4b.store.Preference.Companion.getInstance
import android.net.ConnectivityManager
import android.provider.Settings
import android.widget.EditText
import android.widget.CheckBox
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception
import java.lang.StringBuilder

object Util {
    fun isNotEditTextEmpty(s: String?): Boolean {
        if (s == null) {
            return false
        }
        return s.length != 0
    }

    fun checkInternetConnection(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

    fun checkResponseValue(response: Response<*>): Boolean {
        return if (response.code() == 200) {
            response.body() != null
        }
        else {
            false;
        }
    }

    fun getImei(context: Context): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }

    //Method OverLoading..
    fun getUserInfosFromStore(
        context: Context?,
        edt_code: EditText,
        edt_password: EditText,
        edt_userCode: EditText,
        checkBox: CheckBox
    ) {
        checkBox.isChecked = getInstance(context)!!.checkBoxStatus!!
        if (getInstance(context)!!.code != null && getInstance(context)!!.code != "") {
            edt_code.setText(getInstance(context)!!.code)
            edt_userCode.setText(getInstance(context)!!.code)
            edt_password.setText(getInstance(context)!!.password)
        } else {
            edt_code.setText("")
            edt_userCode.setText("")
        }
    }

    fun getUserInfosFromStore(
        context: Context?,
        edt_code: EditText,
        edt_password: EditText,
        checkBox: CheckBox
    ) {
        checkBox.isChecked = getInstance(context)!!.checkBoxStatus!!
        if (getInstance(context)!!.code != null && getInstance(context)!!.code != "") {
            edt_code.setText(getInstance(context)!!.code)
            edt_password.setText(getInstance(context)!!.password)
        } else {
            edt_code.setText("")
        }
    }

    fun isNotNullCall(call: Call<*>?) {
        var call = call
        if (call != null && !call.isCanceled) {
            try {
                call.cancel()
            } catch (er: Exception) {
                er.message
            }
            call = null
        }
    }

    fun decode(context: Context): String {
        var decode = ""
        val encrytionCode = getImei(context)
        val strArray = encrytionCode.split("(?!^)").toTypedArray()
        for (i in strArray.indices) {
            decode = when (strArray[i]) {
                "1" -> decode + "A"
                "2" -> decode + "B"
                "3" -> decode + "C"
                "4" -> decode + "D"
                "5" -> decode + "E"
                "6" -> decode + "Z"
                "7" -> decode + "Y"
                "8" -> decode + "X"
                "9" -> decode + "P"
                "0" -> decode + "L"
                else -> decode + strArray[i]
            }
        }
        print(StringBuilder(decode).reverse().toString())
        return StringBuilder(decode).reverse().toString()
    }
}