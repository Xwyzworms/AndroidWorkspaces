/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.data.api.retrofit

import com.example.simplemovieapp.data.api.MainAPIService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBro {

    @Volatile
    private var instance : MainAPIService? = null
    private var retrofitInstance : Retrofit? = null
    init {
        instance = RetrofitHelper.getInstance( RetrofitHelper.getRetrofitInstance())
    }
    class RetrofitHelper private constructor()
    {
        companion object {
            private var BASEURL : String = "https://api.themoviedb.org/3/"
            fun getRetrofitInstance() : Retrofit {
                return retrofitInstance?: provideRetrofit()
            }
            fun getInstance(retrofit: Retrofit): MainAPIService {
                return instance ?: setupRetrofit(retrofit)
            }
            private  fun setupRetrofit(retrofit: Retrofit) : MainAPIService
            {
                return retrofit.create(MainAPIService::class.java)
            }

            private fun provideRetrofit(): Retrofit {

                return Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(provideHttpClient())
                    .build()
            }

            private fun provideHttpCustomHeader(): OkHttpClient.Builder {

                return OkHttpClient.Builder().addInterceptor(
                    Interceptor { chain->
                        val originalRequest : Request = chain.request()
                        val authToken : String = "YOUR API KEY"
                        val newAuthenticatedRequest = originalRequest.newBuilder()
                            .addHeader("Authorization", "Bearer $authToken").build()
                        chain.proceed(newAuthenticatedRequest)
                    })
            }
            private fun provideHttpClient() : OkHttpClient
            {
                val httpInterceptor = HttpLoggingInterceptor()
                httpInterceptor.level = HttpLoggingInterceptor.Level.BODY
                return provideHttpCustomHeader().addInterceptor(httpInterceptor).build()
            }
        }
    }
}