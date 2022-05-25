package com.stew.kotlinjetpack.flow

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.stew.kotlinjetpack.R
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.lang.NullPointerException

/**
 * Created by stew on 5/23/22.
 * mail: stewforani@gmail.com
 */
class TestFlowActivity : AppCompatActivity() {
    val TAG = "TestFlowActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)

//        lifecycleScope.launch(Dispatchers.IO) {
//            flow {
//                Log.d(TAG, "emit: 1")
//                emit(1)
//                Log.d(TAG, "emit: 2")
//                emit(2)
//                Log.d(TAG, "emit: 3")
//                emit(3)
//            }.flowOn(Dispatchers.Main).onCompletion {
//                Log.d(TAG, "flow onCompletion")
//            }.collect {
//                Log.d(TAG, "flow.collect: $it")
//            }
//        }


//        lifecycleScope.launch(Dispatchers.IO) {
//            flowOf(1, 2, 3).onCompletion {
//                Log.d(TAG, "flowOf onCompletion")
//            }.collect {
//                Log.d(TAG, "flowOf collect: $it")
//            }
//
//            listOf(1,2,3).asFlow().onCompletion {
//                Log.d(TAG, "asFlow onCompletion")
//            }.collect {
//                Log.d(TAG, "asFlow collect: $it")
//            }
//        }

//        lifecycleScope.launch(Dispatchers.Main) {
//            flow {
//                Log.d(TAG, "emit " + Thread.currentThread().name)
//                emit(1)
//            }.map {
//                Log.d(TAG, "map " + Thread.currentThread().name)
//                it * 2
//            }.flowOn(Dispatchers.IO).onCompletion {
//                Log.d(TAG, "onCompletion " + Thread.currentThread().name)
//            }.collect {
//                Log.d(TAG, "collect " + Thread.currentThread().name)
//            }
//        }

//        lifecycleScope.launch(Dispatchers.IO) {
//            flow {
//                emit(1)
//                throw NullPointerException()
//            }.catch {
//                Log.d(TAG, "catch $it")
//            }.collect {
//                Log.d(TAG, "collect " + Thread.currentThread().name)
//            }
//        }


        lifecycleScope.launch(Dispatchers.IO) {
            val f = flow {
                emit(1)
                delay(1000)
                emit(2)
                delay(1000)
                emit(3)
                delay(1000)
            }

            val a = withTimeoutOrNull(4000) {
                f.collect {
                    Log.d(TAG, "f.collect: $it")
                }
            }

            Log.d(TAG, "flow end $a")
        }

    }
}