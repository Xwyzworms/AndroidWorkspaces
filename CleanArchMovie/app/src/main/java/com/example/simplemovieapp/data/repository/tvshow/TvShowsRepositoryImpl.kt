/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.tvshow

import android.util.Log
import com.example.simplemovieapp.data.models.tvshow.TvShow
import com.example.simplemovieapp.data.models.tvshow.TvShows
import com.example.simplemovieapp.data.repository.tvshow.abstracts.TvShowApiSource
import com.example.simplemovieapp.data.repository.tvshow.abstracts.TvShowCacheSource
import com.example.simplemovieapp.data.repository.tvshow.abstracts.TvShowLocalSource
import retrofit2.Response

class TvShowsRepositoryImpl(

        private val tvShowApiSource: TvShowApiSource,
        private val tvShowLocalSource : TvShowLocalSource,
        private val  tvShowCacheSource : TvShowCacheSource
                            ) : TvShowsRepository {
    override suspend fun getTvShows(): List<TvShow> {

            return getTvShowsFromCache()
    }

    override suspend fun updateTvShows() {
        val newTvShows : List<TvShow> = getTvShowsFromAPI()
        tvShowLocalSource.clearAll()
        tvShowLocalSource.saveTvShowsToDB(newTvShows)
        tvShowCacheSource.updateTvShowToCache(newTvShows)
    }


    private suspend fun getTvShowsFromDB() : List<TvShow>
    {
        lateinit var dbTvShows : List<TvShow>

        try {
            dbTvShows = tvShowLocalSource.getTvShowsFromDB()
        }
         catch (e : Exception) {
            Log.d(this::class.simpleName, "Failed to getting Tv shows From Database")
         }

        if(dbTvShows.isNotEmpty())
        {
            return dbTvShows
        }
        else
        {
            dbTvShows = getTvShowsFromAPI()
            tvShowLocalSource.saveTvShowsToDB(dbTvShows)
        }
        return dbTvShows
    }

    private suspend fun getTvShowsFromCache() : List<TvShow> {
        lateinit var newCacheTvShows :  List<TvShow>
        try {
            newCacheTvShows = tvShowCacheSource.getTvShowFromCache()
        }
        catch(e : Exception)
        {
            Log.d(this::class.simpleName, "Error Getting TvShows From Cache")
        }

        if(newCacheTvShows.isNotEmpty()) {
            return newCacheTvShows
        }
        else
        {
            newCacheTvShows = getTvShowsFromDB()
            tvShowCacheSource.updateTvShowToCache(newCacheTvShows)
        }
        return  newCacheTvShows
    }

    private suspend  fun getTvShowsFromAPI() :  List<TvShow> {

        var newTvShows  :  List<TvShow> = ArrayList()

        try {
            val newTvShowsResponse : Response<TvShows> = tvShowApiSource.getTvShowFromAPI()
            val newTvShowsBody : TvShows? = newTvShowsResponse.body()
            if(newTvShowsBody != null)
            {
                newTvShows = newTvShowsBody.tvShows
            }
        }
        catch (e : Exception  )
        {
            Log.d(this::class.simpleName, "Failed to get TvShows API Bro")
        }

        return newTvShows
    }
}