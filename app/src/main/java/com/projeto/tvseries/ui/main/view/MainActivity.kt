package com.projeto.tvseries.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import com.projeto.tvseries.R
import com.projeto.tvseries.databinding.ActivityMainBinding
import com.projeto.tvseries.ui.main.adapter.ShowAdapter
import com.projeto.tvseries.ui.main.viewmodel.ShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ShowViewModel by viewModels()
    private lateinit var showAdapter: ShowAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.VISIBLE

        /**
         * LOAD
         */
        getShowList()

        /**
         * TOOLBAR
         */
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        /**
         * HIDE UP BUTTON
         */
        supportActionBar?.setDisplayHomeAsUpEnabled(false)


    }

    private fun getShowList() {
        showAdapter = ShowAdapter()

        binding.recyclerView.apply {
            adapter = showAdapter

            layoutManager = GridLayoutManager(this@MainActivity, 2)

            setHasFixedSize(true)
        }

        viewModel.responseShow.observe(
            this, {listShows ->
                showAdapter.show = listShows

                binding.progressBar.visibility = View.GONE
            }
        )
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