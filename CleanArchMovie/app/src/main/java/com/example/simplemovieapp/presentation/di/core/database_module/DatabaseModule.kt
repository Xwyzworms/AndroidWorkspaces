/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.simplemovieapp.presentation.di.core.database_module

import android.content.Context
import androidx.room.Room
import com.example.simplemovieapp.data.db.MainDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMainDatabase(context : Context)  : MainDatabase
    {
        return Room.databaseBuilder(context, MainDatabase::class.java, "main").build()
    }
}