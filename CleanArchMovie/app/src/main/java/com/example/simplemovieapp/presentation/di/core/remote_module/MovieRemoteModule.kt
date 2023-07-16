/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.remote_module

import com.example.simplemovieapp.data.api.MainAPIService
import com.example.simplemovieapp.data.repository.movie.abstracts.MovieApiSource
import com.example.simplemovieapp.data.repository.movie.implementations.MovieApiSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieRemoteModule {

    @Singleton
    @Provides
    fun provideRemoteMovieSource(mainAPIService: MainAPIService) : MovieApiSource
    {
        return MovieApiSourceImpl(mainAPIService)
    }
}