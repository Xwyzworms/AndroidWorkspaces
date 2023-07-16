/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.database_module

import com.example.simplemovieapp.data.db.ArtistsDAO
import com.example.simplemovieapp.data.db.MainDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArtistDatabaseModule {

    @Singleton
    @Provides
    fun provideArtistDao(mainDatabase: MainDatabase) : ArtistsDAO
    {
        return mainDatabase.artistsDAO()
    }
}