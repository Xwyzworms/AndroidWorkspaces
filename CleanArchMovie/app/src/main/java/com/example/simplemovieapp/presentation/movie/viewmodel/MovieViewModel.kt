/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.simplemovieapp.data.domain.movie.GetMoviesUseCase
import com.example.simplemovieapp.data.domain.movie.UpdateMoviesUseCase
import com.example.simplemovieapp.data.models.movie.Movie

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel()
{
    fun getMovies() : LiveData<List<Movie>> = liveData {
         emit(getMoviesUseCase.execute())
    }

    fun updateMovies() : LiveData<List<Movie>> = liveData {
        updateMoviesUseCase.execute()
        emit(getMoviesUseCase.execute())
    }
}