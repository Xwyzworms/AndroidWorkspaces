/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.remote_module

import com.example.simplemovieapp.data.api.MainAPIService
import com.example.simplemovieapp.data.repository.tvshow.abstracts.TvShowApiSource
import com.example.simplemovieapp.data.repository.tvshow.implementations.TvShowApiSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TvShowRemoteModule {

    @Singleton
    @Provides
    fun provideTvShowRemoteSource(mainAPIService: MainAPIService)  : TvShowApiSource
    {
        return TvShowApiSourceImpl(mainAPIService);
    }
}