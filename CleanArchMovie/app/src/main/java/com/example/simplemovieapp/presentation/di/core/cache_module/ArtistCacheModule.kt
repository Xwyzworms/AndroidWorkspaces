/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.cache_module

import com.example.simplemovieapp.data.repository.artist.abstracts.ArtistsCacheSource
import com.example.simplemovieapp.data.repository.artist.implementations.ArtistsCacheSourceImpl
import dagger.Module

@Module
class ArtistCacheModule {

    fun provideArtistCache () : ArtistsCacheSource
    {
        return ArtistsCacheSourceImpl();
    }
}