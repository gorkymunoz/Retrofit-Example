package com.gorkymunoz.retrofit_example.network.models.character;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Gorky Muñoz on 21/1/2021.
 * gorkymunoz@hotmail.com
 */
public class Character {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("status")
    private String status;
    @SerializedName("species")
    private String species;
    @SerializedName("type")
    private String type;
    @SerializedName("gender")
    private String gender;
    @SerializedName("origin")
    private ExtraInfo originInfo;
    @SerializedName("location")
    private ExtraInfo locationInfo;
    @SerializedName("image")
    private String image;
    @SerializedName("episode")
    private List<String> episode;
    @SerializedName("url")
    private String url;
    @SerializedName("created")
    private String created;

}





