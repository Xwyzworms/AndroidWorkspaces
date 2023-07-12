/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.repository.movie.abstracts

import android.provider.MediaStore.Audio.Artists
import com.example.simplemovieapp.data.models.movie.Movies
import com.example.simplemovieapp.data.models.tvshow.TvShows
import retrofit2.Response

interface MovieApiSource {
    suspend fun getMoviesFromApi () : Response<Movies>
}