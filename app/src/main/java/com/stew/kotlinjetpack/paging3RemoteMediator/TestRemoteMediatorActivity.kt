package com.stew.kotlinjetpack.paging3RemoteMediator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import com.stew.kotlinjetpack.R
import com.stew.kotlinjetpack.apisample.RetrofitManager
import com.stew.kotlinjetpack.databinding.ActivityPaging2Binding
import com.stew.kotlinjetpack.databinding.ActivityPagingBinding
import com.stew.kotlinjetpack.paging3.GithubProjectViewmodel
import com.stew.kotlinjetpack.paging3.adapter.GithubProjectAdapter
import com.stew.kotlinjetpack.paging3.adapter.LoadingDataAdapter
import com.stew.kotlinjetpack.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by stew on 5/29/22.
 * mail: stewforani@gmail.com
 */
@ExperimentalPagingApi
class TestRemoteMediatorActivity : AppCompatActivity() {

    private val myViewModel: MyViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPaging2Binding =
                DataBindingUtil.setContentView(this, R.layout.activity_paging2)

        val lm = LinearLayoutManager(this)
        val adapter = MyAdapter()
        binding.recyclerView.layoutManager = lm
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch(Dispatchers.IO) {
            myViewModel.getData().collectLatest {
                Log.d("TestRemoteMediator", "collect")
                adapter.submitData(it)
            }
        }

        adapter.addLoadStateListener {
            when (it.refresh) {
                is LoadState.NotLoading -> {
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.progressbar.visibility = View.INVISIBLE
                }

                is LoadState.Loading -> {
                    binding.recyclerView.visibility = View.INVISIBLE
                    binding.progressbar.visibility = View.VISIBLE
                }
                is LoadState.Error -> {
                    Toast.makeText(this,
                            "Load Error: ${(it.refresh as LoadState.Error).error.message}",
                            Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleScope.launch(Dispatchers.IO) {
            AppDatabase.getInstance().GithubProjectDao().clear()
        }
    }
}