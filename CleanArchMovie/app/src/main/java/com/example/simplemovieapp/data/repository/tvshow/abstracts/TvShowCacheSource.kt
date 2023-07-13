/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.tvshow.abstracts

import com.example.simplemovieapp.data.models.movie.Movie
import com.example.simplemovieapp.data.models.tvshow.TvShow

interface TvShowCacheSource {

    suspend fun getTvShowFromCache() : List<TvShow>

    suspend fun updateTvShowToCache(tvShows : List<TvShow>)
}