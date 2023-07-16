/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.api

import com.example.simplemovieapp.data.models.artist.Artists
import com.example.simplemovieapp.data.models.movie.Movies
import com.example.simplemovieapp.data.models.tvshow.TvShows
import retrofit2.Response
import retrofit2.http.GET

interface MainAPIService {

    @GET("movie/popular")
    suspend fun getMoviesFromApi () : Response<Movies>

    @GET("tv/popular")
    suspend fun getTvShowsFromApi () : Response<TvShows>

    @GET("person/popular")
    suspend fun getArtistsFromApi () : Response<Artists>
}