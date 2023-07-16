/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.local_module

import com.example.simplemovieapp.data.db.TvShowsDAO
import com.example.simplemovieapp.data.repository.tvshow.abstracts.TvShowLocalSource
import com.example.simplemovieapp.data.repository.tvshow.implementations.TvShowLocalSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TvShowLocalModule {

    @Singleton
    @Provides
    fun provideLocalTvShowSource(tvShowsDAO: TvShowsDAO) : TvShowLocalSource
    {
        return TvShowLocalSourceImpl(tvShowsDAO)
    }
}