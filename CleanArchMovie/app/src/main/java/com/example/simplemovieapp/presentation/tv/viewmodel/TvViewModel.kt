/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.tv.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.simplemovieapp.data.domain.tvshow.GetTvShowUseCase
import com.example.simplemovieapp.data.domain.tvshow.UpdateTvShowUseCase
import com.example.simplemovieapp.data.models.tvshow.TvShow

class TvViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModel()
{
    fun getTvShow() : LiveData<List<TvShow>> = liveData {
        emit(getTvShowUseCase.execute())
    }

    fun updateTvShowUseCase() : LiveData<List<TvShow>> = liveData {
        updateTvShowUseCase.execute()
        emit(getTvShowUseCase.execute())
    }
}