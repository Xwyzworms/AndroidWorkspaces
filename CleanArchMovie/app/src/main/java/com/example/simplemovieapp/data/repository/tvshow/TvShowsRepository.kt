/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.tvshow

import com.example.simplemovieapp.data.models.tvshow.TvShow

interface TvShowsRepository {
    suspend fun getTvShows(): List<TvShow>

    suspend fun updateTvShows(): Unit
}