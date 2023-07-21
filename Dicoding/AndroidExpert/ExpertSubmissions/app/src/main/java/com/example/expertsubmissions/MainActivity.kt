package com.example.expertsubmissions

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.core.data.implementations.MovieRepositoryImpl
import com.example.expertsubmissions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val movieRepositoryImpl = MovieRepositoryImpl()
        binding.btn.setOnClickListener {
            val moveBro = Uri.parse("favorite_scheme://favorite_host")
            startActivity(Intent(Intent.ACTION_VIEW,moveBro))
        }
    }
}