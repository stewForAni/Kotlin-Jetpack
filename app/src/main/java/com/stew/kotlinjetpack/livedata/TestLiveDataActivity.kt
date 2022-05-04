package com.stew.kotlinjetpack.livedata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.stew.kotlinjetpack.R

/**
 * Created by stew on 5/1/22.
 * mail: stewforani@gmail.com
 */
class TestLiveDataActivity : AppCompatActivity() {

    val TAG = "TestLiveDataActivity"

    private val livedata: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata)

        //active when this is active
//        livedata.observe(this, {
//           Log.d(TAG, "onChanged: $it")
//        })

        //active all the time
//        livedata.observeForever {
//            Log.d(TAG, "onChanged: $it")
//        }

        MyLiveData.get().observe(this, {
            Log.d(TAG, "MyLiveData onChanged : $it")
        })

        Log.d(TAG, "onCreate: ")
//        livedata.value = "onCreate"

        MyLiveData.get().value = "onCreate"
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
//        livedata.value = "onStart"
        MyLiveData.get().value = "onStart"
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
//        livedata.value = "onResume"
        MyLiveData.get().value = "onResume"
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
//        livedata.value = "onPause"
        MyLiveData.get().value = "onPause"
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
//        livedata.value = "onStop"
        MyLiveData.get().value = "onStop"
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
//        livedata.value = "onDestroy"
        MyLiveData.get().value = "onDestroy"
    }


}