package com.gorkymunoz.app_kotlin.presentation.ui.character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gorkymunoz.app_kotlin.data.repositories.CharacterRepository
import com.gorkymunoz.app_kotlin.data.usecase.GetAllCharactersUseCase
import com.gorkymunoz.app_kotlin.databinding.FragmentCharacterBinding
import com.gorkymunoz.app_kotlin.network.RetrofitClient
import com.gorkymunoz.app_kotlin.network.model.InfoListNetwork
import com.gorkymunoz.app_kotlin.network.model.character.Character
import com.gorkymunoz.app_kotlin.presentation.common.ResultUI
import com.gorkymunoz.app_kotlin.presentation.main.CharacterAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [CharacterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!

    private val characterAdapter by lazy { CharacterAdapter() }
    private val viewModel: CharacterViewModel by activityViewModels {
        MainViewModelFactory(
            GetAllCharactersUseCase(
                CharacterRepository(RetrofitClient.createService())
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCharacterList()
        viewModel.characters.observe(this, Observer(::updateUI))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvHome.apply {
            layoutManager =
                GridLayoutManager(context, 3, LinearLayoutManager.VERTICAL, false)
            adapter = characterAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateUI(result: ResultUI<InfoListNetwork<Character>>) {

        when (result) {
            is ResultUI.Loading -> print("LOADING")
            is ResultUI.Error -> Log.e("ERROR", result.exception.message, result.exception)
            is ResultUI.Success -> updateCharacters(result.data)
        }
    }

    private fun updateCharacters(data: InfoListNetwork<Character>) {
        characterAdapter.submitList(data.listOfResults)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment CharacterFragment.
         */
        @JvmStatic
        fun newInstance() = CharacterFragment()
    }
}