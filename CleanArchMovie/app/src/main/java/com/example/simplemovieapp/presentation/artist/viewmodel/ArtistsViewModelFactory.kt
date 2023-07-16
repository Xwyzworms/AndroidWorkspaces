/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.artist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simplemovieapp.data.domain.artist.GetArtistsUseCase
import com.example.simplemovieapp.data.domain.artist.UpdateArtistsUseCase

class ArtistsViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase,
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistsViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}