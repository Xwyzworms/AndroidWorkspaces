/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.repository_module

import com.example.simplemovieapp.data.repository.movie.MoviesRepository
import com.example.simplemovieapp.data.repository.movie.MoviesRepositoryImpl
import com.example.simplemovieapp.data.repository.movie.abstracts.MovieApiSource
import com.example.simplemovieapp.data.repository.movie.abstracts.MovieCacheSource
import com.example.simplemovieapp.data.repository.movie.abstracts.MovieLocalSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieRepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieApiSource: MovieApiSource,
        movieLocalSource: MovieLocalSource,
        movieCacheSource: MovieCacheSource
    )  : MoviesRepository
    {
        return MoviesRepositoryImpl(movieApiSource, movieLocalSource, movieCacheSource)
    }
}