package com.stew.kotlinjetpack.coroutine

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.stew.kotlinjetpack.R
import com.stew.kotlinjetpack.apisample.Apis
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
        Log.d(TAG, "onCreate: ")
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

        findViewById<Button>(R.id.button).setOnClickListener {
            Log.d(TAG, "999999-1")
            f9()
            Log.d(TAG, "999999-2")
        }


    }
    private fun f9() {
        f0()
    }
    private fun f0() {
        Log.d(TAG, "999999-3")
        runBlocking {
            launch{
                Log.d(TAG, "1")
                f1()
                Log.d(TAG, "2")
            }
        }
        Log.d(TAG, "999999-4")
    }

    suspend fun f1() {
        Log.d(TAG, "3")
        f2()
        Log.d(TAG, "4")
    }

    suspend fun f2() {
        Log.d(TAG, "5")
        f3()
        Log.d(TAG, "6")
    }

    suspend fun f3() {
        Log.d(TAG, "7")
        withContext(Dispatchers.IO) {
            Log.d(TAG, "###1")
            Log.d(TAG, "###2")
        }
        Log.d(TAG, "8")
    }


}