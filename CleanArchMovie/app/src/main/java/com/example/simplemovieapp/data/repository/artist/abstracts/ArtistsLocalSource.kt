/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.artist.abstracts

import com.example.simplemovieapp.data.models.artist.Artist

interface ArtistsLocalSource {
    suspend fun getArtistsFromDB() : List<Artist>
    suspend fun updateArtistsDB(artists : List<Artist>)
    suspend fun clearAll()
}