package com.gorkymunoz.app_kotlin.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Created by Gorky Muñoz on 24/7/2021.
 * Builder for retrofit instance
 *
 */
object RetrofitClient {

    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder().apply {
            baseUrl(BASE_URL)
            addConverterFactory(MoshiConverterFactory.create())
        }.build()
    }

    inline fun <reified T> createService(): T = retrofit.create(T::class.java)
}