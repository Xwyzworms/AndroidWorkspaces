/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simplemovieapp.data.models.artist.Artist
import com.example.simplemovieapp.data.models.movie.Movie
import com.example.simplemovieapp.data.models.tvshow.TvShow

@Database(entities = [Artist::class, Movie::class, TvShow::class], version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase()
{
    abstract fun artistsDAO() : ArtistsDAO
    abstract fun moviesDAO() : MoviesDAO
    abstract fun tvShowsDAO() : TvShowsDAO
}