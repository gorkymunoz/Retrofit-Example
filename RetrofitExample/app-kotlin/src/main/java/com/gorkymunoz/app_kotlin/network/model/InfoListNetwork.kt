package com.gorkymunoz.app_kotlin.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Created by Gorky Muñoz on 28/7/2021.
 *
 */
@JsonClass(generateAdapter = true)
data class InfoListNetwork<T>(
    @Json(name = "info") val metadata: Metadata,
    @Json(name = "results") val listOfResults: List<T>,
)

@JsonClass(generateAdapter = true)
data class Metadata(
    val count: Int,
    val pages: Int,
    @Json(name = "next") val nextPage: String?,
    @Json(name = "prev") val previousPage: String?
)