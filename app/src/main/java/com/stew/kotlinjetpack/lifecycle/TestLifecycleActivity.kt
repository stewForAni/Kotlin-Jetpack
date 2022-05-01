package com.stew.kotlinjetpack.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.stew.kotlinjetpack.R

/**
 * Created by stew on 5/1/22.
 * mail: stewforani@gmail.com
 */
class TestLifecycleActivity : AppCompatActivity() {

    val TAG = TestLifecycleActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
    }

    //    override fun onStart() {
//        super.onStart()
//        Log.d(TAG, "onStart: " + lifecycle.currentState)
//    }
//
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: " + lifecycle.currentState)
        lifecycle.addObserver(MyObserver())
    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d(TAG, "onPause: " + lifecycle.currentState)
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d(TAG, "onStop: " + lifecycle.currentState)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d(TAG, "onDestroy: " + lifecycle.currentState)
//    }

    class MyObserver : LifecycleObserver {


        @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
        fun fun1(owner: LifecycleOwner) {
            Log.d("TestLifecycleActivity", "ON_CREATE")
        }

        @OnLifecycleEvent(value = Lifecycle.Event.ON_START)
        fun fun0(owner: LifecycleOwner) {
            Log.d("TestLifecycleActivity", "ON_START")
        }

        @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
        fun fun2(owner: LifecycleOwner) {
            Log.d("TestLifecycleActivity", "ON_RESUME")
        }

        @OnLifecycleEvent(value = Lifecycle.Event.ON_PAUSE)
        fun fun3() {
            Log.d("TestLifecycleActivity", "ON_PAUSE")
        }

        @OnLifecycleEvent(value = Lifecycle.Event.ON_STOP)
        fun fun4() {
            Log.d("TestLifecycleActivity", "ON_STOP")
        }

//        @OnLifecycleEvent(value = Lifecycle.Event.ON_ANY)
//        fun any(owner: LifecycleOwner, event: Lifecycle.Event) {
//            Log.d("TestLifecycleActivity", "any1: " + owner.lifecycle.currentState + " / " + event.name)
//        }
    }
}