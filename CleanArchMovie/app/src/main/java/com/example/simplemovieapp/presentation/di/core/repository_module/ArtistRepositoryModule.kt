/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.repository_module

import com.example.simplemovieapp.data.api.MainAPIService
import com.example.simplemovieapp.data.repository.artist.ArtistsRepository
import com.example.simplemovieapp.data.repository.artist.ArtistsRepositoryImpl
import com.example.simplemovieapp.data.repository.artist.abstracts.ArtistsApiSource
import com.example.simplemovieapp.data.repository.artist.abstracts.ArtistsCacheSource
import com.example.simplemovieapp.data.repository.artist.abstracts.ArtistsLocalSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ArtistRepositoryModule {

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistsApiSource: ArtistsApiSource,
        artistsLocalSource: ArtistsLocalSource,
        artistsCacheSource: ArtistsCacheSource
    )  : ArtistsRepository {
        return ArtistsRepositoryImpl(artistsApiSource, artistsLocalSource, artistsCacheSource)
    }

}