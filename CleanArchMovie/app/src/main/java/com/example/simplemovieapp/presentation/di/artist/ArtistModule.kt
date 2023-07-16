/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.artist

import com.example.simplemovieapp.data.domain.artist.GetArtistsUseCase
import com.example.simplemovieapp.data.domain.artist.UpdateArtistsUseCase
import com.example.simplemovieapp.presentation.artist.viewmodel.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ) : ArtistsViewModelFactory {
        return ArtistsViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}