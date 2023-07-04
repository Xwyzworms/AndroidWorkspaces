/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.composeroom.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeroom.data.BookEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainBookViewModel(private val mainBookRepository: MainBookRepository) : ViewModel(){

    fun insertBook(bookEntity: BookEntity)
    {
        viewModelScope.launch {
            mainBookRepository.insertBook(bookEntity)
        }
    }

    fun getBooks() : Flow<List<BookEntity>>
    {
        return mainBookRepository.getBooks()
    }

    fun deleteBook(bookEntity: BookEntity)
    {
        viewModelScope.launch {
            mainBookRepository.deleteBook(bookEntity)
        }
    }
}