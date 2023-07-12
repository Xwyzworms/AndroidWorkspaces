/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.artist.implementations

import com.example.simplemovieapp.data.api.MainAPIService
import com.example.simplemovieapp.data.models.artist.Artist
import com.example.simplemovieapp.data.models.artist.Artists
import com.example.simplemovieapp.data.repository.artist.abstracts.ArtistsApiSource
import retrofit2.Response

class ArtistsApiSourceImpl(private val mainAPIService: MainAPIService) : ArtistsApiSource{
    override suspend fun getArtistsFromApi(): Response<Artists> {
        return mainAPIService.getArtistsFromApi()
    }

}