/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.repository_module

import com.example.simplemovieapp.data.repository.tvshow.TvShowsRepository
import com.example.simplemovieapp.data.repository.tvshow.TvShowsRepositoryImpl
import com.example.simplemovieapp.data.repository.tvshow.abstracts.TvShowApiSource
import com.example.simplemovieapp.data.repository.tvshow.abstracts.TvShowCacheSource
import com.example.simplemovieapp.data.repository.tvshow.abstracts.TvShowLocalSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TvShowRepositoryModule {

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowApiSource: TvShowApiSource,
        tvShowLocalSource: TvShowLocalSource,
        tvShowCacheSource: TvShowCacheSource

    ) : TvShowsRepository {
        return TvShowsRepositoryImpl(tvShowApiSource, tvShowLocalSource,tvShowCacheSource);
    }
}