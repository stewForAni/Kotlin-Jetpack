package com.stew.kotlinjetpack

import android.app.Application
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner

/**
 * Created by stew on 5/30/22.
 * mail: stewforani@gmail.com
 */
class MyApp : Application() {


    companion object {

        private var INSTANCE: Application? = null

        fun getInstance(): Application = INSTANCE!!
    }


    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        ProcessLifecycleOwner.get().lifecycle.addObserver(MyAppLifeCycleObserver())
    }

    class MyAppLifeCycleObserver:LifecycleObserver{
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onAppForeground() {
            Log.d("MyApp", "ON_START  --  onAppForeground")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun onAppBackground() {
            Log.d("MyApp", "ON_STOP  --  onAppBackground")
        }

    }
}