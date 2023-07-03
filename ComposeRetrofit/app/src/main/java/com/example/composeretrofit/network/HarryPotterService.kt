/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.composeretrofit.network

import com.example.composeretrofit.data.Character
import retrofit2.http.GET

interface HarryPotterService {

    @GET("characters")
    suspend fun getCharacters() : List<Character>
}