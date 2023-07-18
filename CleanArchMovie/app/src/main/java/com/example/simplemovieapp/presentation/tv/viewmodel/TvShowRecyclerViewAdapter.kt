/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.tv.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemovieapp.data.models.tvshow.TvShow
import com.example.simplemovieapp.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class TvShowRecyclerViewAdapter(private val tvShows : List<TvShow>) : RecyclerView.Adapter<TvShowRecyclerViewAdapter.TvShowViewHolder>() {

    inner class TvShowViewHolder(private val  view : ListItemBinding) : RecyclerView.ViewHolder(view.root)
    {
        fun bind(tvShow: TvShow )
        {
            view.titleTextView.text = tvShow.name
            view.descriptionTextView.text = tvShow.popularity.toString()
            Picasso.get().load("https://image.tmdb.org/t/p/original/"+tvShow.profilePath).into(view.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val tvShowViewHolder : ListItemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(tvShowViewHolder)
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }


}