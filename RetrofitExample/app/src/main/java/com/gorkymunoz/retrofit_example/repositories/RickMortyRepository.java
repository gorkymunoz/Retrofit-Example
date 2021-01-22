package com.gorkymunoz.retrofit_example.repositories;

import androidx.lifecycle.MutableLiveData;

import com.gorkymunoz.retrofit_example.network.APIClient;
import com.gorkymunoz.retrofit_example.network.endpoint.RickMortAPI;
import com.gorkymunoz.retrofit_example.network.service.CharacterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gorky Muñoz on 21/1/2021.
 * Repository for Rick & Mort API
 * gorkymunoz@hotmail.com
 */
public class RickMortyRepository {

    private static RickMortyRepository characterRepository = null;
    private final RickMortAPI rickMortAPI;

    public RickMortyRepository() {
        rickMortAPI = APIClient.getInstance().createService(RickMortAPI.class);
    }

    public static RickMortyRepository getInstance() {
        if (characterRepository == null) {
            characterRepository = new RickMortyRepository();
        }
        return characterRepository;
    }

    public void getCharacters(MutableLiveData<CharacterResponse> responseMutableLiveData) {
        rickMortAPI.getRickMortyCharacters().enqueue(new Callback<CharacterResponse>() {
            @Override
            public void onResponse(Call<CharacterResponse> _, Response<CharacterResponse> response) {
                if (response.isSuccessful()) {
                    responseMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<CharacterResponse> _, Throwable t) {
                responseMutableLiveData.setValue(null);
            }
        });
    }

}
