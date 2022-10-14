package com.example.infofootball

import com.example.infofootball.utils.NetworkUtils
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class NetworkUtilsUnitTest {

    @Test
    fun getJSONForTeam_isCorrect() {
        assertTrue(NetworkUtils.getJSONForTeam(96).toString().startsWith(
            "{\"result\":[{\"coaches\":[{\"coach_age\":null,\"coach_name\":\"M. Allegri\",\"coach_country\":null}]"
        ))
    }

    @Test
    fun getJSONForH2H_isCorrect() {
        assertTrue(NetworkUtils.getJSONForH2H(96, 96).toString().startsWith(
            "{\"result\":{\"secondTeamResults\":[{\"league_round\":\"4\",\"away_team_key\":96,\"league_name\":\"UEFA Champions League\",\"league_season\":\"\",\"event_home_team\":\"Maccabi Haifa\""
        ))
    }

    @Test
    fun getJSONForPlayer_isCorrect() {
        assertTrue(NetworkUtils.getJSONForPlayer(103051168).toString().startsWith(
            "{\"result\":[{\"player_shots_total\":\"\",\"player_key_passes\":\"\",\"player_goals_conceded\":\"\",\"player_age\":\"37\",\"player_fouls_commited\":\"\",\"player_pen_missed\":\"\",\"player_red_cards\":\"0\",\"player_dispossesed\":\"\",\"player_rating\":\"\""
        ))
    }

    @Test
    fun getJSONForTable_isCorrect() {
        assertTrue(NetworkUtils.getJSONForTable(302).toString().startsWith(
            "{\"area\":{\"code\":\"ESP\",\"flag\":\"https:\\/\\/crests.football-data.org\\/760.svg\",\"name\":\"Spain\",\"id\":2224}"
        ))
    }

    @Test
    fun getJSONForVideos_isCorrect() {
        assertTrue(NetworkUtils.getJSONForVideos(1071291).toString().startsWith(
            "{\"result\":[{\"video_title_full\":\"Highlights\",\"video_url\":\"http:\\/\\/www.g-video.co\\/4589123.mp4\",\"video_title\":\"Highlights\",\"event_key\":1071291}"
        ))
    }

    @Test
    fun getJSONForTopScorers_isCorrect() {
        assertTrue(NetworkUtils.getJSONForTopScorers(302).toString().startsWith(
            "{\"result\":[{\"player_key\":482155080,\"assists\":null,\"player_name\":\"R. Lewandowski\""
        ))
    }

    @Test
    fun getJSONForTeamsInLeague_isCorrect() {
        assertTrue(NetworkUtils.getJSONForTeamsInLeague(302).toString().contains(
            "\"team_key\":73,\"team_name\":\"Atletico Madrid\",\"team_logo\":\"https:\\/\\/apiv2.allsportsapi.com\\/logo\\/73_atletico-madrid.jpg\""
        ))
    }
}
