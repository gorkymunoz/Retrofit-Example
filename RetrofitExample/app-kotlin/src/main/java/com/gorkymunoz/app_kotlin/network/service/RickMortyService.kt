package com.gorkymunoz.app_kotlin.network.service

import com.gorkymunoz.app_kotlin.network.model.InfoListNetwork
import com.gorkymunoz.app_kotlin.network.model.character.Character
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
    suspend fun getRickMortyCharacters(): InfoListNetwork<Character>

    @GET("location/{id}")
    suspend fun getRickMortyLocationsById(@Path("id") id: String): String

    @GET("location")
    suspend fun getRickMortyLocations(): String
}