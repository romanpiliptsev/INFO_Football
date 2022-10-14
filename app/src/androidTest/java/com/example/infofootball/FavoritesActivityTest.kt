package com.example.infofootball

import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FavoritesActivityTest {

    @Test
    fun testStartTeamActivityFromFavorites() {
        val scenario = ActivityScenario.launch(FavoritesActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity {
            (it.findViewById(R.id.rv_favorites) as RecyclerView).getChildAt(0)
                .performClick()
        }
    }
}
