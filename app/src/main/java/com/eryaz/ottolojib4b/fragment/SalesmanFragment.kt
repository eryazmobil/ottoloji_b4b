package com.eryaz.ottolojib4b.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.eryaz.ottolojib4b.R
import com.eryaz.ottolojib4b.activity.LoginActivity
import com.eryaz.ottolojib4b.databinding.FragmentSalesmanLoginBinding
import com.eryaz.ottolojib4b.helper.Constant
import com.eryaz.ottolojib4b.helper.IOnBackPressed
import com.eryaz.ottolojib4b.helper.Util
import com.eryaz.ottolojib4b.network.Api
import com.eryaz.ottolojib4b.network.ApiClient.client
import com.eryaz.ottolojib4b.network.response.GetSalesmanLogin.SalesmanLoginResponse
import com.eryaz.ottolojib4b.store.Preference.Companion.getInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SalesmanFragment : Fragment(), IOnBackPressed {
    var salesCall: Call<SalesmanLoginResponse>? = null
    var loginActivity: LoginActivity? = null
    private var _binding: FragmentSalesmanLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSalesmanLoginBinding.inflate(inflater, container, false)
        loginActivity = activity as LoginActivity?
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        
        Log.d("onActivityCreated", "SalesmanFragment: ")
        if (getInstance(context)!!.userType != null && getInstance(
                context
            )!!.userType == "1"
        ) {
            binding.edtCode.let {
                binding.edtPassword.let { it1 ->
                    binding.checkSelectBrowser.let { it2 ->
                        Util.getUserInfosFromStore(context,
                            it, it1, it2
                        )
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {

            if (context?.let { Util.checkInternetConnection(it) } == true) {
                if (Util.isNotEditTextEmpty(binding.edtCode.text.toString()) && Util.isNotEditTextEmpty(binding.edtPassword.text.toString())) {
                    login()
                }
                else {
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

    fun getSalesmanLogin(code: String, password: String) {
        Util.isNotNullCall(salesCall)
        val salesmanLoginApi = client!!.create(Api::class.java)

        salesCall = salesmanLoginApi.getSalesmanLoginService(
            "GetSalesmanLogin?pCode=$code&pPassword=$password&pImei="+
                    context?.let { Util.getImei(it) }+"&pUniqId=${Constant.DECODE}")

        salesCall!!.enqueue(object : Callback<SalesmanLoginResponse>{
            override fun onResponse(call: Call<SalesmanLoginResponse>, response: Response<SalesmanLoginResponse>) {

                salesCall = null
                try {
                    if (Util.checkResponseValue(response)) {
                        getInstance(context)?.userType = "1"
                        getInstance(context)?.code =code
                        getInstance(context)?.password =password
                        response.body()?.authoritySalesman?.salesmanId?.let {
                            getInstance(context)?.userType?.let { it1 ->
                                loginActivity!!.licanceCheck(it1.toInt(), -1, Constant.DEVICETYPE, Util.getImei(context!!), it, 12.2, 12.2)
                            }
                        }
                    }
                    else {

                        Toast.makeText(
                            context,getString(R.string.trouble_while_login),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } catch (ex: NullPointerException) {

                    ex.printStackTrace()
                }

            }

            override fun onFailure(call: Call<SalesmanLoginResponse>, t: Throwable) {

                salesCall = null

                t.printStackTrace()
            }
        })
    }


    private fun login() {

        object : Thread() {
            override fun run() {
                getSalesmanLogin(binding.edtCode.text.toString(), binding.edtPassword.text.toString())
            }
        }.start()
    }

}




