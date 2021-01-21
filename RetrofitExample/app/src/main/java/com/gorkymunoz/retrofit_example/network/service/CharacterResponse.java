package com.gorkymunoz.retrofit_example.network.service;

import com.google.gson.annotations.SerializedName;
import com.gorkymunoz.retrofit_example.network.models.Info;
import com.gorkymunoz.retrofit_example.network.models.character.Character;

import java.util.List;

/**
 * Created by Gorky Muñoz on 21/1/2021.
 * gorkymunoz@hotmail.com
 */
public class CharacterResponse {

    @SerializedName("info")
    public Info additionalInfo;

    @SerializedName("result")
    public List<Character> characterResults;
}
