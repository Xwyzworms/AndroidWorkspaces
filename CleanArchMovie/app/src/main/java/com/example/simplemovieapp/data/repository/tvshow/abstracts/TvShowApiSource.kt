/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.tvshow.abstracts

import com.example.simplemovieapp.data.models.tvshow.TvShows
import retrofit2.Response

interface TvShowApiSource {
    suspend fun getTvShowFromAPI() : Response<TvShows>
}