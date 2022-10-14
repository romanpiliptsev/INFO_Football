package com.example.infofootball.data

data class Team(val team_key: Int, val team_name: String, val team_logo: String,
                val coach: String, val players: ArrayList<Player>)