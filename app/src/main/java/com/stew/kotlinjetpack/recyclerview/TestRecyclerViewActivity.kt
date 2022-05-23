package com.stew.kotlinjetpack.recyclerview

import android.os.Bundle
import android.view.View
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
        for (item in 0..20) {
            list.add(Info(item, "stew_$item", R.mipmap.ic_launcher))
        }
        val binding: ActivityRecyclerBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_recycler)
        binding.recycler.layoutManager = LinearLayoutManager(this)
        val a = RecyclerAdapter()
        binding.recycler.adapter = a
        a.setData(list)

        var i: Int = 1

        binding.floatingActionButton.setOnClickListener {
            val newList = mutableListOf<Info>()
            for (item in 0..20) {
                newList.add(Info(item, "stew_$item", R.mipmap.ic_launcher))
            }
            newList[i].name = "Bob$i"
            newList[i + 1].name = "Bob${i + 1}"
            newList[i + 2].name = "Bob${i + 2}"
            a.setData(newList)
            i++
        }

    }

}