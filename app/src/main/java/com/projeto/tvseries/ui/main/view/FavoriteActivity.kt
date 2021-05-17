package com.projeto.tvseries.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.projeto.tvseries.R

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        /**
         * TOOLBAR
         */
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        /**
         * UP BUTTON
         */
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.overflowIcon = getDrawable(R.drawable.ic_more)
    }

    /**
     * INFLATE MENU
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.search -> {
            // Action
            true
        }
        R.id.searchPerson -> {
            // Action
            true
        }
        R.id.viewFavorite -> {
            val intentFavorite = Intent(this, FavoriteActivity::class.java)
            startActivity(intentFavorite)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}