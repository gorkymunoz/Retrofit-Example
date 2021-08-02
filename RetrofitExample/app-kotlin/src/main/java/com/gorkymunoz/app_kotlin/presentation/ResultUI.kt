package com.gorkymunoz.app_kotlin.presentation


/**
 * Created by Gorky Muñoz on 29/7/2021.
 *
 * Class to handle the execution of api call
 */
sealed class ResultUI<out R> {
    object Loading : ResultUI<Nothing>()
    class Success<out T>(val data: T) : ResultUI<T>()
    class Error(val exception: Throwable) : ResultUI<Nothing>()
}
