/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.artist

import com.example.simplemovieapp.data.domain.artist.GetArtistsUseCase
import com.example.simplemovieapp.data.domain.artist.UpdateArtistsUseCase
import com.example.simplemovieapp.presentation.artist.ArtistsActivity
import com.example.simplemovieapp.presentation.artist.viewmodel.ArtistsViewModelFactory
import com.example.simplemovieapp.presentation.di.tvshow.TvShowSubComponent
import com.example.simplemovieapp.presentation.tv.TvActivity
import dagger.Provides
import dagger.Subcomponent


@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {


    fun inject(artistActivity: ArtistsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create() : ArtistSubComponent
    }
}