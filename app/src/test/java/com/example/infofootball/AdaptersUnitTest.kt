package com.example.infofootball

import com.example.infofootball.adapters.*
import com.example.infofootball.data.*
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AdaptersUnitTest {
    private var tableAdapter: TableAdapter? = null
    private var topScorerAdapter: TopScorersAdapter? = null

    @Before
    fun before() {
        tableAdapter = TableAdapter(listOf(TableItem(1, 1, "", "", 1, "", 1, 1, 1, 1, 1, 1)))
        topScorerAdapter = TopScorersAdapter(listOf(
            TopScorer(1, "", 1, "", 1, 1, "", 1),
            TopScorer(2, "", 2, "", 1, 1, "", 1)
        ))
    }

    @Test
    fun tableAdapter_getItemCount_isCorrect() {
        assertEquals(tableAdapter?.itemCount, 1)
    }

    @Test
    fun topScorerAdapter_getItemCount_isCorrect() {
        assertEquals(topScorerAdapter?.itemCount, 2)
    }
}
