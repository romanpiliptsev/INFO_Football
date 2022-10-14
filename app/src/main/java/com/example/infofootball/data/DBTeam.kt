package com.example.infofootball.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
class DBTeam {
    @PrimaryKey
    private var teamKey: Int
    private var teamName: String
    private var teamLogo: String

    constructor(teamKey: Int, teamName: String, teamLogo: String) {
        this.teamKey = teamKey
        this.teamName = teamName
        this.teamLogo = teamLogo
    }

    @Ignore
    constructor(team: Team) {
        this.teamKey = team.team_key
        this.teamName = team.team_name
        this.teamLogo = team.team_logo
    }

    fun getTeamKey(): Int {
        return teamKey
    }

    fun getTeamName(): String {
        return teamName
    }

    fun getTeamLogo(): String {
        return teamLogo
    }

    fun setTeamKey(teamKey: Int) {
        this.teamKey = teamKey
    }

    fun setTeamName(teamName: String) {
        this.teamName = teamName
    }

    fun setTeamLogo(teamLogo: String) {
        this.teamLogo = teamLogo
    }

    override fun toString(): String {
        return "DBTeam(teamKey=$teamKey, teamName='$teamName', teamLogo='$teamLogo')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DBTeam

        if (teamKey != other.teamKey) return false
        if (teamName != other.teamName) return false
        if (teamLogo != other.teamLogo) return false

        return true
    }
}
