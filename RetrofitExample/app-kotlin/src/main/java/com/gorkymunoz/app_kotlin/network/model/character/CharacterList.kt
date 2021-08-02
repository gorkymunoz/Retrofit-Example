package com.gorkymunoz.app_kotlin.network.model.character

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Created by Gorky Muñoz on 28/7/2021.
 *
 */
@JsonClass(generateAdapter = true)
data class CharacterList(
    @Json(name = "info") val metadata: Metadata,
    @Json(name = "results") val listOfCharacters: List<Character>,
)

@JsonClass(generateAdapter = true)
data class Metadata(
    val count: Int,
    val pages: Int,
    @Json(name = "next") val nextPage: String?,
    @Json(name = "prev") val previousPage: String?
)