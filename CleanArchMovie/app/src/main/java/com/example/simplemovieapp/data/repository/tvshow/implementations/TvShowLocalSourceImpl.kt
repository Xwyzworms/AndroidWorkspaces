/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.tvshow.implementations

import com.example.simplemovieapp.data.db.TvShowsDAO
import com.example.simplemovieapp.data.models.tvshow.TvShow
import com.example.simplemovieapp.data.repository.tvshow.abstracts.TvShowLocalSource

class TvShowLocalSourceImpl(private val tvShowsDAO: TvShowsDAO) : TvShowLocalSource{
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowsDAO.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        tvShowsDAO.saveTvShows(tvShows)
    }

    override suspend fun clearAll() {
        tvShowsDAO.deleteAll()
    }


}