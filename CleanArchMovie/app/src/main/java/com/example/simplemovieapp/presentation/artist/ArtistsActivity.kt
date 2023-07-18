package com.example.simplemovieapp.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplemovieapp.R
import com.example.simplemovieapp.databinding.ActivityArtistsBinding
import com.example.simplemovieapp.presentation.artist.viewmodel.ArtistRecyclerViewAdapter
import com.example.simplemovieapp.presentation.artist.viewmodel.ArtistsViewModel
import com.example.simplemovieapp.presentation.artist.viewmodel.ArtistsViewModelFactory
import com.example.simplemovieapp.presentation.di.Injector
import com.example.simplemovieapp.presentation.movie.viewmodel.MovieRecyclerViewAdapter
import javax.inject.Inject

class ArtistsActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ArtistsViewModelFactory

    private lateinit var binding : ActivityArtistsBinding
    private lateinit var viewModel : ArtistsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists);
        setSupportActionBar(binding.myToolbar)
        (application as Injector).createArtistSubComponent().inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ArtistsViewModel::class.java)
        setupArtistsRecyclerView()
    }

    private fun setupArtistsRecyclerView()
    {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.getArtists().observe(this) {artists->
            Log.d("HEYAA",artists.toString())
            binding.movieRecyclerView.adapter = ArtistRecyclerViewAdapter(artists)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val layoutInflater : MenuInflater = menuInflater
        layoutInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        lateinit var adapter: ArtistRecyclerViewAdapter
        return when(item.itemId) {
            R.id.update_data -> {
                viewModel.updateArtists().observe(this) {artists->
                    adapter = ArtistRecyclerViewAdapter(artists)
                    binding.movieRecyclerView.adapter = adapter
                }
                true
            }
            else->
                return super.onOptionsItemSelected(item)
        }
    }

}