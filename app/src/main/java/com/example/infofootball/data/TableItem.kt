package com.example.infofootball.data

data class TableItem(val position: Int, val id: Int, val name: String, val logo: String,
                     val playedGames: Int, val form: String, val won: Int, val draw: Int,
                     val lost: Int, val points: Int, val goalsFor: Int, val goalsAgainst: Int)