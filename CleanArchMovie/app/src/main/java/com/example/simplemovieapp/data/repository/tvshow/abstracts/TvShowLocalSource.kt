/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.tvshow.abstracts

import com.example.simplemovieapp.data.models.tvshow.TvShow

interface TvShowLocalSource {
    suspend fun getTvShowsFromDB() : List<TvShow>

    suspend fun saveTvShowsToDB(tvShows : List<TvShow>)

    suspend fun clearAll()
}