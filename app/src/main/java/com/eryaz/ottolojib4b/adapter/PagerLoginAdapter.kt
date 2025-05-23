package com.eryaz.ottolojib4b.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.eryaz.ottolojib4b.activity.LoginActivity
import com.eryaz.ottolojib4b.fragment.CustomerFragment
import com.eryaz.ottolojib4b.fragment.SalesmanFragment

class PagerLoginAdapter(fm: FragmentManager?, private val mNumOfTabs: Int, context: Context) :
    FragmentStatePagerAdapter(
        fm!!
    ) {
    var loginActivity: LoginActivity

    init {
        loginActivity = context as LoginActivity
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                if (loginActivity.customerFragment == null) {
                    loginActivity.customerFragment = CustomerFragment()
                }
                loginActivity.customerFragment!!
            }
            1 -> {
                if (loginActivity.salesmanFragment == null) {
                    loginActivity.salesmanFragment = SalesmanFragment()
                }
                loginActivity.salesmanFragment!!
            }
            else -> {

                return Fragment()
            }
        }
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }
}