package com.stew.kotlinjetpack.paging3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.stew.kotlinjetpack.R
import com.stew.kotlinjetpack.databinding.ActivityPagingBinding
import com.stew.kotlinjetpack.paging3.adapter.LoadingDataAdapter
import com.stew.kotlinjetpack.paging3.adapter.GithubProjectAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by stew on 5/23/22.
 * mail: stewforani@gmail.com
 */
class TestPaging3Activity : AppCompatActivity() {

    private val githubViewModel: GithubProjectViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPagingBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_paging)
        val lm = LinearLayoutManager(this)
        val adapter = GithubProjectAdapter()
        binding.recyclerView.layoutManager = lm
        binding.recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
                header = LoadingDataAdapter(adapter),
                footer = LoadingDataAdapter(adapter))

        lifecycleScope.launch(Dispatchers.IO) {
            githubViewModel.getData().collect {
                Log.d("paging3 test", "collect")
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
}