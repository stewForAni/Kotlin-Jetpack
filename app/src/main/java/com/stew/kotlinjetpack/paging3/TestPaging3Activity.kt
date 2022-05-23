package com.stew.kotlinjetpack.paging3

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.stew.kotlinjetpack.R
import com.stew.kotlinjetpack.databinding.ActivityPagingBinding
import com.stew.kotlinjetpack.paging3.adapter.GithubProjectAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by stew on 5/23/22.
 * mail: stewforani@gmail.com
 */
class TestPaging3Activity : AppCompatActivity() {

    val githubViewModel: GithubProjectViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPagingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_paging)
        val lm = LinearLayoutManager(this)
        val adapter = GithubProjectAdapter()
        binding.recyclerView.layoutManager = lm
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch(Dispatchers.IO) {
            githubViewModel.getData().collect {
                adapter.submitData(it)
            }
        }
    }
}