package com.example.infofootball

import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LeagueActivityTest {

    @Test
    fun testStartTeamActivityFromTable() {
        val scenario = ActivityScenario.launch(LeagueActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity {
            (it.findViewById(R.id.rv_table_items) as RecyclerView).getChildAt(0)
                .performClick()
        }
    }

    @Test
    fun testStartTeamActivityFromTopScorer() {
        val scenario = ActivityScenario.launch(LeagueActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity {
            (it.findViewById(R.id.rv_top_scorers) as RecyclerView).getChildAt(0)
                .performClick()
        }
    }
}
