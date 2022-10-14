package com.example.infofootball.data

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import java.util.concurrent.ExecutionException

class MainViewModel(application: Application) : AndroidViewModel(application) {

    companion object {
        private var database: FavoritesDatabase? = null
    }

    init {
        database = FavoritesDatabase.getInstance(getApplication())!!
    }

    fun getFavorites(): List<DBTeam>? {
        return null
    }

    fun deleteAllFavorites() {

    }

    fun insertFavorite(team: DBTeam) {

    }

    fun deleteFavorite(team: DBTeam) {

    }

    fun getFavoriteById(id: Int): DBTeam? {
        return null
    }
}
