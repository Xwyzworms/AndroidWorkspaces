/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.composeroom.viewmodels

import com.example.composeroom.data.BookEntity
import com.example.composeroom.database.BookDAO
import kotlinx.coroutines.flow.Flow

class MainBookRepository(private val bookDao : BookDAO) {

    suspend fun insertBook(bookEntity: BookEntity)
    {
        bookDao.insertBook(bookEntity)
    }

    fun getBooks() : Flow<List<BookEntity>>
    {
        return bookDao.getBooks()
    }

    suspend fun deleteBook(bookEntity: BookEntity)
    {
        bookDao.deleteBook(bookEntity)
    }

}