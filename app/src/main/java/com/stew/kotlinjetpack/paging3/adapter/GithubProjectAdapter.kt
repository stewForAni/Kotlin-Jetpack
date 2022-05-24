package com.stew.kotlinjetpack.paging3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.stew.kotlinjetpack.R
import com.stew.kotlinjetpack.paging3.GithubProjectItem

/**
 * Created by stew on 5/23/22.
 * mail: stewforani@gmail.com
 */
class GithubProjectAdapter :
        PagingDataAdapter<GithubProjectItem, GithubProjectAdapter.MyViewHolder>(DiffCallback()) {

    class DiffCallback : DiffUtil.ItemCallback<GithubProjectItem>() {
        override fun areItemsTheSame(oldItem: GithubProjectItem, newItem: GithubProjectItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GithubProjectItem, newItem: GithubProjectItem): Boolean {
            return oldItem == newItem
        }

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name)
        val desc = itemView.findViewById<TextView>(R.id.desc)
        val star = itemView.findViewById<TextView>(R.id.star)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.name.text = data.name
            holder.desc.text = data.description
            holder.star.text = "Star: " + data.stargazers_count.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.github_item, parent, false)
        )
    }
}