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

    private var teamLogo: ImageView? = null
    private var teamName: TextView? = null
    private var coach: TextView? = null
    private var star: ImageView? = null
    private var rvMatches: RecyclerView? = null
    private var rvPlayers: RecyclerView? = null
    private var matches: ArrayList<Match> = ArrayList()
    private var favoriteTeam: DBTeam? = null
    private var team: Team? = null
    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        viewModel = MainViewModel(application)

        teamLogo = findViewById(R.id.team_logo)
        teamName = findViewById(R.id.team_name)
        coach = findViewById(R.id.coach)
        rvMatches = findViewById(R.id.rv_last_matches)
        rvPlayers = findViewById(R.id.rv_players)
        star = findViewById(R.id.favorite_or_not)

        val teamId = intent.getIntExtra("teamId", 96)
        team = JSONUtils.getTeamFromJSON(NetworkUtils.getJSONForTeam(teamId))
        val teamNameFromJSON = team?.team_name

        val correctName = if (teamNameFromJSON == null || teamNameFromJSON == "null" || teamNameFromJSON.length > 18)
            intent.getStringExtra("teamName") else team?.team_name
        teamName?.text = correctName

        coach?.text = team?.coach ?: "Unknown coach..."

        val logoUrl: String? = team?.team_logo

        if (logoUrl?.endsWith("svg") == true) {
            GlideToVectorYou
                .init()
                .with(this)
                .load(Uri.parse(logoUrl), teamLogo)
        } else {
            Picasso.get().load(logoUrl).into(teamLogo)
        }

        rvMatches?.layoutManager = LinearLayoutManager(this)
        matches = JSONUtils.getMatchesFromJSON(NetworkUtils.getJSONForH2H(teamId, teamId))
        rvMatches?.adapter = MatchesAdapter(matches, team, correctName)

        rvPlayers?.layoutManager = LinearLayoutManager(this)
        rvPlayers?.adapter = PlayersAdapter(team?.players ?: ArrayList())
    }

    override fun onResume() {
        super.onResume()
        setFavorite()
    }

    fun launchMatchActivity(view: View) {
        val match: Match = matches[rvMatches?.indexOfChild(view) ?: 0]

        val intent = Intent(this, MatchActivity::class.java)
        intent.putExtra(Match::class.java.simpleName, match)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.favorites) {
            startActivity(Intent(this, FavoritesActivity::class.java))
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    fun addOrDeleteFromFavorites(view: View) {
        if (favoriteTeam != null) {
            viewModel?.deleteFavorite(favoriteTeam!!)
            Toast.makeText(this, "Deleted from favorites", Toast.LENGTH_SHORT).show()
        } else {
            if (team != null) {
                viewModel?.insertFavorite(DBTeam(team!!))
                Toast.makeText(this, "Added to favorites", Toast.LENGTH_SHORT).show()
            }
        }
        setFavorite()
    }

    private fun setFavorite() {
        favoriteTeam = viewModel?.getFavoriteById(team?.team_key ?: 0)
        if (favoriteTeam == null) {
            star?.setImageResource(R.drawable.ic_empty_star)
        } else {
            star?.setImageResource(R.drawable.ic_yellow_star)
        }
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
