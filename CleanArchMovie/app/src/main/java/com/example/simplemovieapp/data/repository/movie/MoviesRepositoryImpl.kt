/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.movie

import android.util.Log
import com.example.simplemovieapp.data.models.movie.Movie
import com.example.simplemovieapp.data.models.movie.Movies
import com.example.simplemovieapp.data.repository.movie.abstracts.MovieApiSource
import com.example.simplemovieapp.data.repository.movie.abstracts.MovieCacheSource
import com.example.simplemovieapp.data.repository.movie.abstracts.MovieLocalSource
import retrofit2.Response
import kotlin.Exception

class MoviesRepositoryImpl(
    private val movieLocalSource: MovieLocalSource,
    private val movieApiSource: MovieApiSource,
    private val movieCacheSource: MovieCacheSource

) : MoviesRepository{
    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies() {
        val newMovies : List<Movie> = getMoviesFromAPI()
        movieLocalSource.updateMoviesDB(newMovies)
        movieCacheSource.updateMoviesCache(newMovies)
    }
    private suspend fun getMoviesFromAPI() : List<Movie>
    {
        lateinit var movies : List<Movie>
        try {
            val movieResponse : Response<Movies> = movieApiSource.getMoviesFromApi()
            val moviesAPI : Movies? = movieResponse.body()

            if(moviesAPI != null)
            {
                movies = moviesAPI.movies
            }
            else
            {
                Log.d(this::class.simpleName, "Error getting movies API")
            }
        }catch ( e : Exception)
        {
            Log.d(this::class.simpleName, "Error ${e.message.toString()}")
        }
        return movies
    }

    private suspend fun getMoviesFromDB() : List<Movie>
    {
        lateinit var dbMovies : List<Movie>
        try {
            dbMovies = movieLocalSource.getMoviesFromDB()
        }
        catch (e : Exception) {
            Log.d(this::class.simpleName, "E : ${e.message.toString()}")
        }

        if(dbMovies.isNotEmpty())
        {
            return dbMovies
        }
        else {
            dbMovies = getMoviesFromAPI()
            movieLocalSource.updateMoviesDB(dbMovies)
        }
        return dbMovies
    }

    private suspend fun getMoviesFromCache() : List<Movie>
    {
        lateinit var currentMovies : List<Movie>
        try {
            currentMovies = movieCacheSource.getMoviesFromCache()
        }
        catch (e : Exception)
        {
            Log.d(this::class.simpleName, "E : ${e.message.toString()}")
        }

        if(currentMovies.isNotEmpty())
        {
            return currentMovies
        }
        else {
            currentMovies = getMoviesFromDB()
            movieCacheSource.updateMoviesCache(currentMovies)
        }

        return currentMovies
    }



}