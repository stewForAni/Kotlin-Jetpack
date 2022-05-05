package com.stew.kotlinjetpack.livedata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import com.stew.kotlinjetpack.R

/**
 * Created by stew on 5/5/22.
 * mail: stewforani@gmail.com
 */
class TestLiveDataTransformationsActivity : AppCompatActivity() {

    val TAG = "TransformationsActivity"

    private val livedata: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata)
        Log.d(TAG, "onCreate: ")

        val liveMap: LiveData<String> = Transformations.map(livedata, Function {
            return@Function it.toString() + "is str"
        })

        liveMap.observe(this, Observer {
            Log.d(TAG, "liveMap.observe: $it")
        })

        livedata.value = 1

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
        livedata.value = 2    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
        livedata.value = 3
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
        livedata.value = 4
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
        livedata.value = 5
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
        livedata.value = 6
    }


}