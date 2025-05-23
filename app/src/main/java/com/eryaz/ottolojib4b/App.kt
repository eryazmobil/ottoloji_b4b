package com.eryaz.ottolojib4b

import android.app.Application
import android.content.Context
import com.eryaz.ottolojib4b.helper.Constant
import com.eryaz.ottolojib4b.helper.Util

class App : Application() {

    private var appContext: Context? = null

    override fun onCreate() {
        super.onCreate()
        appContext = this
        Constant.DECODE = Util.decode(appContext as App)
        print(Constant.DECODE)
        println("App Started")
    }
}