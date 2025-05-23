package com.eryaz.ottolojib4b.activity

import android.content.Context
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.eryaz.ottolojib4b.databinding.BrowserLayoutBinding
import com.eryaz.ottolojib4b.helper.Controller

abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun initViews()
    protected abstract var context: Context?

    private lateinit var binding : BrowserLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BrowserLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        screenSize
        initViews()
    }

    val screenSize: Unit
        get() {
            val display = windowManager.defaultDisplay
            val size = Point()
            display.getSize(size)
            Controller.screenWidth = size.x
            Controller.screenHeight = size.y
        }

    //Method OverLoading..
    fun checkStoreForRememberMe(context: Context?, edt_code: EditText?, edt_userCode: EditText?) {}
    fun checkStoreForRememberMe(context: Context?, edt_code: EditText?) {}
}