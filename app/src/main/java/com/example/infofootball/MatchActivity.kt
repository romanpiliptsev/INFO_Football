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
import com.example.infofootball.adapters.VideosAdapter
import com.example.infofootball.data.Match
import com.example.infofootball.data.Video
import com.example.infofootball.utils.JSONUtils
import com.example.infofootball.utils.NetworkUtils
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.squareup.picasso.Picasso

class MatchActivity : AppCompatActivity() {

    private var matchGlobal: Match? = null
    private var rvVideos: RecyclerView? = null
    private var videos: ArrayList<Video>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        val league: TextView = findViewById(R.id.league)
        val homeTeamLogo: ImageView = findViewById(R.id.home_team_logo)
        val homeTeamName: TextView = findViewById(R.id.home_team_name)
        val result1: TextView = findViewById(R.id.result_1)
        val htResult1: TextView = findViewById(R.id.ht_result_1)
        val status: TextView = findViewById(R.id.status)
        val date: TextView = findViewById(R.id.date)
        val time: TextView = findViewById(R.id.time)
        val result2: TextView = findViewById(R.id.result_2)
        val htResult2: TextView = findViewById(R.id.ht_result_2)
        val awayTeamLogo: ImageView = findViewById(R.id.away_team_logo)
        val awayTeamName: TextView = findViewById(R.id.away_team_name)

        // matchOrNull is needed for tests
        val matchOrNull: Match? = intent.getSerializableExtra(Match::class.java.simpleName) as Match?
        val match: Match = matchOrNull ?: Match(1071292, "2022-10-08", "18:00", "AC Milan", 159, "Juventus", 96, "1 - 0", "2 - 0", "Finished", "Serie A", 207, "9")
        matchGlobal = match

        league.text = "${match.leagueName}> ${match.leagueRound} tour"
        homeTeamName.text = match.homeTeam
        status.text = match.status
        date.text = match.date
        time.text = match.time
        awayTeamName.text = match.awayTeam

        val result = match.finalResult.split(" - ")
        if (result.size < 2) {
            result1.text = "?"
            result2.text = "?"
        } else {
            result1.text = result[0]
            result2.text = result[1]
        }

        val htResult = match.halfTimeResult.split(" - ")
        if (htResult.size < 2) {
            htResult1.text = "(?)"
            htResult2.text = "(?)"
        } else {
            htResult1.text = "(${htResult[0]})"
            htResult2.text = "(${htResult[1]})"
        }

        var logo = JSONUtils.getTeamFromJSON(NetworkUtils.getJSONForTeam(match.homeTeamKey))
            ?.team_logo
        if (logo?.endsWith("svg") == true) {
            GlideToVectorYou
                .init()
                .with(this)
                .load(Uri.parse(logo), homeTeamLogo)
        } else {
            Picasso.get().load(logo).into(homeTeamLogo)
        }

        logo = JSONUtils.getTeamFromJSON(NetworkUtils.getJSONForTeam(match.awayTeamKey))
            ?.team_logo
        if (logo?.endsWith("svg") == true) {
            GlideToVectorYou
                .init()
                .with(this)
                .load(Uri.parse(logo), awayTeamLogo)
        } else {
            Picasso.get().load(logo).into(awayTeamLogo)
        }

        rvVideos = findViewById(R.id.rv_videos)
        rvVideos?.layoutManager = LinearLayoutManager(this)
        videos = JSONUtils.getVideosFromJSON(NetworkUtils.getJSONForVideos(match.matchKey))
        rvVideos?.adapter = VideosAdapter(videos ?: ArrayList())

        val noVideos: TextView = findViewById(R.id.no_videos)
        if (videos?.isEmpty() == true) {
            noVideos.visibility = View.VISIBLE
        }
    }

    fun launchLeagueActivity(view: View) {
        val key = matchGlobal?.leagueKey
        if (key in listOf(302, 152, 207, 175, 168, 244)) {
            val intent = Intent(this, LeagueActivity::class.java)
            intent.putExtra("leagueId", key)
            startActivity(intent)
        } else {
            Toast.makeText(this, "League not founded...", Toast.LENGTH_SHORT).show()
        }
    }

    fun launchHomeTeamActivity(view: View) {
        val intent = Intent(this, TeamActivity::class.java)
        intent.putExtra("teamId", matchGlobal?.homeTeamKey)
        intent.putExtra("teamName", matchGlobal?.homeTeam)
        startActivity(intent)
    }

    fun launchAwayTeamActivity(view: View) {
        val intent = Intent(this, TeamActivity::class.java)
        intent.putExtra("teamId", matchGlobal?.awayTeamKey)
        intent.putExtra("teamName", matchGlobal?.awayTeam)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    fun showVideo(view: View) {
        if (videos != null) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videos!![rvVideos?.indexOfChild(view) ?: 0].url))
            startActivity(intent)
        }
    }

    fun showToastHtScore(view: View) {
        Toast.makeText(this, "Halftime score", Toast.LENGTH_SHORT).show()
    }
}
