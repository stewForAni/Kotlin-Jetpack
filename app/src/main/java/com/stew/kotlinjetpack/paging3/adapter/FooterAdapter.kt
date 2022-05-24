package com.stew.kotlinjetpack.paging3.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stew.kotlinjetpack.R

/**
 * Created by stew on 5/24/22.
 * mail: stewforani@gmail.com
 */
class FooterAdapter(private val a: GithubProjectAdapter) : LoadStateAdapter<FooterAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val p: ProgressBar = itemView.findViewById(R.id.progressbar2)
        val t: TextView = itemView.findViewById(R.id.click)
    }

    override fun onBindViewHolder(holder: MyViewHolder, loadState: LoadState) {
        holder.p.isVisible = loadState is LoadState.Loading
        holder.t.isVisible = loadState is LoadState.Error
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): MyViewHolder {
        val h = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.footer, parent, false))
        h.t.setOnClickListener {
            a.retry()
        }
        return h
    }
}