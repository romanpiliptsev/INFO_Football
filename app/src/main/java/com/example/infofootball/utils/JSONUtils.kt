package com.example.infofootball.utils

import com.example.infofootball.data.*
import org.json.JSONException
import org.json.JSONObject

class JSONUtils {

    companion object {
        private const val KEY_RESULT = "result"

        private const val KEY_TEAM_KEY = "team_key"
        private const val KEY_TEAM_NAME = "team_name"
        private const val KEY_TEAM_LOGO = "team_logo"
        private const val KEY_TEAM_COACH = "coaches"
        private const val KEY_TEAM_PLAYERS = "players"

        private const val KEY_PLAYER_NAME = "player_name"
        private const val KEY_PLAYER_NUMBER = "player_number"
        private const val KEY_PLAYER_TYPE = "player_type"
        private const val KEY_PLAYER_AGE = "player_age"
        private const val KEY_PLAYER_MATCH_PLAYED = "player_match_played"
        private const val KEY_PLAYER_GOALS = "player_goals"
        private const val KEY_PLAYER_YELLOW_CARDS = "player_yellow_cards"
        private const val KEY_PLAYER_RED_CARDS = "player_red_cards"
        private const val KEY_PLAYER_IMAGE = "player_image"

        private const val KEY_COACH_NAME = "coach_name"

        // ----------------------------------------------------------------------------

        private const val KEY_STANDINGS = "standings"

        private const val KEY_TABLE = "table"

        private const val KEY_POSITION = "position"
        private const val KEY_TEAM_FROM_TABLE = "team"
        private const val KEY_PLAYED_GAMES = "playedGames"
        private const val KEY_FORM = "form"
        private const val KEY_WON = "won"
        private const val KEY_DRAW = "draw"
        private const val KEY_LOST = "lost"
        private const val KEY_POINTS = "points"
        private const val KEY_GOALS_FOR = "goalsFor"
        private const val KEY_GOALS_AGAINST = "goalsAgainst"

        private const val KEY_ID_FROM_TABLE = "id"
        private const val KEY_NAME_FROM_TABLE = "name"
        private const val KEY_SHORT_NAME_FROM_TABLE = "shortName"
        private const val KEY_CREST = "crest"

        // ---------------------------------------------------------------------------

        private const val KEY_FIRST_TEAM_RESULTS = "firstTeamResults"

        private const val KEY_EVENT_KEY = "event_key"
        private const val KEY_EVENT_DATE = "event_date"
        private const val KEY_EVENT_TIME = "event_time"
        private const val KEY_EVENT_HOME_TEAM = "event_home_team"
        private const val KEY_HOME_TEAM_KEY = "home_team_key"
        private const val KEY_EVENT_AWAY_TEAM = "event_away_team"
        private const val KEY_AWAY_TEAM_KEY = "away_team_key"
        private const val KEY_EVENT_HALFTIME_RESULT = "event_halftime_result"
        private const val KEY_EVENT_FINAL_RESULT = "event_final_result"
        private const val KEY_EVENT_STATUS = "event_status"
        private const val KEY_LEAGUE_NAME = "league_name"
        private const val KEY_LEAGUE_KEY = "league_key"
        private const val KEY_LEAGUE_ROUND = "league_round"

        // ---------------------------------------------------------------------------

        private const val KEY_TOP_SCORER_PLAYER_PLACE = "player_place"
        private const val KEY_TOP_SCORER_PLAYER_NAME = "player_name"
        private const val KEY_TOP_SCORER_TEAM_NAME = "team_name"
        private const val KEY_TOP_SCORER_TEAM_KEY = "team_key"
        private const val KEY_TOP_SCORER_GOALS = "goals"
        private const val KEY_TOP_SCORER_ASSISTS = "assists"
        private const val KEY_TOP_SCORER_PENALTY_GOALS = "penalty_goals"
        private const val KEY_TOP_SCORER_PLAYER_KEY = "player_key"

        //-----------------------------------------------------------------------------

        private const val KEY_VIDEO_EVENT_KEY = "event_key"
        private const val KEY_VIDEO_TITLE = "video_title_full"
        private const val KEY_VIDEO_URL = "video_url"


        fun getLeagueTeamsFromJSON(jsonObject: JSONObject?): ArrayList<Team> {
            val result: ArrayList<Team> = ArrayList<Team>()
            if (jsonObject == null) {
                return result
            }
            try {
                val jsonArrayOfTeams = jsonObject.getJSONArray(KEY_RESULT)
                for (i in 0 until jsonArrayOfTeams.length()) {
                    val jsonObjectTeam = jsonArrayOfTeams.getJSONObject(i)

                    val jsonArrayOfTeamPlayers = jsonObjectTeam.getJSONArray(KEY_TEAM_PLAYERS)
                    val playersArraylist: ArrayList<Player> = ArrayList<Player>()
                    for (j in 0 until jsonArrayOfTeamPlayers.length()) {
                        val jsonObjectPlayer = jsonArrayOfTeamPlayers.getJSONObject(j)

                        // ПРИМЕЧАНИЕ: некоторые игроки не добавляются
                        // из-за несоответствия типов в JSON дате
                        try {
                            playersArraylist.add(
                                Player(
                                    jsonObjectPlayer.getString(KEY_PLAYER_NAME),
                                    jsonObjectPlayer.getInt(KEY_PLAYER_NUMBER),
                                    jsonObjectPlayer.getString(KEY_PLAYER_TYPE),
                                    jsonObjectPlayer.getInt(KEY_PLAYER_AGE),
                                    jsonObjectPlayer.getInt(KEY_PLAYER_MATCH_PLAYED),
                                    jsonObjectPlayer.getInt(KEY_PLAYER_GOALS),
                                    jsonObjectPlayer.getInt(KEY_PLAYER_YELLOW_CARDS),
                                    jsonObjectPlayer.getInt(KEY_PLAYER_RED_CARDS),
                                    jsonObjectPlayer.getString(KEY_PLAYER_IMAGE)
                                )
                            )
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }

                    result.add(Team(
                        jsonObjectTeam.getInt(KEY_TEAM_KEY),
                        jsonObjectTeam.getString(KEY_TEAM_NAME),
                        jsonObjectTeam.getString(KEY_TEAM_LOGO),
                        jsonObjectTeam.getJSONArray(KEY_TEAM_COACH).getJSONObject(0)
                            .getString(KEY_COACH_NAME),
                        playersArraylist
                    ))
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return result
        }

        fun getTeamFromJSON(jsonObject: JSONObject?): Team? {
            val result = null
            if (jsonObject == null) {
                return result
            }
            try {
                val jsonObjectTeam = jsonObject.getJSONArray(KEY_RESULT).getJSONObject(0)

                val jsonArrayOfTeamPlayers = jsonObjectTeam.getJSONArray(KEY_TEAM_PLAYERS)
                val playersArraylist: ArrayList<Player> = ArrayList<Player>()
                for (j in 0 until jsonArrayOfTeamPlayers.length()) {
                    val jsonObjectPlayer = jsonArrayOfTeamPlayers.getJSONObject(j)

                    // ПРИМЕЧАНИЕ: некоторые игроки не добавляются
                    // из-за несоответствия типов в JSON дате
                    try {
                        playersArraylist.add(
                            Player(
                                jsonObjectPlayer.getString(KEY_PLAYER_NAME),
                                jsonObjectPlayer.getInt(KEY_PLAYER_NUMBER),
                                jsonObjectPlayer.getString(KEY_PLAYER_TYPE),
                                jsonObjectPlayer.getInt(KEY_PLAYER_AGE),
                                jsonObjectPlayer.getInt(KEY_PLAYER_MATCH_PLAYED),
                                jsonObjectPlayer.getInt(KEY_PLAYER_GOALS),
                                jsonObjectPlayer.getInt(KEY_PLAYER_YELLOW_CARDS),
                                jsonObjectPlayer.getInt(KEY_PLAYER_RED_CARDS),
                                jsonObjectPlayer.getString(KEY_PLAYER_IMAGE)
                            )
                        )
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                return Team(
                    jsonObjectTeam.getInt(KEY_TEAM_KEY),
                    jsonObjectTeam.getString(KEY_TEAM_NAME),
                    jsonObjectTeam.getString(KEY_TEAM_LOGO),
                    jsonObjectTeam.getJSONArray(KEY_TEAM_COACH).getJSONObject(0)
                        .getString(KEY_COACH_NAME),
                    playersArraylist
                )
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return result
        }

        fun getTableItemsFromJSON(jsonObject: JSONObject?): ArrayList<TableItem> {
            val result: ArrayList<TableItem> = ArrayList<TableItem>()
            if (jsonObject == null) {
                return result
            }
            try {
                val jsonArrayOfTableItems = jsonObject.getJSONArray(KEY_STANDINGS)
                    .getJSONObject(0)
                    .getJSONArray(KEY_TABLE)
                for (i in 0 until jsonArrayOfTableItems.length()) {
                    val jsonObjectTableItem = jsonArrayOfTableItems.getJSONObject(i)

                    val jsonObjectTeam = jsonObjectTableItem.getJSONObject(KEY_TEAM_FROM_TABLE)

                    result.add(
                        TableItem(
                            jsonObjectTableItem.getInt(KEY_POSITION),
                            jsonObjectTeam.getInt(KEY_ID_FROM_TABLE),
                            jsonObjectTeam.getString(KEY_SHORT_NAME_FROM_TABLE),
                            jsonObjectTeam.getString(KEY_CREST),
                            jsonObjectTableItem.getInt(KEY_PLAYED_GAMES),
                            jsonObjectTableItem.getString(KEY_FORM),
                            jsonObjectTableItem.getInt(KEY_WON),
                            jsonObjectTableItem.getInt(KEY_DRAW),
                            jsonObjectTableItem.getInt(KEY_LOST),
                            jsonObjectTableItem.getInt(KEY_POINTS),
                            jsonObjectTableItem.getInt(KEY_GOALS_FOR),
                            jsonObjectTableItem.getInt(KEY_GOALS_AGAINST)
                        )
                    )
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return result
        }

        fun getMatchesFromJSON(jsonObject: JSONObject?): ArrayList<Match> {
            val result = ArrayList<Match>()
            if (jsonObject == null) {
                return result
            }
            try {
                val jsonArrayOfMatches = jsonObject.getJSONObject(KEY_RESULT)
                    .getJSONArray(KEY_FIRST_TEAM_RESULTS)

                for (i in 0 until jsonArrayOfMatches.length()) {
                    val jsonObjectMatch = jsonArrayOfMatches.getJSONObject(i)

                    try {
                        result.add(
                            Match(
                                jsonObjectMatch.getInt(KEY_EVENT_KEY),
                                jsonObjectMatch.getString(KEY_EVENT_DATE),
                                jsonObjectMatch.getString(KEY_EVENT_TIME),
                                jsonObjectMatch.getString(KEY_EVENT_HOME_TEAM),
                                jsonObjectMatch.getInt(KEY_HOME_TEAM_KEY),
                                jsonObjectMatch.getString(KEY_EVENT_AWAY_TEAM),
                                jsonObjectMatch.getInt(KEY_AWAY_TEAM_KEY),
                                jsonObjectMatch.getString(KEY_EVENT_HALFTIME_RESULT),
                                jsonObjectMatch.getString(KEY_EVENT_FINAL_RESULT),
                                jsonObjectMatch.getString(KEY_EVENT_STATUS),
                                jsonObjectMatch.getString(KEY_LEAGUE_NAME),
                                jsonObjectMatch.getInt(KEY_LEAGUE_KEY),
                                jsonObjectMatch.getString(KEY_LEAGUE_ROUND)
                            )
                        )
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return result
        }

        fun getTopScorersFromJSON(jsonObject: JSONObject?): ArrayList<TopScorer> {
            val result = ArrayList<TopScorer>()
            if (jsonObject == null) {
                return result
            }
            try {
                val jsonArrayOfTopScorers = jsonObject.getJSONArray(KEY_RESULT)

                for (i in 0 until jsonArrayOfTopScorers.length()) {
                    val jsonObjectTopScorer = jsonArrayOfTopScorers.getJSONObject(i)

                    var ass = "?"
                    for (j in 0..0) {
                        try {
                            ass = jsonObjectTopScorer.getInt(KEY_TOP_SCORER_ASSISTS).toString()
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }

                    try {
                        result.add(
                            TopScorer(
                                jsonObjectTopScorer.getInt(KEY_TOP_SCORER_PLAYER_PLACE),
                                jsonObjectTopScorer.getString(KEY_TOP_SCORER_PLAYER_NAME),
                                jsonObjectTopScorer.getLong(KEY_TOP_SCORER_PLAYER_KEY),
                                jsonObjectTopScorer.getString(KEY_TOP_SCORER_TEAM_NAME),
                                jsonObjectTopScorer.getInt(KEY_TOP_SCORER_TEAM_KEY),
                                jsonObjectTopScorer.getInt(KEY_TOP_SCORER_GOALS),
                                ass,
                                jsonObjectTopScorer.getInt(KEY_TOP_SCORER_PENALTY_GOALS)
                            )
                        )
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return result
        }

        /*fun getPlayerPhotoFromJSON(jsonObject: JSONObject?): String {
            var result = ""
            if (jsonObject == null) {
                return result
            }
            try {
                result = jsonObject.getJSONArray(KEY_RESULT).getJSONObject(0).getString("player_image")
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return result
        }*/

        fun getVideosFromJSON(jsonObject: JSONObject?): ArrayList<Video> {
            val result = ArrayList<Video>()
            if (jsonObject == null) {
                return result
            }
            try {
                val videos = jsonObject.getJSONArray(KEY_RESULT)

                for (i in 0 until videos.length()) {
                    val videoObject = videos.getJSONObject(i)

                    result.add(
                        Video(
                            videoObject.getInt(KEY_VIDEO_EVENT_KEY),
                            videoObject.getString(KEY_VIDEO_TITLE),
                            videoObject.getString(KEY_VIDEO_URL)
                        )
                    )
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return result
        }
    }
}
