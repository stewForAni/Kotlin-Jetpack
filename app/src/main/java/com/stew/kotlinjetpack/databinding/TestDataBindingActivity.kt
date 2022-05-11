package com.stew.kotlinjetpack.databinding

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.stew.kotlinjetpack.R
import com.stew.kotlinjetpack.mvvmsample.UserListViewModel

/**
 * Created by stew on 5/11/22.
 * mail: stewforani@gmail.com
 */
class TestDataBindingActivity : AppCompatActivity() {
    private val userModel: UserListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDatabindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding)

        userModel.getUserLiveData().observe(this, {
            var s = ""
            for (item in it) { s = s + item.name + " / " + item.age + "\n" }
            binding.user = s
        })

        userModel.getLoadingLiveData().observe(this, {
            findViewById<ProgressBar>(R.id.progressBar).visibility = if (it) View.VISIBLE else View.GONE
        })

        userModel.getUserData()
        binding.button1.setOnClickListener { userModel.addUserData() }
        binding.button2.setOnClickListener { userModel.deleteUserData() }
    }
}