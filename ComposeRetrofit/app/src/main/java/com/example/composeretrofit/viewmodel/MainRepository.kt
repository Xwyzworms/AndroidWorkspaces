/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.composeretrofit.viewmodel

import com.example.composeretrofit.data.Character
import com.example.composeretrofit.network.HarryPotterService
import kotlinx.coroutines.flow.Flow

class MainRepository(private val harryPotterService: HarryPotterService) {

    suspend fun getCharacters() : List<Character> {
        return harryPotterService.getCharacters()
    }

}