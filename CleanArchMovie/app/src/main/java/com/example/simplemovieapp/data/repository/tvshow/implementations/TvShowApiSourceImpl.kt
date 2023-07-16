/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.tvshow.implementations

import com.example.simplemovieapp.data.api.MainAPIService
import com.example.simplemovieapp.data.models.tvshow.TvShows
import com.example.simplemovieapp.data.repository.tvshow.TvShowsRepository
import com.example.simplemovieapp.data.repository.tvshow.abstracts.TvShowApiSource
import retrofit2.Response

class TvShowApiSourceImpl(private val mainAPIService: MainAPIService) : TvShowApiSource {
    override suspend fun getTvShowFromAPI(): Response<TvShows> {
        return mainAPIService.getTvShowsFromApi()
    }
}