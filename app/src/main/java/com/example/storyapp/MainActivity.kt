package com.example.storyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.MotionEvent
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.custom_item_view.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {
    var storyTitles = arrayOf<String>()
    var storyContents = arrayOf<String>()
    var storyImages = arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this , drawerLayout , toolbar,R.string.open ,R.string.close )
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener (this)

        storyTitles = resources.getStringArray(R.array.storyTitles)
        storyContents = resources.getStringArray(R.array.storyContents)
        storyImages = resources.getStringArray(R.array.storyImages)

        cardTitle.isSelected = true

        val adapter = ItemAdaptor(storyTitles,storyContents,storyImages)
        storyList.layoutManager = LinearLayoutManager(this)
        storyList.adapter = adapter
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)
        if(item.itemId == R.id.random){
            val randPosition = Random.nextInt(0 , storyTitles.size)
            val intent = Intent(applicationContext,Details::class.java)
            startActivity(randPosition , intent)
            startActivity(intent)
        }
        return true
    }


    public fun startActivity(randPosition : Int , intent: Intent){
        intent.putExtra("storyTitle",storyTitles[randPosition])
        intent.putExtra("storyContent",storyContents[randPosition])
        intent.putExtra("storyImage",storyImages[randPosition])

        val time: String
        val wikipediaLink : String
        val youTubeLink :String
        val britannica : String

        if (randPosition <= 3) {
            time = "560_530 BC"
            wikipediaLink = "https://en.wikipedia.org/wiki/Cyrus_the_Great"
            britannica = "https://www.britannica.com/biography/Cyrus-the-Great"
            youTubeLink = "https://www.youtube.com/watch?v=wMbD7c-YlAE"
        }
        //darius I
        else if (randPosition > 3 && randPosition < 8) {
            time = "522–486 BC"
            youTubeLink = "https://www.youtube.com/watch?v=10e5PghEh7o"
            wikipediaLink = "https://en.wikipedia.org/wiki/Darius_the_Great"
            britannica = "https://www.britannica.com/biography/Darius-I"
        }
        //cambyses
        else if (randPosition == 8) {
            time = "530–522 BC"
            wikipediaLink="https://en.wikipedia.org/wiki/Cambyses_I"
            britannica = "https://www.britannica.com/biography/Cambyses-I"
            youTubeLink = "https://www.youtube.com/watch?v=u9sYFNfrYhI"
        }
        //bardiya
        else if (randPosition == 9) {
            time = "522 BC"
            wikipediaLink = "https://en.wikipedia.org/wiki/Bardiya"
            britannica = "https://www.britannica.com/biography/Bardiya"
            youTubeLink = "https://www.youtube.com/watch?v=j2thzB5nLs0"
        }
        //xerxes I
        else if (randPosition >= 10 && randPosition <= 13) {
            time = "486-465 BC"
            youTubeLink = "https://www.youtube.com/watch?v=OGXl5vYP094"
            wikipediaLink = "https://en.wikipedia.org/wiki/Xerxes_I"
            britannica = "https://www.britannica.com/summary/Xerxes-I#:~:text=Xerxes%20I%20%2C%20Persian%20Khshayarsha%2C%20(,)%20and%20Babylonia%20(482)."
        }
        //artaxerxes I
        else if (randPosition == 14) {
            time = "465–424 BC"
            britannica="https://www.britannica.com/biography/Artaxerxes-I#:~:text=Artaxerxes%20I%2C%20(died%20425%20bc,reigned%20465%E2%80%93425%20bc).&text=He%20was%20surnamed%20in%20Greek,Artabanus%2C%20who%20had%20murdered%20Xerxes."
            wikipediaLink="https://en.wikipedia.org/wiki/Artaxerxes_I"
            youTubeLink="https://www.youtube.com/watch?v=c9HpQSpFRyo"
        }
        //xerxes II
        else if (randPosition == 15) {
            time = "424 BC"
            youTubeLink = "https://www.youtube.com/watch?v=RnHTay2bO5s"
            wikipediaLink = "https://en.wikipedia.org/wiki/Xerxes_II"
            britannica = "https://www.britannica.com/biography/Xerxes-II"
        }
        //darius II
        else if (randPosition == 16) {
            time = "423–405 BC"
            wikipediaLink = "https://en.wikipedia.org/wiki/Darius_II"
            britannica = "https://www.britannica.com/biography/Darius-II-Ochus"
            youTubeLink = "https://www.youtube.com/watch?v=orh4wzDzdFo"
        }
        //artaxerxes II
        else if (randPosition == 17) {
            time = "405–358 BC"
            youTubeLink = "https://www.youtube.com/watch?v=TWo_7hsDtH0"
            wikipediaLink = "https://en.wikipedia.org/wiki/Artaxerxes_II"
            britannica = "https://www.britannica.com/biography/Artaxerxes-II"
        }
        //artaxerxes III
        else if (randPosition == 18) {
            time = "358–338 BC"
            wikipediaLink = "https://en.wikipedia.org/wiki/Artaxerxes_III"
            britannica ="https://www.britannica.com/biography/Artaxerxes-III"
            youTubeLink = "https://www.youtube.com/watch?v=7pGOc17-k4Y"
        }
        //artaxerxes IV
        else if (randPosition == 19) {
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
    }
}