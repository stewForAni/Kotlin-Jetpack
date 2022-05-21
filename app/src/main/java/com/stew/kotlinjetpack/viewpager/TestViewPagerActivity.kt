package com.stew.kotlinjetpack.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.stew.kotlinjetpack.R
import com.stew.kotlinjetpack.databinding.ActivityViewpagerBinding
import com.stew.kotlinjetpack.navigation.Test1Fragment
import com.stew.kotlinjetpack.navigation.Test2Fragment
import com.stew.kotlinjetpack.navigation.Test3Fragment

/**
 * Created by stew on 5/21/22.
 * mail: stewforani@gmail.com
 */
class TestViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)

        val binding: ActivityViewpagerBinding = DataBindingUtil.setContentView(this, R.layout.activity_viewpager)

        val adapter = ViewPagerAdapter(supportFragmentManager).apply {
            addFragment(Test1Fragment())
            addFragment(Test2Fragment())
            addFragment(Test3Fragment())
        }

        binding.viewpager.adapter = adapter
        binding.viewpager.offscreenPageLimit = 2
    }


}