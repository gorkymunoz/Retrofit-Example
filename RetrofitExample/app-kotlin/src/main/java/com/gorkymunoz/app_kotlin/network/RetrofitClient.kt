package com.gorkymunoz.app_kotlin.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Created by Gorky Muñoz on 24/7/2021.
 * Builder for retrofit instance
 *
 */
object RetrofitClient {

    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private fun getUnsafeOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder().apply {
            baseUrl(BASE_URL)
            addConverterFactory(MoshiConverterFactory.create())
            client(getUnsafeOkHttpClient())
        }.build()
    }

    inline fun <reified T> createService(): T = retrofit.create(T::class.java)
}