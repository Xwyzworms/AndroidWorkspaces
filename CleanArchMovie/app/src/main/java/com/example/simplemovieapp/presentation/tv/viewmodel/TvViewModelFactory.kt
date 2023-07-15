/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.tv.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.simplemovieapp.data.domain.tvshow.GetTvShowUseCase
import com.example.simplemovieapp.data.domain.tvshow.UpdateTvShowUseCase
import com.example.simplemovieapp.data.models.tvshow.TvShow

class TvViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
                         ) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvViewModel(getTvShowUseCase, updateTvShowUseCase ) as T
    }
}