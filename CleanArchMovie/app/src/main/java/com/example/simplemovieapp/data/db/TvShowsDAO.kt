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
import com.example.simplemovieapp.data.models.tvshow.TvShow
import com.example.simplemovieapp.data.models.tvshow.TvShows

@Dao
interface TvShowsDAO {

    @Query("SELECT * FROM movie_table")
    suspend fun getTvShows() : List<TvShow>

    @Query("DELETE FROM movie_table")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

}