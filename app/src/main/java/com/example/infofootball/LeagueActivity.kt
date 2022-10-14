package com.example.infofootball

import android.content.Intent
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
import com.example.infofootball.data.TableItem
import com.example.infofootball.data.TopScorer
import com.example.infofootball.utils.JSONUtils
import com.example.infofootball.utils.NetworkUtils

class LeagueActivity : AppCompatActivity() {

    private var rvTable: RecyclerView? = null
    private var rvTopScorers: RecyclerView? = null
    private var leagueName: TextView? = null
    private var leagueLogo: ImageView? = null
    private var leagueId: Int? = null
    private var tableItems: ArrayList<TableItem> = ArrayList()
    private var topScorers: List<TopScorer> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

    }

    fun launchTeamActivityFromTable(view: View) {
    }

    fun launchTeamActivityFromTopScorer(view: View) {
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    fun showToastAssists(view: View) {
        Toast.makeText(this, "Number of assists", Toast.LENGTH_SHORT).show()
    }

    fun showToastPenGoals(view: View) {
        Toast.makeText(this, "Number of penalty goals", Toast.LENGTH_SHORT).show()
    }

    fun showToastPlace(view: View) {
        Toast.makeText(this, "Place", Toast.LENGTH_SHORT).show()
    }

    fun showToastGames(view: View) {
        Toast.makeText(this, "Number of games", Toast.LENGTH_SHORT).show()
    }

    fun showToastWins(view: View) {
        Toast.makeText(this, "Number of wins", Toast.LENGTH_SHORT).show()
    }

    fun showToastDraws(view: View) {
        Toast.makeText(this, "Number of draws", Toast.LENGTH_SHORT).show()
    }

    fun showToastDefeat(view: View) {
        Toast.makeText(this, "Number of defeat", Toast.LENGTH_SHORT).show()
    }

    fun showToastDifference(view: View) {
        Toast.makeText(this, "Goal difference", Toast.LENGTH_SHORT).show()
    }

    fun showToastPoints(view: View) {
        Toast.makeText(this, "Number of points", Toast.LENGTH_SHORT).show()
    }

    private fun convertId(id1: Int): Int {
        return 0
    }
}
