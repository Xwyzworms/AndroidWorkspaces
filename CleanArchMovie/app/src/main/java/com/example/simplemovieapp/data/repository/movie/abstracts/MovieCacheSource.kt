/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.movie.abstracts

import com.example.simplemovieapp.data.models.movie.Movie

interface MovieCacheSource {

    suspend fun getMoviesFromCache () : List<Movie>
    suspend fun updateMoviesCache(movies : List<Movie>)
}