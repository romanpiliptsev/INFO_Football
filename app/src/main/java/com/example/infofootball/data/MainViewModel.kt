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
        return GetAllFavoritesTask().execute().get()
    }

    private class GetAllFavoritesTask : AsyncTask<Void, Void, List<DBTeam>?>() {
        override fun doInBackground(vararg p0: Void): List<DBTeam>? {
            return database?.favoritesDao()?.getAllFavorites()
        }
    }

    fun deleteAllFavorites() {
        DeleteAllFavoritesTask().execute()
    }

    private class DeleteAllFavoritesTask : AsyncTask<Void, Void, Void?>() {
        override fun doInBackground(vararg p0: Void): Void? {
            database?.favoritesDao()?.deleteAllFavorites()
            return null
        }
    }

    fun insertFavorite(team: DBTeam) {
        InsertFavoriteTask().execute(team)
    }

    private class InsertFavoriteTask : AsyncTask<DBTeam, Void, Void?>() {
        override fun doInBackground(vararg p0: DBTeam): Void? {
            database?.favoritesDao()?.insertFavorite(p0[0])
            return null
        }
    }

    fun deleteFavorite(team: DBTeam) {
        DeleteFavoriteTask().execute(team)
    }

    private class DeleteFavoriteTask : AsyncTask<DBTeam, Void, Void?>() {
        override fun doInBackground(vararg p0: DBTeam): Void? {
            database?.favoritesDao()?.deleteFavorite(p0[0])
            return null
        }
    }

    fun getFavoriteById(id: Int): DBTeam? {
        try {
            return GetFavoriteByIdTask().execute(id).get()
        } catch (e: ExecutionException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return null
    }

    private class GetFavoriteByIdTask : AsyncTask<Int, Void, DBTeam?>() {
        override fun doInBackground(vararg p0: Int?): DBTeam? {
            return database?.favoritesDao()?.getFavoriteById(p0[0] ?: 0)
        }
    }
}
