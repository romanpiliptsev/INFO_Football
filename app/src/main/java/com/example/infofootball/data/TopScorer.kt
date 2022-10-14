package com.example.infofootball.data

data class TopScorer(val place: Int, val name: String, val playerKey: Long, val teamName: String,
                     val teamKey: Int, val goals: Int, val assists: String, val penGoals: Int)