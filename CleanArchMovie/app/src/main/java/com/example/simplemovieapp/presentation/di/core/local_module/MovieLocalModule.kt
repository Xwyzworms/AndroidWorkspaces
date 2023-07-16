/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.local_module

import com.example.simplemovieapp.data.db.MoviesDAO
import com.example.simplemovieapp.data.repository.movie.abstracts.MovieLocalSource
import com.example.simplemovieapp.data.repository.movie.implementations.MovieLocalSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieLocalModule {

    @Singleton
    @Provides
    fun provideLocalMovieSource(moviesDAO : MoviesDAO) : MovieLocalSource {
        return MovieLocalSourceImpl(moviesDAO)
    }
}