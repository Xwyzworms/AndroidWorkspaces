/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.composeretrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeretrofit.data.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainPotterViewModel(private val mainRepository: MainRepository)  : ViewModel() {

    private val _stateCharacter = MutableStateFlow(emptyList<Character>())

    val state : StateFlow<List<Character>>
        get() = _stateCharacter

    init {
        viewModelScope.launch {
            val characters  : List<Character> = mainRepository.getCharacters()
            _stateCharacter.value = characters
        }
    }

}