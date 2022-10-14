package com.example.infofootball.data

import androidx.room.*

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): List<DBTeam>

    @Query("DELETE FROM favorites")
    fun deleteAllFavorites()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(team: DBTeam)

    @Delete
    fun deleteFavorite(team: DBTeam)

    @Query("SELECT * FROM favorites WHERE teamKey == :teamId")
    fun getFavoriteById(teamId: Int): DBTeam
}
