package com.gorkymunoz.app_kotlin.network.model

import com.squareup.moshi.JsonClass


/**
 * Created by Gorky Muñoz on 26/7/2021.
 *
 *
 */
@JsonClass(generateAdapter = true)
data class ExtraInfo(val name: String, val url: String)
