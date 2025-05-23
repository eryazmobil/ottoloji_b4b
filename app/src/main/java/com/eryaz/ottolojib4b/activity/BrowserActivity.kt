package com.eryaz.ottolojib4b.activity


import android.webkit.WebView
import android.annotation.SuppressLint
import android.content.Context
import android.webkit.WebViewClient
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import com.eryaz.ottolojib4b.R
import com.eryaz.ottolojib4b.helper.Constant
import com.eryaz.ottolojib4b.helper.Controller


class BrowserActivity : BaseActivity() {


   private lateinit var webView : WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun initViews() {

        webView= findViewById(R.id.webView)

        val url = intent.getStringExtra("url")

        webView.webViewClient = object : WebViewClient() {
            @Deprecated("Deprecated in Java")
            override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {

            }

            @Deprecated("Deprecated in Java")
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                if (url == Constant.BASE) {
                    val intent = Intent(context, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                view.loadUrl(url)
                return true
            }
        }

        webView.settings.javaScriptEnabled = true
        if (url != null) {
            webView.loadUrl(url)
        } else {
            webView.loadUrl(Constant.B2BADRESS + Controller.Session)
        }
    }

    override var context: Context? = null
        get() = this@BrowserActivity


    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            context?.let {
                AlertDialog.Builder(it)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(resources.getString(R.string.atttention))
                    .setMessage(resources.getString(R.string.r_u_sure_to_exit_B2B))
                    .setCancelable(false)
                    .setNegativeButton(resources.getString(R.string.no)) { dialog, which -> dialog.dismiss() }
                    .setPositiveButton(resources.getString(R.string.yes)) { dialog, which -> finish() }.show()
            }
        }
    }

}