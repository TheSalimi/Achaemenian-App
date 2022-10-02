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
            val time : String
            val intent = Intent(it.context, Details::class.java)
            intent.putExtra("storyTitle",storyTitles[position])
            intent.putExtra("storyContent",storyContents[position])
            intent.putExtra("storyImage",storyImages[position])

            time =
            if(position<=3)  "560_530 BC"

            else if(position>3 && position<8) "522–486 BC"

            else if(position==8) "530–522 BC"

            else if(position==9)  "522 BC"

            else if(position>=10 && position<=13)  "486-465 BC"

            else if(position==14)  "465–424 BC"

            else if(position==15) "424 BC"

            else if(position==16) "423–405 BC"

            else if(position==17) "405–358 BC"

            else if(position==18) "358–338 BC"

            else if(position==19)  "338–336 BC"

            else "336–330 BC"

            intent.putExtra("time",time)

            holder.view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = storyTitles.size


}