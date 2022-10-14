package com.example.infofootball

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.infofootball.adapters.FavoritesAdapter
import com.example.infofootball.data.DBTeam
import com.example.infofootball.data.MainViewModel

class FavoritesActivity : AppCompatActivity() {

    private var viewModel: MainViewModel? = null
    private var favorites: List<DBTeam> = ArrayList()
    private var rvFavorites: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        viewModel = MainViewModel(application)
        rvFavorites = findViewById(R.id.rv_favorites)
        rvFavorites?.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        favorites = viewModel?.getFavorites() ?: ArrayList()
        rvFavorites?.adapter = FavoritesAdapter(favorites)

        val empty: TextView = findViewById(R.id.empty)
        if (favorites.isEmpty()) {
            empty.visibility = View.VISIBLE
        } else {
            empty.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.main) {
            startActivity(Intent(this, MainActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    fun launchTeamActivity(view: View) {
        val intent = Intent(this, TeamActivity::class.java)
        val teamId = favorites[rvFavorites?.indexOfChild(view) ?: 0].getTeamKey()

        if (teamId == 0) {
            Toast.makeText(this, "Sorry, team not found...", Toast.LENGTH_SHORT).show()
        } else {
            intent.putExtra("teamId", teamId)
            intent.putExtra("teamName", favorites[rvFavorites?.indexOfChild(view) ?: 0]
                .getTeamName())
            startActivity(intent)
        }
    }
}
