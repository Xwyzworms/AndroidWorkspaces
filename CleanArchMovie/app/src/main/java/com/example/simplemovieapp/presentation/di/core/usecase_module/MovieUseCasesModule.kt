/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.usecase_module

import com.example.simplemovieapp.data.domain.movie.GetMoviesUseCase
import com.example.simplemovieapp.data.domain.movie.UpdateMoviesUseCase
import com.example.simplemovieapp.data.repository.movie.MoviesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieUseCasesModule {

    @Singleton
    @Provides
    fun provideGetMoviesUsecase(moviesRepository : MoviesRepository) : GetMoviesUseCase {
        return GetMoviesUseCase(moviesRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMoviesUseCase(moviesRepository: MoviesRepository) : UpdateMoviesUseCase {
        return UpdateMoviesUseCase(moviesRepository)
    }
}