package com.stew.kotlinjetpack.paging3.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stew.kotlinjetpack.R

/**
 * Created by stew on 5/24/22.
 * mail: stewforani@gmail.com
 */
class HeadAdapter : LoadStateAdapter<HeadAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val t: TextView = itemView.findViewById(R.id.t1)
    }

    override fun onBindViewHolder(holder: MyViewHolder, loadState: LoadState) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.head, parent, false))
    }
}