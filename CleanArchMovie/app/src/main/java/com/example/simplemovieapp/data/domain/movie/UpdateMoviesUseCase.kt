/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.domain.movie

import com.example.simplemovieapp.data.models.movie.Movie
import com.example.simplemovieapp.data.repository.movie.MoviesRepository

class UpdateMoviesUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun execute()
    {
        moviesRepository.updateMovies()
    }
}