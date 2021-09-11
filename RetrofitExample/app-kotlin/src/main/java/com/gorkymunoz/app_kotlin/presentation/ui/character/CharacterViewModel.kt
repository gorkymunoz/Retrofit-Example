package com.gorkymunoz.app_kotlin.presentation.ui.character

import androidx.lifecycle.*
import com.gorkymunoz.app_kotlin.data.usecase.GetAllCharactersUseCase
import com.gorkymunoz.app_kotlin.network.model.InfoListNetwork
import com.gorkymunoz.app_kotlin.network.model.character.Character
import com.gorkymunoz.app_kotlin.presentation.common.ResultUI
import kotlinx.coroutines.launch


/**
 * Created by Gorky Muñoz on 29/7/2021.
 *
 *
 */
class CharacterViewModel(private val getAllCharactersUseCase: GetAllCharactersUseCase) :
    ViewModel() {

    private val _characters = MutableLiveData<ResultUI<InfoListNetwork<Character>>>()
    val characters: LiveData<ResultUI<InfoListNetwork<Character>>>
        get() {
            return _characters
        }

    fun getCharacterList() {
        viewModelScope.launch {
            val result: ResultUI<InfoListNetwork<Character>> = getAllCharactersUseCase()
            _characters.value = result
        }
    }
}

class MainViewModelFactory(private val getAllCharactersUseCase: GetAllCharactersUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterViewModel::class.java)) {
            return CharacterViewModel(getAllCharactersUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}