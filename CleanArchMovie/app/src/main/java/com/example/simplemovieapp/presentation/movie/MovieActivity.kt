package com.example.simplemovieapp.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

}