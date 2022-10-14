package com.example.infofootball

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.infofootball.adapters.MatchesAdapter
import com.example.infofootball.adapters.PlayersAdapter
import com.example.infofootball.data.*
import com.example.infofootball.utils.JSONUtils
import com.example.infofootball.utils.NetworkUtils
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.squareup.picasso.Picasso

class TeamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)
    }

    fun launchMatchActivity(view: View) {
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    fun showToastMatches(view: View) {
        Toast.makeText(this, "Number of matches played in this season", Toast.LENGTH_SHORT).show()
    }

    fun showToastGoals(view: View) {
        Toast.makeText(this, "Number of goals scored in this season", Toast.LENGTH_SHORT).show()
    }

    fun showToastYellowCards(view: View) {
        Toast.makeText(this, "Number of yellow cards received in this season", Toast.LENGTH_SHORT).show()
    }

    fun showToastRedCards(view: View) {
        Toast.makeText(this, "Number of red cards received in this season", Toast.LENGTH_SHORT).show()
    }

    fun showToastNameAndNumber(view: View) {
        Toast.makeText(this, "Name and game number", Toast.LENGTH_SHORT).show()
    }

    fun showToastPositionAndAge(view: View) {
        Toast.makeText(this, "Position on the field and age", Toast.LENGTH_SHORT).show()
    }
}
