package com.stew.kotlinjetpack.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.stew.kotlinjetpack.R
import com.stew.kotlinjetpack.databinding.ActivityRecyclerBinding

/**
 * Created by stew on 5/21/22.
 * mail: stewforani@gmail.com
 */
class TestRecyclerViewActivity : AppCompatActivity() {

    var list: MutableList<Info> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        for (item in 0..20) {
            list.add(Info("stew$item", R.mipmap.ic_launcher))
        }
        val binding: ActivityRecyclerBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler)
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = RecyclerAdapter(this, list)
    }

}