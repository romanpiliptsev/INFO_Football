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
            val uri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(PARAMS_MET, MET_TEAMS)
                .appendQueryParameter(PARAMS_LEAGUE_ID, leagueId.toString())
                .appendQueryParameter(PARAMS_API_KEY, API_KEY)
                .build()
            try {
                result = URL(uri.toString())
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            }
            return result
        }

        private fun buildURLForTeam(teamId: Int): URL? {
            var result: URL? = null
            val uri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(PARAMS_MET, MET_TEAMS)
                .appendQueryParameter(PARAMS_TEAM_ID, teamId.toString())
                .appendQueryParameter(PARAMS_API_KEY, API_KEY)
                .build()
            try {
                result = URL(uri.toString())
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            }
            return result
        }

        private fun buildURLForH2H(firstTeamId: Int, secondTeamId: Int): URL? {
            var result: URL? = null
            val uri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(PARAMS_MET, MET_H2H)
                .appendQueryParameter(PARAMS_FIRST_TEAM_ID, firstTeamId.toString())
                .appendQueryParameter(PARAMS_SECOND_TEAM_ID, secondTeamId.toString())
                .appendQueryParameter(PARAMS_API_KEY, API_KEY)
                .build()
            try {
                result = URL(uri.toString())
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            }
            return result
        }

        private fun buildURLForTopScorers(leagueId: Int): URL? {
            var result: URL? = null
            val uri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(PARAMS_MET, MET_TOP_SCORERS)
                .appendQueryParameter(PARAMS_LEAGUE_ID, leagueId.toString())
                .appendQueryParameter(PARAMS_API_KEY, API_KEY)
                .build()
            try {
                result = URL(uri.toString())
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            }
            return result
        }

        private fun buildURLForVideos(eventId: Int): URL? {
            var result: URL? = null
            val uri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(PARAMS_MET, MET_VIDEOS)
                .appendQueryParameter(PARAMS_EVENT_ID, eventId.toString())
                .appendQueryParameter(PARAMS_API_KEY, API_KEY)
                .build()
            try {
                result = URL(uri.toString())
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            }
            return result
        }

        fun getJSONForTeamsInLeague(leagueId: Int): JSONObject? {
            var result: JSONObject? = null
            val url: URL? = buildURLForTeamsInLeague(leagueId)
            try {
                result = JSONLoadTask().execute(url).get()
            } catch (e: ExecutionException) {
                e.printStackTrace()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return result
        }

        fun getJSONForTeam(teamId: Int): JSONObject? {
            var result: JSONObject? = null
            val url: URL? = buildURLForTeam(teamId)
            try {
                result = JSONLoadTask().execute(url).get()
            } catch (e: ExecutionException) {
                e.printStackTrace()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return result
        }

        fun getJSONForH2H(firstTeamId: Int, secondTeamId: Int): JSONObject? {
            var result: JSONObject? = null
            val url: URL? = buildURLForH2H(firstTeamId, secondTeamId)
            try {
                result = JSONLoadTask().execute(url).get()
            } catch (e: ExecutionException) {
                e.printStackTrace()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return result
        }

        fun getJSONForTopScorers(leagueId: Int): JSONObject? {
            var result: JSONObject? = null
            val url: URL? = buildURLForTopScorers(leagueId)
            try {
                result = JSONLoadTask().execute(url).get()
            } catch (e: ExecutionException) {
                e.printStackTrace()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return result
        }

        fun getJSONForVideos(eventId: Int): JSONObject? {
            var result: JSONObject? = null
            val url: URL? = buildURLForVideos(eventId)
            try {
                result = JSONLoadTask().execute(url).get()
            } catch (e: ExecutionException) {
                e.printStackTrace()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return result
        }

        fun getJSONForTable(leagueId: Int): JSONObject? {
            val leagueCode = when(leagueId) {
                244 -> "DED"
                302 -> "PD"
                152 -> "PL"
                175 -> "BL1"
                168 -> "FL1"
                207 -> "SA"
                else -> return null
            }

            var url: URL? = null
            val uri = Uri.parse("https://api.football-data.org/v4/competitions/${leagueCode}/standings")
                .buildUpon().build()
            try {
                url = URL(uri.toString())
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            }

            var result: JSONObject? = null
            try {
                result = JSONLoadTaskForTable().execute(url).get()
            } catch (e: ExecutionException) {
                e.printStackTrace()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return result
        }

        fun getJSONForPlayer(playerKey: Long): JSONObject? {
            var url: URL? = null
            val uri = Uri.parse("https://apiv2.allsportsapi.com/football/?&met=Players&playerId=$playerKey&APIkey=fd4b47d15cd499a911fdb0cc666da381d2c026658cf195607512e031e156d662")
                .buildUpon().build()
            try {
                url = URL(uri.toString())
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            }

            var result: JSONObject? = null
            try {
                result = JSONLoadTaskForTable().execute(url).get()
            } catch (e: ExecutionException) {
                e.printStackTrace()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return result
        }

        private class JSONLoadTask : AsyncTask<URL?, Void, JSONObject?>() {
            override fun doInBackground(vararg urls: URL?): JSONObject? {
                var result: JSONObject? = null
                if (urls == null || urls.isEmpty()) {
                    return null
                }
                var connection: HttpURLConnection? = null
                try {
                    connection = urls[0]?.openConnection() as HttpURLConnection
                    val inputStream = connection.inputStream
                    val inputStreamReader = InputStreamReader(inputStream)
                    val reader = BufferedReader(inputStreamReader)
                    val builder = StringBuilder()
                    var line = reader.readLine()
                    while (line != null) {
                        builder.append(line)
                        line = reader.readLine()
                    }
                    result = JSONObject(builder.toString())
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: JSONException) {
                    e.printStackTrace()
                } finally {
                    connection?.disconnect()
                }
                return result
            }
        }

        private class JSONLoadTaskForTable : AsyncTask<URL?, Void, JSONObject?>() {
            override fun doInBackground(vararg urls: URL?): JSONObject? {
                var result: JSONObject? = null
                if (urls == null || urls.isEmpty()) {
                    return null
                }
                var connection: HttpURLConnection? = null
                try {
                    connection = urls[0]?.openConnection() as HttpURLConnection
                    connection.setRequestProperty("X-Auth-Token", "408ba40e9317468fa300038a5d9f3696")
                    val inputStream = connection.inputStream
                    val inputStreamReader = InputStreamReader(inputStream)
                    val reader = BufferedReader(inputStreamReader)
                    val builder = StringBuilder()
                    var line = reader.readLine()
                    while (line != null) {
                        builder.append(line)
                        line = reader.readLine()
                    }
                    result = JSONObject(builder.toString())
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: JSONException) {
                    e.printStackTrace()
                } finally {
                    connection?.disconnect()
                }
                return result
            }
        }
    }
}
