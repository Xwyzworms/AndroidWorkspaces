/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.movie

import com.example.simplemovieapp.data.domain.movie.GetMoviesUseCase
import com.example.simplemovieapp.data.domain.movie.UpdateMoviesUseCase
import com.example.simplemovieapp.presentation.movie.viewmodel.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ) : MovieViewModelFactory
    {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }

}