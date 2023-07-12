/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.movie

import com.example.simplemovieapp.data.models.movie.Movie
import com.example.simplemovieapp.data.models.movie.Movies

interface MoviesRepository {

    suspend fun getMovies() : List<Movie>

    suspend fun updateMovies()
}