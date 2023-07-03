/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.composeretrofit.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    init {
        RetrofitHelper.provideApi()
    }

    fun getHarryPotterService() : HarryPotterService
    {
        return RetrofitHelper.retrofitInstance as HarryPotterService
    }



    object RetrofitHelper {

        @Volatile
        var retrofitInstance : HarryPotterService? = null

        private fun provideHttpInterceptor(): OkHttpClient {
            val httpInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            return OkHttpClient.Builder().addInterceptor(httpInterceptor).build()
        }
        fun provideApi()  : HarryPotterService
        {
            if(retrofitInstance == null)
            {
                retrofitInstance = Retrofit
                .Builder()
                .baseUrl("https://hp-api.onrender.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                    .client(provideHttpInterceptor())
                .build()
                    .create(HarryPotterService::class.java)
            }

            return retrofitInstance as HarryPotterService
        }

    }

}