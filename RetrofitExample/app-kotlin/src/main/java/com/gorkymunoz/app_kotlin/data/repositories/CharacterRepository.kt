package com.gorkymunoz.app_kotlin.data.repositories

import com.gorkymunoz.app_kotlin.network.model.character.Character
import com.gorkymunoz.app_kotlin.network.model.character.CharacterList
import com.gorkymunoz.app_kotlin.network.service.RickMortyService


/**
 * Created by Gorky Muñoz on 29/7/2021.
 *
 *
 */
class CharacterRepository(private val service: RickMortyService) {

    suspend fun getById(id: String): Character {
        return service.getRickMortyCharacterById(id)
    }

    suspend fun getAll(): CharacterList {
        return service.getRickMortyCharacters()
    }
}