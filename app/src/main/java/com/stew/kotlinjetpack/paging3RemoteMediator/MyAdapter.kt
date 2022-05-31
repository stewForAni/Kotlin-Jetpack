package com.stew.kotlinjetpack.paging3RemoteMediator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.stew.kotlinjetpack.R
import com.stew.kotlinjetpack.paging3.GithubProjectItem
import com.stew.kotlinjetpack.paging3.adapter.GithubProjectAdapter
import com.stew.kotlinjetpack.room.githubproject.GithubProjectEntity

/**
 * Created by stew on 5/31/22.
 * mail: stewforani@gmail.com
 */
class MyAdapter :
        PagingDataAdapter<GithubProjectEntity, MyAdapter.MyViewHolder>(DiffCallback()) {

    class DiffCallback : DiffUtil.ItemCallback<GithubProjectEntity>() {
        override fun areItemsTheSame(oldItem: GithubProjectEntity, newItem: GithubProjectEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GithubProjectEntity, newItem: GithubProjectEntity): Boolean {
            return oldItem == newItem
        }

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val desc: TextView = itemView.findViewById(R.id.desc)
        val star: TextView = itemView.findViewById(R.id.star)
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