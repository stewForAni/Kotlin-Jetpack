package com.stew.kotlinjetpack.mvvmsample

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.stew.kotlinjetpack.R

/**
 * Created by stew on 5/10/22.
 * mail: stewforani@gmail.com
 */
class TestUserActivity : AppCompatActivity() {

    private val userModel: UserListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        userModel.getUserLiveData().observe(this, {
            findViewById<TextView>(R.id.user).text = it.toString()
        })

        userModel.getLoadingLiveData().observe(this, {
            findViewById<ProgressBar>(R.id.progressBar).visibility = if (it) View.VISIBLE else View.GONE
        })

        userModel.getUserData()
    }

}