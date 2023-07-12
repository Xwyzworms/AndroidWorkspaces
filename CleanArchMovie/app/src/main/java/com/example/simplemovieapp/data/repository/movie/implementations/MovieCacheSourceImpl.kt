/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.movie.implementations

import com.example.simplemovieapp.data.models.movie.Movie
import com.example.simplemovieapp.data.repository.movie.abstracts.MovieCacheSource
import kotlin.collections.ArrayList

class MovieCacheSourceImpl() : MovieCacheSource{
    private var movies : ArrayList<Movie> = ArrayList()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movies
    }

    override suspend fun updateMoviesCache(movies: List<Movie>) {
        this.movies.clear()
        this.movies = ArrayList(movies)
    }

}