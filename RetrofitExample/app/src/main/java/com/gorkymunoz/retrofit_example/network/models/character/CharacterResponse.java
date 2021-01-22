package com.gorkymunoz.retrofit_example.network.models.character;

import com.google.gson.annotations.SerializedName;
import com.gorkymunoz.retrofit_example.network.models.Info;

import java.util.List;

/**
 * Created by Gorky Muñoz on 21/1/2021.
 * Indra
 * gamunozg@indracompany.com
 */
public class CharacterResponse {
    @SerializedName("info")
    private Info pagingInfo;
    @SerializedName("results")
    private List<Character> characters;
}
