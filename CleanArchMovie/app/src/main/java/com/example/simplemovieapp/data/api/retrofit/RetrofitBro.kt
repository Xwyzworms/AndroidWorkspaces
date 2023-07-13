/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.api.retrofit

import com.example.simplemovieapp.data.api.MainAPIService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBro {

    @Volatile
    var instance : MainAPIService? = null
    init {
        instance = RetrofitHelper.getInstance()
    }
    class RetrofitHelper private constructor()
    {
        companion object {
            private var BASEURL : String = ""
            fun getInstance(): MainAPIService {
                return instance ?: setupRetrofit()
            }
            private  fun setupRetrofit() : MainAPIService
            {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(provideHttpClient())
                    .build()
                return retrofit.create(MainAPIService::class.java)
            }

            private fun provideHttpClient() : OkHttpClient
            {
                val httpInterceptor = HttpLoggingInterceptor()
                httpInterceptor.level = HttpLoggingInterceptor.Level.BODY
                return OkHttpClient.Builder().addInterceptor(httpInterceptor).build()
            }
        }
    }
}