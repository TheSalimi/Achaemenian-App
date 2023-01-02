package com.example.storyapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class Details : AppCompatActivity() {
    private lateinit var wikipediaLink: String
    private lateinit var youtubeLink: String
    private lateinit var britannicaLink: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val storyTitle = intent.getStringExtra("storyTitle")
        val storyContent = intent.getStringExtra("storyContent")
        val storyImage = intent.getStringExtra("storyImage")
        val storyTime = intent.getStringExtra("time")
        wikipediaLink = intent.getStringExtra("wiki")!!
        youtubeLink = intent.getStringExtra("youtube")!!
        britannicaLink = intent.getStringExtra("britannica")!!

        Picasso.get().load(storyImage).into(story_Image)
        storyDetails.text = storyContent
        storyName.text = storyTitle
        time.text = storyTime

        youTube.setOnClickListener {
            if (youtubeLink != "null") {
                val openURL = Intent(android.content.Intent.ACTION_VIEW)
                openURL.data = Uri.parse(youtubeLink)
                startActivity(openURL)
            } else {
                Toast.makeText(this, "No youtube link found", Toast.LENGTH_SHORT).show()
            }
        }

        wikiPedia.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(wikipediaLink)
            startActivity(openURL)
        }

        Britannica.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(britannicaLink)
            startActivity(openURL)
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}