package com.stew.kotlinjetpack.paging3RemoteMediator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.stew.kotlinjetpack.R
import com.stew.kotlinjetpack.apisample.RetrofitManager
import com.stew.kotlinjetpack.databinding.ActivityPagingBinding
import com.stew.kotlinjetpack.room.AppDatabase

/**
 * Created by stew on 5/29/22.
 * mail: stewforani@gmail.com
 */
class TestRemoteMediatorActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPagingBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_paging2)
    }
}