/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.artist.abstracts

import com.example.simplemovieapp.data.models.artist.Artists
import retrofit2.Response

interface ArtistsApiSource {
    suspend fun getArtistsFromApi() : Response<Artists>
}