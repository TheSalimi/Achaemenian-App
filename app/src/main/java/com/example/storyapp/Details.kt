package com.example.storyapp

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class Details :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val storyTitle = intent.getStringExtra("storyTitle")
        val storyContent = intent.getStringExtra("storyContent")
        val storyImage = intent.getStringExtra("storyImage")
        val storyTime = intent.getStringExtra("time")

        Picasso.get().load(storyImage).into(story_Image)
        storyDetails.text = storyContent
        storyName.text = storyTitle
        time.text = storyTime
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}