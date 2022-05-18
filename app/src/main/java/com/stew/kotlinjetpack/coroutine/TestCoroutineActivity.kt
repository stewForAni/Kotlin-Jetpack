package com.stew.kotlinjetpack.coroutine

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.stew.kotlinjetpack.R
import com.stew.kotlinjetpack.apisample.RetrofitManager
import kotlinx.coroutines.*

/**
 * Created by stew on 5/18/22.
 * mail: stewforani@gmail.com
 */
class TestCoroutineActivity : AppCompatActivity() {
    val TAG = "TestCoroutineActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

//        runBlocking {
//            Log.d(TAG, "runBlocking: " + Thread.currentThread())
//            val job = launch {
//                repeat(10) {
//                    Log.d(TAG, "$it: " + Thread.currentThread())
//                    delay(1000)
//                }
//            }
//
//            delay(2500)
//            Log.d(TAG, "start cancel: " + Thread.currentThread())
//            job.cancelAndJoin()
//            Log.d(TAG, "end cancel: " + Thread.currentThread())
//        }



//        GlobalScope.launch {
//            Log.d(TAG, "GlobalScope.launch: " + Thread.currentThread())
//            val job = launch {
//                repeat(10) {
//                    Log.d(TAG, "$it: " + Thread.currentThread())
//                    delay(1000)
//                }
//            }
//
//            delay(2500)
//            Log.d(TAG, "start cancel: " + Thread.currentThread())
//            job.cancelAndJoin()
//            Log.d(TAG, "end cancel: " + Thread.currentThread())
//        }
//
//        Log.d(TAG, "out" + Thread.currentThread())


//        GlobalScope.async {
//            Log.d(TAG, "GlobalScope.async: " + Thread.currentThread())
//        }



        runBlocking {
            Log.d(TAG, "runBlocking: 1" + Thread.currentThread())
            val job = launch {
            RetrofitManager.getApisTool().loadProjectTree()
            }
            Log.d(TAG, "runBlocking: 2" + Thread.currentThread())
        }
    }
}