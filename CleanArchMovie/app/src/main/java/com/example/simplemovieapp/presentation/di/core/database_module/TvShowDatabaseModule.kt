/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.database_module

import com.example.simplemovieapp.data.db.MainDatabase
import com.example.simplemovieapp.data.db.TvShowsDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TvShowDatabaseModule {

    @Singleton
    @Provides
    fun provideTvShowDao(mainDatabase: MainDatabase)  : TvShowsDAO
    {
        return mainDatabase.tvShowsDAO()
    }

}