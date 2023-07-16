/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.tvshow.implementations

import com.example.simplemovieapp.data.models.tvshow.TvShow
import com.example.simplemovieapp.data.repository.tvshow.abstracts.TvShowCacheSource

class TvShowCacheSourceImpl : TvShowCacheSource{
    private var tvShowCache : ArrayList<TvShow>  = ArrayList()

    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowCache
    }

    override suspend fun updateTvShowToCache(tvShows: List<TvShow>) {
        tvShowCache.clear()
        tvShowCache = ArrayList(tvShows)
    }
}