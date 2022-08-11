package com.stew.kotlinjetpack.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.stew.kotlinjetpack.R

/**
 * Created by stew on 5/21/22.
 * mail: stewforani@gmail.com
 */
class RecyclerAdapter:
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private val diff: AsyncListDiffer<Info>
    private val list: MutableList<Info> = mutableListOf()

    init {
        diff = AsyncListDiffer(this, MyCallback())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d("RecyclerAdapter", "onBindViewHolder: $position")
        val data = diff.currentList[position]
        holder.name.text = data.name
        holder.image.setImageResource(data.image)
    }

    override fun getItemCount(): Int {
        return diff.currentList.size
    }

    fun setData(list: MutableList<Info>) {
        diff.submitList(list)
    }

    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var name: TextView = item.findViewById(R.id.textView)
        var image: ImageView = item.findViewById(R.id.imageView)
    }

    class MyCallback : DiffUtil.ItemCallback<Info>() {
        override fun areItemsTheSame(oldItem: Info, newItem: Info): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Info, newItem: Info): Boolean {
            return oldItem.name == newItem.name
        }

    }
}