/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.artist.implementations

import com.example.simplemovieapp.data.db.ArtistsDAO
import com.example.simplemovieapp.data.models.artist.Artist
import com.example.simplemovieapp.data.repository.artist.abstracts.ArtistsLocalSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistsLocalSourceImpl(private val artistsDAO: ArtistsDAO) : ArtistsLocalSource{
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistsDAO.getArtists()
    }

    override suspend fun updateArtistsDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistsDAO.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        artistsDAO.deleteAll()
    }
}