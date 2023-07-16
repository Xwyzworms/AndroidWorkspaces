/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.artist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.simplemovieapp.data.domain.artist.GetArtistsUseCase
import com.example.simplemovieapp.data.domain.artist.UpdateArtistsUseCase
import com.example.simplemovieapp.data.models.artist.Artist
import com.example.simplemovieapp.data.models.tvshow.TvShow

class ArtistsViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) {

    fun getArtists() : LiveData<List<Artist>> = liveData {
        val artists = getArtistsUseCase.execute()
        emit(artists)
    }

    fun updateArtists() : LiveData<List<Artist>> = liveData{
        updateArtistsUseCase.execute()
        val newArtists = getArtistsUseCase.execute()
        emit(newArtists)
    }
}