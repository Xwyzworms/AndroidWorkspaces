/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.artist.abstracts

import com.example.simplemovieapp.data.models.artist.Artist

interface ArtistsCacheSource {
    suspend fun getArtistsFromCache() : List<Artist>
    suspend fun updateArtistsCache(artists : List<Artist>)
}