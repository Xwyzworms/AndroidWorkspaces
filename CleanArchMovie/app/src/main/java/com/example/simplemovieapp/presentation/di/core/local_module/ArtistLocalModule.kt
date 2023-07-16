/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.local_module

import androidx.room.Dao
import com.example.simplemovieapp.data.db.ArtistsDAO
import com.example.simplemovieapp.data.repository.artist.abstracts.ArtistsLocalSource
import com.example.simplemovieapp.data.repository.artist.implementations.ArtistsLocalSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArtistLocalModule {

    @Singleton
    @Provides
    fun provideArtistLocalSource(artistsDao: ArtistsDAO) : ArtistsLocalSource {
        return ArtistsLocalSourceImpl(artistsDao)
    }
}