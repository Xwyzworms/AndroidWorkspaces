package com.example.simplemovieapp.presentation.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.simplemovieapp.R
import com.example.simplemovieapp.data.models.movie.Movie
import com.example.simplemovieapp.databinding.ActivityMainBinding
import com.example.simplemovieapp.presentation.artist.ArtistsActivity
import com.example.simplemovieapp.presentation.movie.MovieActivity
import com.example.simplemovieapp.presentation.tv.TvActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupOnClickListener()
    }

    private fun setupOnClickListener() {
        binding.btnMovie.setOnClickListener {
            var intent = Intent(this, MovieActivity::class.java);
            startActivity(intent)
        }

        binding.btnTv.setOnClickListener {
            var intent = Intent(this, TvActivity::class.java);
        }

        binding.btnArtists.setOnClickListener {
            var intent = Intent(this, ArtistsActivity::class.java);
        }
    }
}