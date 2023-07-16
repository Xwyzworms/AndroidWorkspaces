package com.example.simplemovieapp.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.simplemovieapp.R
import com.example.simplemovieapp.databinding.ActivityMovieBinding
import com.example.simplemovieapp.presentation.di.Injector
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
        movieViewModel.getMovies().observe(this) {
            Log.d("FUCK", it.toString())
        }
    }
}