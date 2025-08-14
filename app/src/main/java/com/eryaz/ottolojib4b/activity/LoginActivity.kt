package com.eryaz.ottolojib4b.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Process
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.eryaz.ottolojib4b.R
import com.eryaz.ottolojib4b.adapter.PagerLoginAdapter
import com.eryaz.ottolojib4b.databinding.ActivityLoginBinding
import com.eryaz.ottolojib4b.fragment.CustomerFragment
import com.eryaz.ottolojib4b.fragment.SalesmanFragment
import com.eryaz.ottolojib4b.helper.Constant
import com.eryaz.ottolojib4b.helper.Controller
import com.eryaz.ottolojib4b.helper.TabLayoutName
import com.eryaz.ottolojib4b.helper.Util
import com.eryaz.ottolojib4b.network.Api
import com.eryaz.ottolojib4b.network.ApiClient.client
import com.eryaz.ottolojib4b.network.response.GetSession.GetSessionResponse
import com.eryaz.ottolojib4b.network.response.LicanceCheck.LicenceCheckResponse
import com.eryaz.ottolojib4b.store.Preference.Companion.getInstance
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.abs

class LoginActivity : BaseActivity() {
    private lateinit var slideUp: Animation
    var salesmanFragment: SalesmanFragment? = null
    var customerFragment: CustomerFragment? = null
    var position = 0
    var licanceCheckCall: Call<LicenceCheckResponse>? = null
    var getSessionResponseCall: Call<GetSessionResponse>? = null
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rlLoginbutton.setOnClickListener {

            startSlideUpAnimation(binding.rlPagerviews)
            pager
        }
    }

    override fun initViews() {
        slideUp = AnimationUtils.loadAnimation(context, R.anim.slide_up)
        slideUp.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                binding.rlPagerviews.visibility = View.VISIBLE
                binding.rlPagerviews.alpha = 1.0f
                binding.rlLoginbutton.visibility = View.GONE
            }

            override fun onAnimationEnd(animation: Animation) {

            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
    }

    override var context: Context? = null
        get() = this@LoginActivity

    private val pager: Unit
        get() {
            binding.loginTablayout.addTab(
                binding.loginTablayout.newTab().setText(TabLayoutName.first)
            )
            binding.loginTablayout.addTab(
                binding.loginTablayout.newTab().setText(TabLayoutName.second)
            )
            binding.loginTablayout.tabGravity = TabLayout.GRAVITY_CENTER
            val pagerLoginAdapter = context?.let {
                PagerLoginAdapter(
                    supportFragmentManager, binding.loginTablayout.tabCount,
                    it
                )
            }
            binding.loginViewpager.adapter = pagerLoginAdapter
            binding.loginViewpager.setPageTransformer(
                false
            ) { page, position ->
                val normalizedposition = abs(abs(position) - 1)
                page.scaleX = normalizedposition / 2 + 0.5f
                page.scaleY = normalizedposition / 2 + 0.5f
            }
            binding.loginViewpager.addOnPageChangeListener(TabLayoutOnPageChangeListener(binding.loginTablayout))
            binding.loginTablayout.setOnTabSelectedListener(object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    position = tab.position
                    if (position == 0) {
                        binding.loginViewpager.currentItem = position
                    } else if (position == 1) {
                        binding.loginViewpager.currentItem = position
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
        }

    fun startSlideUpAnimation(view: View?) {
        view!!.startAnimation(slideUp)
    }

    override fun onBackPressed() {
        context?.let {
            AlertDialog.Builder(it)
                .setNegativeButton(resources.getString(R.string.cancel))
                { dialog, which -> dialog.dismiss() }
                .setPositiveButton(
                    resources.getString(R.string.accept)
                ) { dialog, which -> finish() }
                .setCancelable(true)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(resources.getString(R.string.warning))
                .setMessage(resources.getString(R.string.r_u_sure_to_exit))
                .show()
        }
    }

    fun licanceCheck(
        userType: Int,
        userId: Int,
        deviceType: Int,
        imei: String,
        customerId: Int,
        latitude: Double,
        longitude: Double,
    ) {
        Util.isNotNullCall(licanceCheckCall)
        val licenceCheckApi = client!!.create(Api::class.java)

        licanceCheckCall = licenceCheckApi.licenceCheckService(
            "LicenceCheck?userType=" + userType + "&userId=" + userId +
                    "&deviceType=" + deviceType + "&IMEI=" + imei + "&Longitude=" + longitude + "&Latitude=" + latitude + "&CustomerId=" + customerId + "&pImei=" + context?.let {
                Util.getImei(
                    it
                )
            } + "&pUniqId=" + Constant.DECODE
        )
        licanceCheckCall!!.enqueue(object : Callback<LicenceCheckResponse> {
            override fun onResponse(
                mcall: Call<LicenceCheckResponse>,
                response: Response<LicenceCheckResponse>
            ) {
                licanceCheckCall = null
                try {
                    if (Util.checkResponseValue(response)) {
                        if (response.body()?.status == true) {
                            getSession(customerId, userType, deviceType, userId)
                        } else {
                            Toast.makeText(
                                context,
                                response.body()?.message ?: "",
                                Toast.LENGTH_SHORT
                            ).show()

                        }
                    } else {
                        Toast.makeText(
                            context, resources.getString(R.string.licence_problem),
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                } catch (ex: NullPointerException) {

                    ex.printStackTrace()
                }
            }

            override fun onFailure(mcall: Call<LicenceCheckResponse>, t: Throwable) {
                Util.isNotNullCall(licanceCheckCall)

                t.printStackTrace()
            }
        })
    }

    fun getSession(
        loginId: Int,
        loginType: Int,
        terminalNo: Int,
        usersId: Int,
    ) {
        Util.isNotNullCall(getSessionResponseCall)
        val getSessionApi = client!!.create(
            Api::class.java
        )
        getSessionResponseCall = getSessionApi.getSessionService(
            "GetSession?loginId=$loginId&loginType=$loginType&terminalNo=$terminalNo&usersId=$usersId&pImei=" + context?.let {
                Util.getImei(
                    it
                )
            } + "&pUniqId=" + Constant.DECODE
        )
        getSessionResponseCall!!.enqueue(object : Callback<GetSessionResponse> {
            override fun onResponse(
                mcall: Call<GetSessionResponse>,
                response: Response<GetSessionResponse>
            ) {
                getSessionResponseCall = null
                try {
                    if (Util.checkResponseValue(response)) {
                        Controller.Session = response.body()!!.sessionId

                        if ((getInstance(context)!!.checkBoxStatus)!!) {
                            val i = Intent(Intent.ACTION_VIEW)
                            i.data = Uri.parse(Constant.B2BADRESS + Controller.Session)
                            startActivity(i)
                            Process.killProcess(Process.myPid())
                        } else {
                            val intent = Intent(context, BrowserActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    } else {
                        Toast.makeText(
                            context, resources.getString(R.string.trouble_while_login),
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                } catch (ex: NullPointerException) {

                    ex.printStackTrace()
                }
            }

            override fun onFailure(mcall: Call<GetSessionResponse>, t: Throwable) {
                Util.isNotNullCall(getSessionResponseCall)
                t.printStackTrace()

            }
        })
    }
}

