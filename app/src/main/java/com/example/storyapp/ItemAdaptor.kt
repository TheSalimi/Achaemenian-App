package com.example.storyapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_item_view.view.*

class ItemAdaptor(val storyTitles: Array<String>, val storyContents: Array<String>, val storyImages: Array<String>) : RecyclerView.Adapter<ItemAdaptor.ViewHolder>() {
    class ViewHolder (itemView:View) : RecyclerView.ViewHolder(itemView) {
        val cardTitle : TextView = itemView.cardTitle
        val cardContent : TextView = itemView.cardContent
        val cardImage : ImageView = itemView.cardImage
        val view = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_item_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cardTitle.text=storyTitles[position]
        holder.cardContent.text=storyContents[position]
        Picasso.get().load(storyImages[position]).into(holder.cardImage)

        holder.view.setOnClickListener{
            val intent = Intent(it.context, Details::class.java)
            intent.putExtra("storyTitle",storyTitles[position])
            intent.putExtra("storyContent",storyContents[position])
            intent.putExtra("storyImage",storyImages[position])
            holder.view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = storyTitles.size


}