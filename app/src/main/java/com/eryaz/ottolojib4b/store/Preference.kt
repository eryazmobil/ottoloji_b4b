package com.eryaz.ottolojib4b.store

import android.content.Context
import android.content.SharedPreferences

class Preference(context: Context?) {
    private val mPreferences: SharedPreferences

    init {
        mPreferences = context!!.getSharedPreferences("SharedPrefs",Context.MODE_PRIVATE)
        mPreferences.edit().apply()
    }

    fun remove(key: String?) {
        mPreferences.edit().remove(key).apply()
    }

    fun setString(key: String?, value: String?) {
        val editor = mPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun setBoolean(key: String?, value: Boolean?) {
        val editor = mPreferences.edit()
        editor.putBoolean(key, value!!)
        editor.apply()
    }

    fun getString(key: String?, defValue: String?): String? {
        return mPreferences.getString(key, defValue)
    }

    fun getFloat(key: String?, defValue: Float): Float {
        return mPreferences.getFloat(key, defValue)
    }

    fun getLong(key: String?, defValue: Long): Long {
        return mPreferences.getLong(key, defValue)
    }

    fun getBoolean(key: String?, defValue: Boolean): Boolean {
        return mPreferences.getBoolean(key, defValue)
    }

    var code: String?
        get() = getString(Keys.CODE, null)
        set(code) {
            setString(Keys.CODE, code)
        }
    var password: String?
        get() = getString(Keys.PASSWORD, null)
        set(password) {
            setString(Keys.PASSWORD, password)
        }
    var userType: String?
        get() = getString(Keys.USER_TYPE, null)
        set(userType) {
            setString(Keys.USER_TYPE, userType)
        }
    var customerId: String?
        get() = getString(Keys.CUSTOMER_ID, null)
        set(customerId) {
            setString(Keys.CUSTOMER_ID, customerId)
        }
    var checkBoxStatus: Boolean?
        get() = getBoolean(Keys.CHECKBOX_STATUS, false)
        set(cb_status) {
            setBoolean(Keys.CHECKBOX_STATUS, cb_status)
        }

    object Keys {
        const val CODE = "CODE"
        const val PASSWORD = "PASSWORD"
        const val USER_TYPE = "USER_TYPE"
        const val CUSTOMER_ID = "CUSTOMER_ID"
        const val CHECKBOX_STATUS = "CHECKBOX_STATUS"
    }

    companion object {
        private var sInstance: Preference? = null
        @JvmStatic
        fun getInstance(context: Context?): Preference? {
            if (sInstance == null) {
                sInstance = Preference(context)
            }
            return sInstance
        }
    }
}