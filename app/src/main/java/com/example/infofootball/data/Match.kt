package com.example.infofootball.data

import java.io.Serializable

data class Match(val matchKey: Int, val date: String, val time: String, val homeTeam: String,
                 val homeTeamKey: Int, val awayTeam: String, val awayTeamKey: Int,
                 val halfTimeResult: String, val finalResult: String, val status: String,
                 val leagueName: String, val leagueKey: Int, val leagueRound: String) : Serializable