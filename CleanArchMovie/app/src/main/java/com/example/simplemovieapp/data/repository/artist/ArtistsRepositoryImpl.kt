/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.artist

import android.util.Log
import com.example.simplemovieapp.data.models.artist.Artist
import com.example.simplemovieapp.data.models.artist.Artists
import com.example.simplemovieapp.data.repository.artist.abstracts.ArtistsApiSource
import com.example.simplemovieapp.data.repository.artist.abstracts.ArtistsCacheSource
import com.example.simplemovieapp.data.repository.artist.abstracts.ArtistsLocalSource
import retrofit2.Response
import java.lang.Exception

class ArtistsRepositoryImpl(
    private val artistsApiSource: ArtistsApiSource,
    private val artistsLocalSource: ArtistsLocalSource,
    private val artistsCacheSource: ArtistsCacheSource
) : ArtistsRepository {
    override suspend fun getArtists(): List<Artist>
    {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists()
    {
        val newArtists : List<Artist> = getArtistsFromApi()
        artistsLocalSource.clearAll()
        artistsLocalSource.updateArtistsDB(newArtists)
        artistsCacheSource.updateArtistsCache(newArtists)
    }

    private suspend fun getArtistsFromApi() : List<Artist>
    {
        var apiArtists : List<Artist> = ArrayList()
        try {
            val apiResponse : Response<Artists> = artistsApiSource.getArtistsFromApi()
            val apiBody = apiResponse.body()
            if(apiBody != null) {
                apiArtists = apiBody.artists
            }
            else {
                Log.d(this::class.simpleName, "Error while getting Artists API ")
            }

        } catch (e : Exception) {

            Log.d(this::class.simpleName, "E : ${e.message.toString()}")
        }

        return apiArtists
    }

    private suspend fun getArtistsFromDB() : List<Artist>
    {
        lateinit var localArtists : List<Artist>
        try {
            localArtists = artistsLocalSource.getArtistsFromDB()
        }catch (e : Exception) {

            Log.d(this::class.simpleName, "E : ${e.message.toString()}")
        }

        if(localArtists.isNotEmpty()) {
            return localArtists
        }
        else {
            localArtists =getArtistsFromApi()
            artistsLocalSource.updateArtistsDB(localArtists)
        }
        return localArtists

    }

    private suspend fun getArtistsFromCache() : List<Artist>
    {
        lateinit var cacheArtists : List<Artist>
        try {
            cacheArtists = artistsCacheSource.getArtistsFromCache()
        }catch (e : Exception) {
            Log.d(this::class.simpleName, "E : ${e.message.toString()}")
        }

        if(cacheArtists.isNotEmpty()) {
            return cacheArtists
        }
        else {
            cacheArtists = getArtistsFromDB()
            artistsCacheSource.updateArtistsCache(cacheArtists)
        }
        return cacheArtists
    }
}