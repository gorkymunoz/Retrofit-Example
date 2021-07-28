package com.gorkymunoz.app_kotlin.network.endpoint

import com.gorkymunoz.app_kotlin.network.model.character.Character
import com.gorkymunoz.app_kotlin.network.model.character.CharacterList
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by Gorky Muñoz on 26/7/2021.
 *
 *
 */
interface RickMortyService {


    @GET("character/{id}")
    suspend fun getRickMortyCharacterById(@Path("id") id: String): Character

    @GET("character")
    suspend fun getRickMortyCharacters(): CharacterList

}