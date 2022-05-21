package com.stew.kotlinjetpack.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stew.kotlinjetpack.R

/**
 * Created by stew on 5/21/22.
 * mail: stewforani@gmail.com
 */
class RecyclerAdapter(var context: Context, var list: MutableList<Info>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item, parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name?.text = list[position].name
        holder.image?.setImageResource(list[position].image)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var name: TextView? = null
        var image: ImageView? = null

        init {
            name = item.findViewById<TextView>(R.id.textView)
            image = item.findViewById<ImageView>(R.id.imageView)
        }
    }
}