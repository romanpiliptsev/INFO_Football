package com.example.infofootball

import android.widget.ImageView
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testStartLeagueActivityLaLiga() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity {
            it.findViewById<ImageView>(R.id.ll).performClick()
        }
    }

    @Test
    fun testStartLeagueActivityPremiereLeague() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity {
            it.findViewById<ImageView>(R.id.pl).performClick()
        }
    }

    @Test
    fun testStartLeagueActivityNetherlandsLeague() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)

        scenario.onActivity {
            it.findViewById<ImageView>(R.id.nl).performClick()
        }
    }

    @Test
    fun testStartLeagueActivityBundesliga() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity {
            it.findViewById<ImageView>(R.id.bl).performClick()
        }
    }

    @Test
    fun testStartLeagueActivityLigue1() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity {
            it.findViewById<ImageView>(R.id.l1).performClick()
        }
    }

    @Test
    fun testStartLeagueActivitySerieA() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity {
            it.findViewById<ImageView>(R.id.sa).performClick()
        }
    }
}
