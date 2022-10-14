package com.example.infofootball

import com.example.infofootball.adapters.*
import com.example.infofootball.data.*
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AdaptersUnitTest {
    private var matchesAdapter: MatchesAdapter? = null
    private var playersAdapter: PlayersAdapter? = null
    private var tableAdapter: TableAdapter? = null
    private var topScorerAdapter: TopScorersAdapter? = null
    private var videosAdapter: VideosAdapter? = null

    @Before
    fun before() {
        matchesAdapter = MatchesAdapter(listOf(Match(1, "", "", "", 1, "", 2, "", "", "", "", 1, "")), null, "1")
        playersAdapter = PlayersAdapter(listOf(Player("", 1, "", 1, 1, 1, 1, 1, "")))
        tableAdapter = TableAdapter(listOf(TableItem(1, 1, "", "", 1, "", 1, 1, 1, 1, 1, 1)))
        topScorerAdapter = TopScorersAdapter(listOf(
            TopScorer(1, "", 1, "", 1, 1, "", 1),
            TopScorer(2, "", 2, "", 1, 1, "", 1)
        ))
    }

    @Test
    fun matchesAdapter_getItemCount_isCorrect() {
        assertEquals(matchesAdapter?.itemCount, 1)
    }

    @Test
    fun playersAdapter_getItemCount_isCorrect() {
        assertEquals(playersAdapter?.itemCount, 1)
    }

    @Test
    fun tableAdapter_getItemCount_isCorrect() {
        assertEquals(tableAdapter?.itemCount, 1)
    }

    @Test
    fun topScorerAdapter_getItemCount_isCorrect() {
        assertEquals(topScorerAdapter?.itemCount, 2)
    }

    @Test
    fun videosAdapter_getItemCount_isCorrect() {
        assertEquals(videosAdapter?.itemCount, 3)
    }
}
