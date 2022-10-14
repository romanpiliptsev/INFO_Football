package com.example.infofootball

import android.app.Application
import com.example.infofootball.data.DBTeam
import com.example.infofootball.data.MainViewModel
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class DBUnitTest {
    private val app: Application = RuntimeEnvironment.application
    private val vm: MainViewModel = MainViewModel(app)

    @Test
    fun dbMethods_areCorrect() {
        val dbTeam = DBTeam(1, "", "")

        vm.insertFavorite(dbTeam)
        assertTrue(vm.getFavorites()?.get(0)?.equals(dbTeam) ?: false)

        assertTrue(vm.getFavoriteById(1)?.equals(dbTeam) ?: false)

        vm.deleteFavorite(dbTeam)
        assertTrue(vm.getFavorites()?.isEmpty() ?: false)

        vm.insertFavorite(dbTeam)
        vm.insertFavorite(dbTeam)
        vm.deleteAllFavorites()
        assertTrue(vm.getFavorites()?.isEmpty() ?: false)
    }
}
