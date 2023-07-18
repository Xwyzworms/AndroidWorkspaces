package com.example.simplemovieapp.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplemovieapp.R
import com.example.simplemovieapp.databinding.ActivityTvBinding
import com.example.simplemovieapp.presentation.di.Injector
import com.example.simplemovieapp.presentation.movie.viewmodel.MovieRecyclerViewAdapter
import com.example.simplemovieapp.presentation.tv.viewmodel.TvShowRecyclerViewAdapter
import com.example.simplemovieapp.presentation.tv.viewmodel.TvViewModel
import com.example.simplemovieapp.presentation.tv.viewmodel.TvViewModelFactory
import javax.inject.Inject

class TvActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTvBinding
    @Inject
    lateinit var viewModelFactory: TvViewModelFactory
    private lateinit var viewModel : TvViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv);
        setSupportActionBar(binding.myToolbar)
        (application as Injector).createTvShowSubComponent().inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(TvViewModel::class.java)
        setupRecyclerView()
    }

    private fun setupRecyclerView()
    {
        binding.TvrecyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.getTvShow().observe(this, ){tvShows->
            binding.TvrecyclerView.adapter = TvShowRecyclerViewAdapter(tvShows)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val layoutInflater : MenuInflater = menuInflater
        layoutInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        lateinit var adapter: TvShowRecyclerViewAdapter
        return when(item.itemId) {
            R.id.update_data -> {
                viewModel.updateTvShowUseCase().observe(this) {tvShows->
                    adapter = TvShowRecyclerViewAdapter(tvShows)
                    binding.TvrecyclerView.adapter = adapter
                }
                true
            }
            else->
                return super.onOptionsItemSelected(item)
        }
    }

}