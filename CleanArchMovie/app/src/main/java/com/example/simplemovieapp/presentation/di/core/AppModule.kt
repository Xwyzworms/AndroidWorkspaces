/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core

import android.content.Context
import com.example.simplemovieapp.presentation.di.artist.ArtistModule
import com.example.simplemovieapp.presentation.di.artist.ArtistSubComponent
import com.example.simplemovieapp.presentation.di.movie.MovieModule
import com.example.simplemovieapp.presentation.di.movie.MovieSubComponent
import com.example.simplemovieapp.presentation.di.tvshow.TvShowModule
import com.example.simplemovieapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, ArtistSubComponent::class, TvShowSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext() : Context{
        return context.applicationContext
    }
}