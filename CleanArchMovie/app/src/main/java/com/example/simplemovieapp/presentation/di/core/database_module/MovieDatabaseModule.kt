/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.database_module

import com.example.simplemovieapp.data.db.MainDatabase
import com.example.simplemovieapp.data.db.MoviesDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieDatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDAO(mainDatabase: MainDatabase) : MoviesDAO
    {
        return mainDatabase.moviesDAO()
    }

}