/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.artist.implementations

import com.example.simplemovieapp.data.models.artist.Artist
import com.example.simplemovieapp.data.repository.artist.abstracts.ArtistsCacheSource

class ArtistsCacheSourceImpl : ArtistsCacheSource{
    var artists : ArrayList<Artist> = ArrayList()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artists
    }

    override suspend fun updateArtistsCache(artists: List<Artist>) {
        this.artists.clear()
        this.artists = ArrayList(artists)
    }
}