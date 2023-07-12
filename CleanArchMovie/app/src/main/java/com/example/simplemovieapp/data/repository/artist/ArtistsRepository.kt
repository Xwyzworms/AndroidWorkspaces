/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.artist

import com.example.simplemovieapp.data.models.artist.Artist

interface ArtistsRepository {
    suspend fun getArtists() : List<Artist>
    suspend fun updateArtists()
}