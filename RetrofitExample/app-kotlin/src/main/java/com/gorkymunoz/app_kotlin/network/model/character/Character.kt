package com.gorkymunoz.app_kotlin.network.model.character

import com.gorkymunoz.app_kotlin.network.model.ExtraInfo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Created by Gorky Muñoz on 26/7/2021.
 *
 *
 */
@JsonClass(generateAdapter = true)
data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: ExtraInfo,
    val location: ExtraInfo,
    val image: String,
    @Json(name = "episode") val listOfEpisodes: List<String>,
    val url: String,
    val created: String
)
