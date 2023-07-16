/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation

import android.app.Application
import com.example.simplemovieapp.presentation.di.Injector
import com.example.simplemovieapp.presentation.di.artist.ArtistSubComponent
import com.example.simplemovieapp.presentation.di.core.AppComponent
import com.example.simplemovieapp.presentation.di.core.AppModule
import com.example.simplemovieapp.presentation.di.core.DaggerAppComponent
import com.example.simplemovieapp.presentation.di.movie.MovieSubComponent
import com.example.simplemovieapp.presentation.di.tvshow.TvShowSubComponent

class DAGGER2Babyy : Application(), Injector {

    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(applicationContext))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}