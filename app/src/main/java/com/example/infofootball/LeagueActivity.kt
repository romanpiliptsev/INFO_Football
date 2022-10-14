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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.favorites) {
            startActivity(Intent(this, FavoritesActivity::class.java))
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
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
        return when(id1) {
            81 -> 97
            86 -> 76
            77 -> 7258
            90 -> 7261
            95 -> 7272
            78 -> 73
            92 -> 153
            79 -> 7269
            94 -> 162
            87 -> 7264
            558 -> 7290
            89 -> 7285
            298 -> 7263
            267 -> 7260
            250 -> 7262
            80 -> 7268
            559 -> 89
            264 -> 7277
            285 -> 7274
            82 -> 7288
            65 -> 80
            57 -> 141
            73 -> 164
            61 -> 88
            67 -> 3100
            397 -> 3079
            66 -> 102
            1044 -> 3071
            63 -> 3085
            64 -> 84
            62 -> 3073
            402 -> 3086
            341 -> 3103
            58 -> 3088
            563 -> 3081
            340 -> 3072
            354 -> 3429
            76 -> 3077
            338 -> 155
            351 -> 3089
            113 -> 152
            98 -> 159
            102 -> 85
            115 -> 4984
            110 -> 93
            100 -> 139
            108 -> 79
            109 -> 96
            471 -> 4975
            586 -> 4973
            99 -> 4974
            488 -> 4977
            5890 -> 5010
            455 -> 5012
            445 -> 4979
            103 -> 4983
            5911 -> 4990
            450 -> 4982
            457 -> 4998
            584 -> 4985
            28 -> 3936
            17 -> 3962
            5 -> 72
            4 -> 92
            12 -> 3930
            2 -> 170
            19 -> 3945
            1 -> 3932
            16 -> 3934
            721 -> 101
            18 -> 77
            15 -> 3939
            11 -> 196
            3 -> 143
            9 -> 4268
            6 -> 3931
            10 -> 3933
            36 -> 3911
            524 -> 100
            516 -> 83
            525 -> 3814
            546 -> 3821
            548 -> 3817
            529 -> 91
            523 -> 3815
            521 -> 160
            541 -> 3793
            518 -> 3819
            511 -> 3794
            531 -> 3792
            522 -> 145
            547 -> 182
            519 -> 3797
            532 -> 3827
            543 -> 3820
            510 -> 3806
            512 -> 3823
            576 -> 3823
            678 -> 86
            682 -> 113
            6806 -> 5512
            673 -> 5464
            676 -> 5475
            718 -> 5469
            1909 -> 5472
            1919 -> 5462
            677 -> 5488
            666 -> 5473
            1914 -> 5463
            1915 -> 5466
            683 -> 5476
            675 -> 168
            674 -> 150
            670 -> 5459
            1920 -> 5467
            679 -> 5460
            else -> 0
        }
    }
}
