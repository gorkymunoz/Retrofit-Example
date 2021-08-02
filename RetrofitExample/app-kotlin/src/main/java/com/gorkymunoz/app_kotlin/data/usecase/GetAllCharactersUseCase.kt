package com.gorkymunoz.app_kotlin.data.usecase

import com.gorkymunoz.app_kotlin.data.repositories.CharacterRepository
import com.gorkymunoz.app_kotlin.network.model.character.CharacterList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created by Gorky Muñoz on 29/7/2021.
 *
 */
class GetAllCharactersUseCase(private val repository: CharacterRepository) {

    suspend operator fun invoke(): CharacterList {
        return withContext(Dispatchers.IO) {
            repository.getAll()
        }
    }
}