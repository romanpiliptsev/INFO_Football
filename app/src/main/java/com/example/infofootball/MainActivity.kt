package com.example.infofootball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private var llLogo: ImageView? = null
    private var plLogo: ImageView? = null
    private var saLogo: ImageView? = null
    private var blLogo: ImageView? = null
    private var l1Logo: ImageView? = null
    private var nlLogo: ImageView? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llLogo = findViewById(R.id.ll)
        plLogo = findViewById(R.id.pl)
        saLogo = findViewById(R.id.sa)
        blLogo = findViewById(R.id.bl)
        l1Logo = findViewById(R.id.l1)
        nlLogo = findViewById(R.id.nl)
    }

    override fun onResume() {
        super.onResume()
        llLogo?.scaleX = 1F; llLogo?.scaleY = 1F
        blLogo?.scaleX = 1.2F; blLogo?.scaleY = 1.2F
        saLogo?.scaleX = 1F; saLogo?.scaleY = 1F
        plLogo?.scaleX = 0.8F; plLogo?.scaleY = 0.8F
        l1Logo?.scaleX = 0.92F; l1Logo?.scaleY = 0.92F
        nlLogo?.scaleX = 0.93F; nlLogo?.scaleY = 0.93F
    }

    fun onClickLl(view: View) {
        view.scaleX *= 1.1F
        view.scaleY *= 1.1F

        val intent = Intent(this, LeagueActivity::class.java)
        intent.putExtra("leagueId", 302)
        startActivity(intent)
    }

    fun onClickPl(view: View) {
        view.scaleX *= 1.1F
        view.scaleY *= 1.1F

        val intent = Intent(this, LeagueActivity::class.java)
        intent.putExtra("leagueId", 152)
        startActivity(intent)
    }

    fun onClickBl(view: View) {
        view.scaleX *= 1.1F
        view.scaleY *= 1.1F

        val intent = Intent(this, LeagueActivity::class.java)
        intent.putExtra("leagueId", 175)
        startActivity(intent)
    }

    fun onClickL1(view: View) {
        view.scaleX *= 1.1F
        view.scaleY *= 1.1F

        val intent = Intent(this, LeagueActivity::class.java)
        intent.putExtra("leagueId", 168)
        startActivity(intent)
    }

    fun onClickNl(view: View) {
        view.scaleX *= 1.05F
        view.scaleY *= 1.05F

        val intent = Intent(this, LeagueActivity::class.java)
        intent.putExtra("leagueId", 244)
        startActivity(intent)
    }

    fun onClickSa(view: View) {
        view.scaleX *= 1.1F
        view.scaleY *= 1.1F

        val intent = Intent(this, LeagueActivity::class.java)
        intent.putExtra("leagueId", 207)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}
