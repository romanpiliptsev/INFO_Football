package com.example.infofootball.utils

import android.net.Uri
import android.os.AsyncTask
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.concurrent.ExecutionException

class NetworkUtils {

    /*https://apiv2.allsportsapi.com/football/?&met=Teams&leagueId=302&APIkey=fd4b47d15cd499a911fdb0cc666da381d2c026658cf195607512e031e156d662
    // ла лига, команды */

//    https://apiv2.allsportsapi.com/football/?met=H2H&APIkey=fd4b47d15cd499a911fdb0cc666da381d2c026658cf195607512e031e156d662&firstTeamId=73&secondTeamId=76

//    https://apiv2.allsportsapi.com/football/?&met=Topscorers&leagueId=302&APIkey=fd4b47d15cd499a911fdb0cc666da381d2c026658cf195607512e031e156d662

//    https://apiv2.allsportsapi.com/football/?&met=Videos&eventId=1142555&APIkey=fd4b47d15cd499a911fdb0cc666da381d2c026658cf195607512e031e156d662

    companion object {
        private const val BASE_URL = "https://apiv2.allsportsapi.com/football/"

        private const val PARAMS_MET = "met"
        private const val PARAMS_API_KEY = "APIkey"
        private const val PARAMS_LEAGUE_ID = "leagueId"
        private const val PARAMS_FIRST_TEAM_ID = "firstTeamId"
        private const val PARAMS_SECOND_TEAM_ID = "secondTeamId"
        private const val PARAMS_EVENT_ID = "eventId"
        private const val PARAMS_TEAM_ID = "teamId"

        private const val MET_TEAMS = "Teams"
        private const val MET_H2H = "H2H"
        private const val MET_TOP_SCORERS = "Topscorers"
        private const val MET_VIDEOS = "Videos"
        private const val API_KEY = "fd4b47d15cd499a911fdb0cc666da381d2c026658cf195607512e031e156d662"

        private fun buildURLForTeamsInLeague(leagueId: Int): URL? {
            var result: URL? = null

            return result
        }

        private fun buildURLForTeam(teamId: Int): URL? {
            var result: URL? = null

            return result
        }

        private fun buildURLForH2H(firstTeamId: Int, secondTeamId: Int): URL? {
            var result: URL? = null

            return result
        }

        private fun buildURLForTopScorers(leagueId: Int): URL? {
            var result: URL? = null

            return result
        }

        private fun buildURLForVideos(eventId: Int): URL? {
            var result: URL? = null

            return result
        }

        fun getJSONForTeamsInLeague(leagueId: Int): JSONObject? {
            var result: JSONObject? = null

            return result
        }

        fun getJSONForTeam(teamId: Int): JSONObject? {
            var result: JSONObject? = null

            return result
        }

        fun getJSONForH2H(firstTeamId: Int, secondTeamId: Int): JSONObject? {
            var result: JSONObject? = null

            return result
        }

        fun getJSONForTopScorers(leagueId: Int): JSONObject? {
            var result: JSONObject? = null

            return result
        }

        fun getJSONForVideos(eventId: Int): JSONObject? {
            var result: JSONObject? = null

            return result
        }

        fun getJSONForTable(leagueId: Int): JSONObject? {

            return null
        }

        fun getJSONForPlayer(playerKey: Long): JSONObject? {
            return null
        }

        private class JSONLoadTask : AsyncTask<URL?, Void, JSONObject?>() {
            override fun doInBackground(vararg urls: URL?): JSONObject? {
                return null
            }
        }

        private class JSONLoadTaskForTable : AsyncTask<URL?, Void, JSONObject?>() {
            override fun doInBackground(vararg urls: URL?): JSONObject? {
                return null
            }
        }
    }
}
