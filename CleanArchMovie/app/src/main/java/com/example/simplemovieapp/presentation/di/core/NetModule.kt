/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core

import com.example.simplemovieapp.data.api.MainAPIService
import com.example.simplemovieapp.data.api.retrofit.RetrofitBro
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return RetrofitBro.RetrofitHelper.getRetrofitInstance()
    }

    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit) : MainAPIService {
        return RetrofitBro.RetrofitHelper.getInstance(retrofit)
    }
}