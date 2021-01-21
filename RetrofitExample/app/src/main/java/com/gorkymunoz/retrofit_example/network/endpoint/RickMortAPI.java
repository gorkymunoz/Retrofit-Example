package com.gorkymunoz.retrofit_example.network.endpoint;

import com.gorkymunoz.retrofit_example.network.models.character.Character;
import com.gorkymunoz.retrofit_example.network.service.CharacterResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Gorky Muñoz on 21/1/2021.
 * Indra
 * gamunozg@indracompany.com
 */
public interface RickMortAPI {

    @GET("character/{id}")
    Call<Character> getRickMortyCharacterById(@Path("id") String id);

    @GET("character")
    Call<CharacterResponse> getRickMortyCharacters();
}
