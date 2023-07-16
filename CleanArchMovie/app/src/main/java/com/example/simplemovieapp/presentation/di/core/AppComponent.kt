/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core

import com.example.simplemovieapp.presentation.di.artist.ArtistSubComponent
import com.example.simplemovieapp.presentation.di.core.cache_module.ArtistCacheModule
import com.example.simplemovieapp.presentation.di.core.cache_module.MovieCacheModule
import com.example.simplemovieapp.presentation.di.core.cache_module.TvShowCacheModule
import com.example.simplemovieapp.presentation.di.core.AppModule
import com.example.simplemovieapp.presentation.di.core.NetModule
import com.example.simplemovieapp.presentation.di.core.database_module.ArtistDatabaseModule
import com.example.simplemovieapp.presentation.di.core.database_module.DatabaseModule
import com.example.simplemovieapp.presentation.di.core.database_module.MovieDatabaseModule
import com.example.simplemovieapp.presentation.di.core.database_module.TvShowDatabaseModule
import com.example.simplemovieapp.presentation.di.core.local_module.ArtistLocalModule
import com.example.simplemovieapp.presentation.di.core.local_module.MovieLocalModule
import com.example.simplemovieapp.presentation.di.core.local_module.TvShowLocalModule
import com.example.simplemovieapp.presentation.di.core.remote_module.ArtistRemoteModule
import com.example.simplemovieapp.presentation.di.core.remote_module.MovieRemoteModule
import com.example.simplemovieapp.presentation.di.core.remote_module.TvShowRemoteModule
import com.example.simplemovieapp.presentation.di.core.repository_module.ArtistRepositoryModule
import com.example.simplemovieapp.presentation.di.core.repository_module.MovieRepositoryModule
import com.example.simplemovieapp.presentation.di.core.repository_module.TvShowRepositoryModule
import com.example.simplemovieapp.presentation.di.core.usecase_module.ArtistUseCasesModule
import com.example.simplemovieapp.presentation.di.core.usecase_module.MovieUseCasesModule
import com.example.simplemovieapp.presentation.di.core.usecase_module.TvShowUsesCasesModule
import com.example.simplemovieapp.presentation.di.movie.MovieSubComponent
import com.example.simplemovieapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,

    ArtistUseCasesModule::class,
    MovieUseCasesModule::class,
    TvShowUsesCasesModule::class,

    ArtistRepositoryModule::class,
    MovieRepositoryModule::class,
    TvShowRepositoryModule::class,

    ArtistRemoteModule::class,
    MovieRemoteModule::class,
    TvShowRemoteModule::class,

    ArtistLocalModule::class,
    MovieLocalModule::class,
    TvShowLocalModule::class,

    ArtistDatabaseModule::class,
    MovieDatabaseModule::class,
    TvShowDatabaseModule::class,
    DatabaseModule::class,

    ArtistCacheModule::class,
    MovieCacheModule::class,
    TvShowCacheModule::class,

    NetModule::class

])
interface AppComponent {
    fun movieSubComponent() : MovieSubComponent.Factory
    fun tvShowSubComponent() : TvShowSubComponent.Factory
    fun artistSubComponent() : ArtistSubComponent.Factory

}