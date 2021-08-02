package com.gorkymunoz.app_kotlin.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gorkymunoz.app_kotlin.data.repositories.CharacterRepository
import com.gorkymunoz.app_kotlin.data.usecase.GetAllCharactersUseCase
import com.gorkymunoz.app_kotlin.databinding.ActivityMainBinding
import com.gorkymunoz.app_kotlin.network.RetrofitClient
import com.gorkymunoz.app_kotlin.network.model.character.CharacterList
import com.gorkymunoz.app_kotlin.presentation.ResultUI
import com.gorkymunoz.app_kotlin.presentation.common.getViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = getViewModel {
            MainViewModel(
                GetAllCharactersUseCase(
                    CharacterRepository(RetrofitClient.createService())
                )
            )
        }.also {
            it.getCharacterList()
        }

        viewModel.characters.observe(this, Observer(::updateUI))
    }

    private fun updateUI(result: ResultUI<CharacterList>) {

        when (result) {
            is ResultUI.Loading -> print("LOADING")
            is ResultUI.Error -> Log.e("ERROR", result.exception.message, result.exception)
            is ResultUI.Success -> Log.d("SUCCESS", result.data.toString())
        }
    }

}