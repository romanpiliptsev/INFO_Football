package com.example.infofootball

import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MatchActivityTest {

    @Test
    fun testStartHomeTeamActivity() {
        val scenario = ActivityScenario.launch(MatchActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity {
            it.findViewById<TextView>(R.id.home_team_name).performClick()
        }
    }

    @Test
    fun testStartAwayTeamActivity() {
        val scenario = ActivityScenario.launch(MatchActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity {
            it.findViewById<TextView>(R.id.away_team_name).performClick()
        }
    }

    @Test
    fun testStartLeagueActivity() {
        val scenario = ActivityScenario.launch(MatchActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity {
            it.findViewById<TextView>(R.id.league).performClick()
        }
    }
}
