package com.gorkymunoz.app_kotlin.data.usecase

import com.gorkymunoz.app_kotlin.data.repositories.CharacterRepository
import com.gorkymunoz.app_kotlin.network.model.InfoListNetwork
import com.gorkymunoz.app_kotlin.network.model.character.Character
import com.gorkymunoz.app_kotlin.presentation.common.ResultUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created by Gorky Muñoz on 29/7/2021.
 *
 */
class GetAllCharactersUseCase(private val repository: CharacterRepository) {

    suspend operator fun invoke(): ResultUI<InfoListNetwork<Character>> {
        return withContext(Dispatchers.IO) {
            try {
                ResultUI.Success(repository.getAll())
            } catch (e: Exception) {
                ResultUI.Error(e)
            }
        }
    }
}