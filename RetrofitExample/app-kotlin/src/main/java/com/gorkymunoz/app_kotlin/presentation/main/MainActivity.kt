package com.gorkymunoz.app_kotlin.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gorkymunoz.app_kotlin.data.repositories.CharacterRepository
import com.gorkymunoz.app_kotlin.data.usecase.GetAllCharactersUseCase
import com.gorkymunoz.app_kotlin.databinding.ActivityMainBinding
import com.gorkymunoz.app_kotlin.network.RetrofitClient
import com.gorkymunoz.app_kotlin.network.model.character.CharacterList
import com.gorkymunoz.app_kotlin.presentation.common.ResultUI
import com.gorkymunoz.app_kotlin.presentation.common.getViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val characterAdapter by lazy { CharacterAdapter() }

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

        binding.rvCharacter.apply {
            layoutManager =
                GridLayoutManager(this@MainActivity, 3, LinearLayoutManager.VERTICAL, false)
            adapter = characterAdapter
        }

        viewModel.characters.observe(this, Observer(::updateUI))
    }

    private fun updateUI(result: ResultUI<CharacterList>) {

        when (result) {
            is ResultUI.Loading -> print("LOADING")
            is ResultUI.Error -> Log.e("ERROR", result.exception.message, result.exception)
            is ResultUI.Success -> updateCharacters(result.data)
        }
    }

    private fun updateCharacters(data: CharacterList) {
        characterAdapter.submitList(data.listOfCharacters)
    }

}