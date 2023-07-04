/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.composeroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.composeroom.data.BookEntity

@Database(entities = [BookEntity::class], version = 1, exportSchema = false)
abstract  class MainBookDatabase() : RoomDatabase() {

    abstract fun bookDao() : BookDAO

    companion object {

            @Volatile
            var bookDatabaseInstance : MainBookDatabase ? = null

            private fun initializeBookDatabaseInstance(context : Context)
            {
                @Synchronized
                if(bookDatabaseInstance == null)
                {
                    bookDatabaseInstance = Room.databaseBuilder(context, MainBookDatabase::class.java, "MainBookDB").build()
                }
            }

            fun getInstance(context: Context ) : MainBookDatabase
            {
                initializeBookDatabaseInstance(context)
                return bookDatabaseInstance as MainBookDatabase
            }

    }
}