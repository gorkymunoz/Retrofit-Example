package com.gorkymunoz.app_kotlin.presentation.common

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.get


/**
 * Created by Gorky Muñoz on 29/7/2021.
 *
 */

@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> FragmentActivity.getViewModel(
    owner: ViewModelStoreOwner = this,
    crossinline factory: () -> T
): T {

    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U

    }

    return ViewModelProvider(owner, vmFactory).get()
}
