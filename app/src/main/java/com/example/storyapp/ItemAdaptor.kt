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

class ItemAdaptor(
    val storyTitles: Array<String>,
    val storyContents: Array<String>,
    val storyImages: Array<String>
) : RecyclerView.Adapter<ItemAdaptor.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardTitle: TextView = itemView.cardTitle
        val cardContent: TextView = itemView.cardContent
        val cardImage: ImageView = itemView.cardImage
        val view = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cardTitle.text = storyTitles[position]
        holder.cardContent.text = storyContents[position]
        Picasso.get().load(storyImages[position]).into(holder.cardImage)



        holder.view.setOnClickListener {
            val time: String
            val wikipediaLink : String
            val youTubeLink :String
            val britannica : String

            val intent = Intent(it.context, Details::class.java)
            intent.putExtra("storyTitle", storyTitles[position])
            intent.putExtra("storyContent", storyContents[position])
            intent.putExtra("storyImage", storyImages[position])

            //cyrus
            if (position <= 3) {
                time = "560_530 BC"
                wikipediaLink = "https://en.wikipedia.org/wiki/Cyrus_the_Great"
                britannica = "https://www.britannica.com/biography/Cyrus-the-Great"
                youTubeLink = "https://www.youtube.com/watch?v=wMbD7c-YlAE"
            }
            //darius I
            else if (position > 3 && position < 8) {
                time = "522–486 BC"
                youTubeLink = "https://www.youtube.com/watch?v=10e5PghEh7o"
                wikipediaLink = "https://en.wikipedia.org/wiki/Darius_the_Great"
                britannica = "https://www.britannica.com/biography/Darius-I"
            }
            //cambyses
            else if (position == 8) {
                time = "530–522 BC"
                wikipediaLink="https://en.wikipedia.org/wiki/Cambyses_I"
                britannica = "https://www.britannica.com/biography/Cambyses-I"
                youTubeLink = "https://www.youtube.com/watch?v=u9sYFNfrYhI"
            }
            //bardiya
            else if (position == 9) {
                time = "522 BC"
                wikipediaLink = "https://en.wikipedia.org/wiki/Bardiya"
                britannica = "https://www.britannica.com/biography/Bardiya"
                youTubeLink = "https://www.youtube.com/watch?v=j2thzB5nLs0"
            }
            //xerxes I
            else if (position >= 10 && position <= 13) {
                time = "486-465 BC"
                youTubeLink = "https://www.youtube.com/watch?v=OGXl5vYP094"
                wikipediaLink = "https://en.wikipedia.org/wiki/Xerxes_I"
                britannica = "https://www.britannica.com/summary/Xerxes-I#:~:text=Xerxes%20I%20%2C%20Persian%20Khshayarsha%2C%20(,)%20and%20Babylonia%20(482)."
            }
            //artaxerxes I
            else if (position == 14) {
                time = "465–424 BC"
                britannica="https://www.britannica.com/biography/Artaxerxes-I#:~:text=Artaxerxes%20I%2C%20(died%20425%20bc,reigned%20465%E2%80%93425%20bc).&text=He%20was%20surnamed%20in%20Greek,Artabanus%2C%20who%20had%20murdered%20Xerxes."
                wikipediaLink="https://en.wikipedia.org/wiki/Artaxerxes_I"
                youTubeLink="https://www.youtube.com/watch?v=c9HpQSpFRyo"
            }
            //xerxes II
            else if (position == 15) {
                time = "424 BC"
                youTubeLink = "https://www.youtube.com/watch?v=RnHTay2bO5s"
                wikipediaLink = "https://en.wikipedia.org/wiki/Xerxes_II"
                britannica = "https://www.britannica.com/biography/Xerxes-II"
            }
            //darius II
            else if (position == 16) {
                time = "423–405 BC"
                wikipediaLink = "https://en.wikipedia.org/wiki/Darius_II"
                britannica = "https://www.britannica.com/biography/Darius-II-Ochus"
                youTubeLink = "https://www.youtube.com/watch?v=orh4wzDzdFo"
            }
            //artaxerxes II
            else if (position == 17) {
                time = "405–358 BC"
                youTubeLink = "https://www.youtube.com/watch?v=TWo_7hsDtH0"
                wikipediaLink = "https://en.wikipedia.org/wiki/Artaxerxes_II"
                britannica = "https://www.britannica.com/biography/Artaxerxes-II"
            }
            //artaxerxes III
            else if (position == 18) {
                time = "358–338 BC"
                wikipediaLink = "https://en.wikipedia.org/wiki/Artaxerxes_III"
                britannica ="https://www.britannica.com/biography/Artaxerxes-III"
                youTubeLink = "https://www.youtube.com/watch?v=7pGOc17-k4Y"
            }
            //artaxerxes IV
            else if (position == 19) {
                time = "338–336 BC"
                britannica = "https://www.britannica.com/biography/Arses#:~:text=Arses%2C%20(died%20June%20336%20bc,Artaxerxes%20III%20Ochus%20and%20Atossa.&text=Arses%20had%20been%20placed%20on,father%20and%20all%20his%20brothers."
                wikipediaLink = "https://en.wikipedia.org/wiki/Arses_of_Persia"
                youTubeLink = "null"
            }
            //darius III
            else {
                time = "336–330 BC"
                youTubeLink = "https://www.youtube.com/watch?v=-A-5KUcHEAM"
                wikipediaLink = "https://en.wikipedia.org/wiki/Darius_III"
                britannica = "https://www.britannica.com/biography/Darius-III"
            }

            intent.putExtra("time", time)
            intent.putExtra("wiki" , wikipediaLink)
            intent.putExtra("youtube" , youTubeLink)
            intent.putExtra("britannica" , britannica)

            holder.view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = storyTitles.size


}