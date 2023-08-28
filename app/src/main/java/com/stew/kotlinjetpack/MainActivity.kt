package com.stew.kotlinjetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import com.stew.kotlinjetpack.apisample.RetrofitManager
import com.stew.kotlinjetpack.coroutine.TestCoroutineActivity
import com.stew.kotlinjetpack.databinding.TestDataBindingActivity
import com.stew.kotlinjetpack.flow.TestFlowActivity
import com.stew.kotlinjetpack.lifecycle.TestLifecycleActivity
import com.stew.kotlinjetpack.livedata.TestLiveDataActivity
import com.stew.kotlinjetpack.livedata.TestLiveDataTransformationsActivity
import com.stew.kotlinjetpack.mvvmsample.TestUserActivity
import com.stew.kotlinjetpack.navigation.TestNavigationActivity
import com.stew.kotlinjetpack.paging3.TestPaging3Activity
import com.stew.kotlinjetpack.paging3RemoteMediator.TestRemoteMediatorActivity
import com.stew.kotlinjetpack.recyclerview.TestRecyclerViewActivity
import com.stew.kotlinjetpack.room.AppDatabase
import com.stew.kotlinjetpack.room.TestRoomActivity
import com.stew.kotlinjetpack.viewmodel.TestSharedViewModelActivity
import com.stew.kotlinjetpack.viewmodel.TestViewModelActivity
import com.stew.kotlinjetpack.viewpager.TestViewPagerActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.ArrayBlockingQueue

class MainActivity : AppCompatActivity() {
    @ExperimentalPagingApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tx1).setOnClickListener {
            startActivity(Intent(this, TestNavigationActivity::class.java))
        }

        findViewById<TextView>(R.id.tx2).setOnClickListener {
            startActivity(Intent(this, TestLifecycleActivity::class.java))
        }

        findViewById<TextView>(R.id.tx3).setOnClickListener {
            startActivity(Intent(this, TestLiveDataActivity::class.java))
        }

        findViewById<TextView>(R.id.tx4).setOnClickListener {
            startActivity(Intent(this, TestLiveDataTransformationsActivity::class.java))
        }

        findViewById<TextView>(R.id.tx5).setOnClickListener {
            startActivity(Intent(this, TestViewModelActivity::class.java))
        }

        findViewById<TextView>(R.id.tx6).setOnClickListener {
            startActivity(Intent(this, TestSharedViewModelActivity::class.java))
        }

        findViewById<TextView>(R.id.tx7).setOnClickListener {
            startActivity(Intent(this, TestUserActivity::class.java))
        }

        findViewById<TextView>(R.id.tx8).setOnClickListener {
            startActivity(Intent(this, TestDataBindingActivity::class.java))
        }

        findViewById<TextView>(R.id.tx9).setOnClickListener {
            startActivity(Intent(this, TestCoroutineActivity::class.java))
        }

        findViewById<TextView>(R.id.tx10).setOnClickListener {
            startActivity(Intent(this, TestViewPagerActivity::class.java))
        }

        findViewById<TextView>(R.id.tx11).setOnClickListener {
            startActivity(Intent(this, TestRecyclerViewActivity::class.java))
        }

        findViewById<TextView>(R.id.tx12).setOnClickListener {
            startActivity(Intent(this, TestRoomActivity::class.java))
        }

        findViewById<TextView>(R.id.tx13).setOnClickListener {
            startActivity(Intent(this, TestPaging3Activity::class.java))
        }

        findViewById<TextView>(R.id.tx14).setOnClickListener {
            startActivity(Intent(this, TestFlowActivity::class.java))
        }

        findViewById<TextView>(R.id.tx15).setOnClickListener {
//            startActivity(Intent(this, TestRemoteMediatorActivity::class.java))

//            runBlocking {
//                GlobalScope.launch {
//                    println("======delay 1s  start")
//                    delay(1000)
//                    println("======delay 1s end")
//                }
//
//                println("======delay 3s start")
//                delay(1000)
//                println("======delay 3s end")
//            }
        }

        //kotlin test --------------------------------------------------------------------

//        runBlocking {
//            println("======runBlocking start")
//            delay(1000)
//            println("======runBlocking end")
//        }
//
//        GlobalScope.launch {
//            println("======launch start")
//            delay(1000)
//            println("======launch end")
//        }
//
//        GlobalScope.async {
//            println("======async start")
//            delay(1000)
//            println("======async end")
//        }
//
//        println("======async main")

        runBlocking {
            flow {
                (1..5).forEach {
                    delay(200)
                    println("emit$it,${System.currentTimeMillis()},${Thread.currentThread().name}")
                    emit(it)
                }
            }.buffer().collect {
                delay(500)
                println("collect$it,${System.currentTimeMillis()},${Thread.currentThread().name}")
            }
        }

        //kotlin test --------------------------------------------------------------------
    }

    fun testChannel() {
        //协程1
        var deferred = GlobalScope.async {

            Thread.sleep(2000)
            "Hello fishforest"
        }
        //协程2
        GlobalScope.launch {

            var result = deferred.await()
            println("get result from coroutine1： $result")
        }
    }

    fun testChannel2() {
        //阻塞队列
        var queue = ArrayBlockingQueue<String>(5)
        //协程1
        GlobalScope.launch {
            var count = 0
            while (true) {
                println("1-----------")
                Thread.sleep(1000)
                queue.put("fish ${count++}")
            }
        }

        //协程2
        GlobalScope.launch {
            while (true) {
                println("2-----------")
                Thread.sleep(1000)
                println("get result from coroutine1：${queue.take()}")
            }
        }
    }

    fun testChannel3() {
        //定义Channel
        var channel = Channel<String>()
        //协程1
        GlobalScope.launch {
            var count = 0
            while (true) {
                //假装在加工数据
                Thread.sleep(1000)
                var sendStr = "fish ${count++}"
                println("send $sendStr")
                channel.send("$sendStr")
            }
        }

        //协程2
        GlobalScope.launch {
            while (true) {
                Thread.sleep(1000)
                println("receive：${channel.receive()}")
            }
        }
    }

}