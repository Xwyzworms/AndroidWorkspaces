/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simplemovieapp.data.models.artist.Artist

@Dao
interface ArtistsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists : List<Artist>)

    @Query("SELECT * FROM artist_table")
    suspend fun getArtists() : List<Artist>

    @Query("DELETE FROM artist_table")
    suspend fun deleteAll()

}