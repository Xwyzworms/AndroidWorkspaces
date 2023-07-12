/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.domain.artist

import com.example.simplemovieapp.data.models.artist.Artist
import com.example.simplemovieapp.data.repository.artist.ArtistsRepository

class GetArtistsUseCase(private val artistsRepository: ArtistsRepository){
    suspend fun execute() : List<Artist> {
        return artistsRepository.getArtists()
    }
}