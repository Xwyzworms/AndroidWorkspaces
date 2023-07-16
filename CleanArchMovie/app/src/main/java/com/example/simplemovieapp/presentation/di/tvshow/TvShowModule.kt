/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.tvshow

import com.example.simplemovieapp.data.domain.tvshow.GetTvShowUseCase
import com.example.simplemovieapp.data.domain.tvshow.UpdateTvShowUseCase
import com.example.simplemovieapp.presentation.tv.viewmodel.TvViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ) : TvViewModelFactory
    {
        return TvViewModelFactory(getTvShowUseCase, updateTvShowUseCase)
    }
}