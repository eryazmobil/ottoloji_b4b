package com.eryaz.ottolojib4b.fragment

import com.eryaz.ottolojib4b.store.Preference.Companion.getInstance
import com.eryaz.ottolojib4b.network.ApiClient.client
import com.eryaz.ottolojib4b.helper.IOnBackPressed
import com.eryaz.ottolojib4b.activity.LoginActivity
import com.eryaz.ottolojib4b.network.response.GetCustomerLogin.CustomerLoginResponse
import com.eryaz.ottolojib4b.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.eryaz.ottolojib4b.databinding.FragmentCustomerLoginBinding
import com.eryaz.ottolojib4b.helper.Constant
import com.eryaz.ottolojib4b.helper.Util
import com.eryaz.ottolojib4b.network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.lang.NullPointerException

class CustomerFragment : Fragment(), IOnBackPressed {
    var loginActivity: LoginActivity? = null
    var custCall: Call<CustomerLoginResponse>? = null
    private var _binding: FragmentCustomerLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomerLoginBinding.inflate(inflater, container, false)
        loginActivity = activity as LoginActivity?
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("onActivityCreated", "CustomerFragment: ")
        if (getInstance(context)!!.userType != null && getInstance(
                context
            )!!.userType == "0"
        ) {
            binding.edtCode.let {
                binding.edtPassword.let { it1 ->
                    binding.edtUserCode.let { it2 ->
                        binding.checkSelectBrowser.let { it3 ->
                            Util.getUserInfosFromStore(
                                context,
                                it,
                                it1,
                                it2,
                                it3
                            )
                        }
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {

            if (context?.let { Util.checkInternetConnection(it) } == true) {
                if (Util.isNotEditTextEmpty(binding.edtUserCode.text.toString())
                    && Util.isNotEditTextEmpty(binding.edtPassword.text.toString())
                    && Util.isNotEditTextEmpty(binding.edtCode.text.toString())
                ) {
                    login()
                } else {
                    Toast.makeText(
                        context,
                        resources.getString(R.string.please_fill_all_input),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.please_check_your_connection),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.checkSelectBrowser.setOnCheckedChangeListener { checkSelectBrowser, isChecked ->

            if (checkSelectBrowser.isChecked) {
                binding.checkSelectBrowser.isChecked = true
                getInstance(context)!!.checkBoxStatus = true
            } else {
                checkSelectBrowser.isChecked = false
                getInstance(context)!!.checkBoxStatus = false
            }
        }
    }

    override fun onBackPressed(): Boolean {
        return true
    }

    fun getCustomerLogin(code: String, password: String, userCode: String) {

        if (custCall != null && !custCall!!.isCanceled) {
            try {
                custCall!!.cancel()
            } catch (er: Exception) {
                er.message
            }
            custCall = null
        }
        val customerLoginApi = client!!.create(Api::class.java)

        custCall = customerLoginApi.getCustomerLoginService(
            "GetCustomerLogin?pCode=$code&pUserCode=$userCode&pPassword=$password&pImei=" + context?.let {
                Util.getImei(it)
            } + "&pUniqId=" + Constant.DECODE)

        custCall!!.enqueue(object : Callback<CustomerLoginResponse> {
            override fun onResponse(
                mcall: Call<CustomerLoginResponse>,
                response: Response<CustomerLoginResponse>
            ) {
                custCall = null
                try {
                    if (Util.checkResponseValue(response)) {
                        getInstance(context)!!.userType = "0"
                        getInstance(context)!!.code = code
                        getInstance(context)!!.password = password
                        response.body()!!
                            .users?.let {
                                response.body()!!.authorityCustomer?.let { it1 ->
                                    context?.let { it2 -> Util.getImei(it2) }?.let { it3 ->
                                        it.id?.let { it2 ->
                                            it1.customerId?.let { it4 ->
                                                loginActivity!!.licanceCheck(
                                                    getInstance(context)!!.userType!!.toInt(),
                                                    it2,
                                                    Constant.DEVICETYPE,
                                                    it3,
                                                    it4,
                                                    12.2,
                                                    12.2
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                    } else {
                        Toast.makeText(
                            context,
                            resources.getString(R.string.trouble_while_login),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } catch (ex: NullPointerException) {

                    ex.printStackTrace()
                }
            }

            override fun onFailure(mcall: Call<CustomerLoginResponse>, t: Throwable) {
                custCall = null
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
                t.printStackTrace()

            }
        })
    }

    private fun login() {

        object : Thread() {
            override fun run() {
                getCustomerLogin(
                    binding.edtUserCode.text.toString(),
                    binding.edtPassword.text.toString(),
                    binding.edtCode.text.toString()
                )
            }
        }.start()
    }
}


