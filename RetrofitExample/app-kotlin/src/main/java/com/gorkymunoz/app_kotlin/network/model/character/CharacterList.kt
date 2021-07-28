package com.gorkymunoz.app_kotlin.network.model.character

import com.squareup.moshi.Json


/**
 * Created by Gorky Muñoz on 28/7/2021.
 *
 */
data class CharacterList(
    @Json(name = "info") val additionalInfo: String,
    @Json(name = "results") val listOfCharacters: List<Character>,
)