/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.cache_module

import com.example.simplemovieapp.data.repository.tvshow.abstracts.TvShowCacheSource
import com.example.simplemovieapp.data.repository.tvshow.implementations.TvShowCacheSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TvShowCacheModule {

    @Singleton
    @Provides
    fun provideTvShowCache() : TvShowCacheSource {
        return TvShowCacheSourceImpl()
    }
}