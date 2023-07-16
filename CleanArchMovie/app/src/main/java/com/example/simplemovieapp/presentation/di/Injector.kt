/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di

import com.example.simplemovieapp.presentation.di.artist.ArtistSubComponent
import com.example.simplemovieapp.presentation.di.movie.MovieScope
import com.example.simplemovieapp.presentation.di.movie.MovieSubComponent
import com.example.simplemovieapp.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent() : MovieSubComponent;
    fun createTvShowSubComponent() : TvShowSubComponent;
    fun createArtistSubComponent() : ArtistSubComponent
}