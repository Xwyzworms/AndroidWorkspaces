package com.example.simplemovieapp.presentation.movie

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
import com.example.simplemovieapp.databinding.ActivityMovieBinding
import com.example.simplemovieapp.presentation.di.Injector
import com.example.simplemovieapp.presentation.movie.viewmodel.MovieRecyclerViewAdapter
import com.example.simplemovieapp.presentation.movie.viewmodel.MovieViewModel
import com.example.simplemovieapp.presentation.movie.viewmodel.MovieViewModelFactory
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory : MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding : ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        setSupportActionBar(binding.myToolbar)
        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        setupRecyclerView()
    }

    private fun setupRecyclerView()
    {
        lateinit var adapter: MovieRecyclerViewAdapter
        val layoutManager = LinearLayoutManager(this)
        movieViewModel.getMovies().observe(this) {movies ->
            adapter = MovieRecyclerViewAdapter(movies)
            binding.movieRecyclerView.layoutManager = layoutManager
            binding.movieRecyclerView.adapter = adapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val layoutInflater : MenuInflater = menuInflater
        layoutInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        lateinit var adapter: MovieRecyclerViewAdapter
        return when(item.itemId) {
                R.id.update_data -> {
                    movieViewModel.updateMovies().observe(this) {movies->
                        adapter = MovieRecyclerViewAdapter(movies)
                        binding.movieRecyclerView.adapter = adapter
                    }
                    true
                }
            else->
                return super.onOptionsItemSelected(item)
        }
    }
}