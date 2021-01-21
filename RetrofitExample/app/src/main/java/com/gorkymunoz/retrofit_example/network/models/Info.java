package com.gorkymunoz.retrofit_example.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Gorky Muñoz on 21/1/2021.
 * gorkymunoz@hotmail.com
 */
public class Info {
    @SerializedName("count")
    private Integer totalResults;
    @SerializedName("pages")
    private Integer totalPages;
    @SerializedName("next")
    private String nextPageUrl;
    @SerializedName("prev")
    private String previousPageUrl;

    public Info() {
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public String getPreviousPageUrl() {
        return previousPageUrl;
    }
}
