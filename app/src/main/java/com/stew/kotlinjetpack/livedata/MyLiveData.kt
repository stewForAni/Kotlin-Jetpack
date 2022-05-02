package com.stew.kotlinjetpack.livedata

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import java.lang.System.currentTimeMillis

/**
 * Created by stew on 5/2/22.
 * mail: stewforani@gmail.com
 */
class MyLiveData : LiveData<String>() {
    override fun onActive() {
        super.onActive()
        value = "onActive"+ currentTimeMillis()
    }

    override fun onInactive() {
        super.onInactive()
        Log.d("TestLiveDataActivity", "onInactive")
    }

    companion object {
        lateinit var sInstance: MyLiveData

        @MainThread
        fun get(): MyLiveData {
            sInstance = if (this::sInstance.isInitialized) sInstance else MyLiveData()
            return sInstance
        }

    }
}