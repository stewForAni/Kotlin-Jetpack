package com.stew.kotlinjetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
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
import com.stew.kotlinjetpack.room.TestRoomActivity
import com.stew.kotlinjetpack.viewmodel.TestSharedViewModelActivity
import com.stew.kotlinjetpack.viewmodel.TestViewModelActivity
import com.stew.kotlinjetpack.viewpager.TestViewPagerActivity

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
            startActivity(Intent(this, TestRemoteMediatorActivity::class.java))
        }

        //kotlin test --------------------------------------------------------------------

        //kotlin test --------------------------------------------------------------------
    }


}