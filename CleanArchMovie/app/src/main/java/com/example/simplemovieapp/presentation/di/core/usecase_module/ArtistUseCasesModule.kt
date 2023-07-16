/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.usecase_module

import com.example.simplemovieapp.data.domain.artist.GetArtistsUseCase
import com.example.simplemovieapp.data.domain.artist.UpdateArtistsUseCase
import com.example.simplemovieapp.data.repository.artist.ArtistsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ArtistUseCasesModule {

    @Singleton
    @Provides
    fun provideGetArtistUseCase(artistsRepository: ArtistsRepository) : GetArtistsUseCase {
        return GetArtistsUseCase(artistsRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(artistsRepository: ArtistsRepository) : UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistsRepository)
    }
}