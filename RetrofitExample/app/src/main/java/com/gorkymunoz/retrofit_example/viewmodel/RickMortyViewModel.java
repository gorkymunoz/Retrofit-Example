package com.gorkymunoz.retrofit_example.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gorkymunoz.retrofit_example.network.service.CharacterResponse;
import com.gorkymunoz.retrofit_example.repositories.RickMortyRepository;

/**
 * Created by Gorky Muñoz on 21/1/2021.
 * <p>
 * gorkymunoz@hotmail.com
 */
public class RickMortyViewModel extends ViewModel {
    MutableLiveData<CharacterResponse> characterResponseMutableLiveData;
    RickMortyRepository rickMortyRepository;

    public RickMortyViewModel() {
        characterResponseMutableLiveData = new MutableLiveData<>();
        rickMortyRepository = RickMortyRepository.getInstance();
    }

    public void fetchCharacters() {
        rickMortyRepository.getCharacters(characterResponseMutableLiveData);
    }

    public MutableLiveData<CharacterResponse> getCharacterResponseMutableLiveData() {
        return characterResponseMutableLiveData;
    }
}
