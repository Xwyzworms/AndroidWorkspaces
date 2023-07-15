/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.domain.tvshow

import com.example.simplemovieapp.data.models.tvshow.TvShow
import com.example.simplemovieapp.data.repository.tvshow.TvShowsRepository

class GetTvShowUseCase(private val tvShowsRepository: TvShowsRepository) {

    suspend fun execute() : List<TvShow> {
        return tvShowsRepository.getTvShows()
    }
}