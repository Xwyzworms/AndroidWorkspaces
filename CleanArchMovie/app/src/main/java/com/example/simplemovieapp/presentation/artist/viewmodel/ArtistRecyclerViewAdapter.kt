/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.artist.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemovieapp.data.models.artist.Artist
import com.example.simplemovieapp.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class ArtistRecyclerViewAdapter(private val artists : List<Artist> ) : RecyclerView.Adapter<ArtistRecyclerViewAdapter.ArtistViewHolder>() {

    inner class ArtistViewHolder(private val view : ListItemBinding) : RecyclerView.ViewHolder(view.root)
    {
        fun bind(artist: Artist)
        {
            view.titleTextView.text = artist.name
            view.descriptionTextView.text = artist.overview
            Picasso.get().load("https://image.tmdb.org/t/p/original"+artist.posterPath).into(view.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val viewHolderArtist : ListItemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtistViewHolder(viewHolderArtist)
    }

    override fun getItemCount(): Int {
        return artists.size
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artists[position])
    }


}