/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.remote_module

import com.example.simplemovieapp.data.api.MainAPIService
import com.example.simplemovieapp.data.repository.artist.abstracts.ArtistsApiSource
import com.example.simplemovieapp.data.repository.artist.implementations.ArtistsApiSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArtistRemoteModule {

    @Singleton
    @Provides
    fun provideArtistRemoteSource(mainAPIService: MainAPIService) : ArtistsApiSource {
        return ArtistsApiSourceImpl(mainAPIService);
    }
}