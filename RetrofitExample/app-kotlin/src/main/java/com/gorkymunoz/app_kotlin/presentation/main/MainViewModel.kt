package com.gorkymunoz.app_kotlin.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorkymunoz.app_kotlin.data.usecase.GetAllCharactersUseCase
import com.gorkymunoz.app_kotlin.network.model.character.CharacterList
import com.gorkymunoz.app_kotlin.presentation.ResultUI
import kotlinx.coroutines.launch


/**
 * Created by Gorky Muñoz on 29/7/2021.
 *
 *
 */
class MainViewModel(private val getAllCharactersUseCase: GetAllCharactersUseCase) : ViewModel() {

    private val _characters = MutableLiveData<ResultUI<CharacterList>>()
    val characters: LiveData<ResultUI<CharacterList>>
        get() {
            return _characters
        }

    fun getCharacterList() {
        viewModelScope.launch {
            val result: ResultUI<CharacterList> = try {
                ResultUI.Success(getAllCharactersUseCase())
            } catch (e: Exception) {
                ResultUI.Error(e)
            }
            _characters.value = result
        }
    }
}