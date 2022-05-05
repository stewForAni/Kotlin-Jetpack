package com.stew.kotlinjetpack.viewmodel

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.stew.kotlinjetpack.R

/**
 * Created by stew on 5/5/22.
 * mail: stewforani@gmail.com
 */
class TestViewModelActivity : AppCompatActivity() {

    val TAG = "TestViewModelActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)
        val name = findViewById<TextView>(R.id.name)
        val myViewModel: MyViewModel by viewModels()
        Log.d(TAG, "myViewModel: $myViewModel")
        Log.d(TAG, "onCreate: "+System.currentTimeMillis())
        myViewModel.getUserData().observe(this, {
            Log.d(TAG, "observe: "+System.currentTimeMillis())
            name.text = it.toString()
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

}