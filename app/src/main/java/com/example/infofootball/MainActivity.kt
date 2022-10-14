package com.example.infofootball

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
    }

    fun onClickLl(view: View) {
    }

    fun onClickPl(view: View) {
    }

    fun onClickBl(view: View) {
    }

    fun onClickL1(view: View) {
    }

    fun onClickNl(view: View) {
    }

    fun onClickSa(view: View) {
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}
