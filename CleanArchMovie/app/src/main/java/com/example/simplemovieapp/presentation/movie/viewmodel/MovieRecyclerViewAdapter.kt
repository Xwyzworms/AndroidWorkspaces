/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.movie.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemovieapp.data.models.movie.Movie
import com.example.simplemovieapp.data.models.movie.Movies
import com.example.simplemovieapp.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class MovieRecyclerViewAdapter(private val listMovies : List<Movie>) : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(private val view : ListItemBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(movie : Movie)
        {
            view.titleTextView.text = movie.title
            view.descriptionTextView.text = movie.overview
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+movie.posterPath).into(view.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val viewItems : ListItemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder( viewItems )
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovies[position])
    }
}