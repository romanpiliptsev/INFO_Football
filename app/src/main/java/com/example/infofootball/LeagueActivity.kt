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
import com.example.infofootball.adapters.TableAdapter
import com.example.infofootball.adapters.TopScorersAdapter
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

        leagueId = intent.getIntExtra("leagueId", 302)
        tableItems = JSONUtils.getTableItemsFromJSON(NetworkUtils.getJSONForTable(leagueId ?: 0))

        leagueName = findViewById(R.id.league_name)
        leagueLogo = findViewById(R.id.league_logo)
        leagueName?.text = when(leagueId) {
            302 -> {
                leagueLogo?.setImageResource(R.drawable.laliga)
                "LA LIGA"
            }
            152 -> {
                leagueLogo?.setImageResource(R.drawable.pl)
                "PREMIER LEAGUE"
            }
            207 -> {
                leagueLogo?.setImageResource(R.drawable.sa)
                "SERIE A"
            }
            175 -> {
                leagueLogo?.setImageResource(R.drawable.bl)
                "BUNDESLIGA"
            }
            168 -> {
                leagueLogo?.setImageResource(R.drawable.l1)
                "LIGUE 1"
            }
            244 -> {
                leagueLogo?.setImageResource(R.drawable.eredivisie)
                "EREDEVISIE"
            }
            else -> "UNKNOWN LEAGUE"
        }

        rvTable = findViewById(R.id.rv_table_items)
        rvTable?.layoutManager = LinearLayoutManager(this)
        rvTable?.adapter = TableAdapter(tableItems)

        rvTopScorers = findViewById(R.id.rv_top_scorers)
        rvTopScorers?.layoutManager = LinearLayoutManager(this)
        topScorers = JSONUtils.getTopScorersFromJSON(NetworkUtils.getJSONForTopScorers(leagueId ?: 0))
            .sortedBy { it.place }.subList(0, 10)

        rvTopScorers?.adapter = TopScorersAdapter(topScorers)
    }

    fun launchTeamActivityFromTable(view: View) {
        val intent = Intent(this, TeamActivity::class.java)
        val teamId = convertId(tableItems[rvTable?.indexOfChild(view) ?: 0].id)

        if (teamId == 0) {
            Toast.makeText(this, "Sorry, team not found...", Toast.LENGTH_SHORT).show()
        } else {
            intent.putExtra("teamId", teamId)
            intent.putExtra("teamName", tableItems[rvTable?.indexOfChild(view) ?: 0].name)
            startActivity(intent)
        }
    }

    fun launchTeamActivityFromTopScorer(view: View) {
        val intent = Intent(this, TeamActivity::class.java)
        val teamId = topScorers[rvTopScorers?.indexOfChild(view.parent as View) ?: 0].teamKey

        if (teamId == 0) {
            Toast.makeText(this, "Sorry, team not found...", Toast.LENGTH_SHORT).show()
        } else {
            intent.putExtra("teamId", teamId)
            intent.putExtra("teamName", topScorers[rvTopScorers?.indexOfChild(view.parent as View) ?: 0].teamName)
            startActivity(intent)
        }
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
