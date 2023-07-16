/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.usecase_module

import com.example.simplemovieapp.data.domain.tvshow.GetTvShowUseCase
import com.example.simplemovieapp.data.domain.tvshow.UpdateTvShowUseCase
import com.example.simplemovieapp.data.repository.tvshow.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TvShowUsesCasesModule {

    @Singleton
    @Provides
    fun provideGetTvShowUseCase(tvShowsRepository: TvShowsRepository) : GetTvShowUseCase{
        return GetTvShowUseCase(tvShowsRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateTvShowUseCase(tvShowsRepository: TvShowsRepository) : UpdateTvShowUseCase {
        return UpdateTvShowUseCase(tvShowsRepository)
    }
}