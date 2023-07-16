/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.cache_module

import com.example.simplemovieapp.data.repository.movie.abstracts.MovieCacheSource
import com.example.simplemovieapp.data.repository.movie.implementations.MovieCacheSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieCacheModule {

    @Singleton
    @Provides
    fun provideMovieCache() : MovieCacheSource  {
        return MovieCacheSourceImpl()
    }
}