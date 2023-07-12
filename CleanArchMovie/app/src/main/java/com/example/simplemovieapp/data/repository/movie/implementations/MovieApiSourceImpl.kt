/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.movie.implementations

import com.example.simplemovieapp.data.api.MainAPIService
import com.example.simplemovieapp.data.models.movie.Movie
import com.example.simplemovieapp.data.models.movie.Movies
import com.example.simplemovieapp.data.repository.movie.MoviesRepository
import com.example.simplemovieapp.data.repository.movie.abstracts.MovieApiSource
import retrofit2.Response

class MovieApiSourceImpl(private val mainAPIService: MainAPIService) : MovieApiSource {

    override suspend fun getMoviesFromApi(): Response<Movies> {
        return mainAPIService.getMoviesFromApi()
    }
}