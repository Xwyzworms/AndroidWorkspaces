/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.movie.abstracts

import com.example.simplemovieapp.data.models.movie.Movie

interface MovieLocalSource {

    suspend fun getMoviesFromDB () : List<Movie>
    suspend fun updateMoviesDB(movies : List<Movie>)
    suspend fun clearDB()
}