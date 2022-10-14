package com.example.infofootball.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DBTeam::class], version = 1, exportSchema = false)
abstract class FavoritesDatabase : RoomDatabase() {

    companion object {
        private const val DB_NAME: String = "favorites.db"
        private val LOCK = Object()
        private var database: FavoritesDatabase? = null

        fun getInstance(context: Context): FavoritesDatabase? {
            synchronized(LOCK) {
                if (database == null) {
                    database = Room.databaseBuilder(context, FavoritesDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration().build()
                }
            }
            return database
        }
    }

    abstract fun favoritesDao(): FavoritesDao
}
