/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.movie.implementations

import com.example.simplemovieapp.data.db.MoviesDAO
import com.example.simplemovieapp.data.models.movie.Movie
import com.example.simplemovieapp.data.repository.movie.abstracts.MovieLocalSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalSourceImpl(private val moviesDAO: MoviesDAO) : MovieLocalSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return moviesDAO.getMovies()
    }

    override suspend fun updateMoviesDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch{
            moviesDAO.saveMovies(movies);
        }
    }

    override suspend fun clearDB()
    {
        moviesDAO.deleteAll()
    }
}