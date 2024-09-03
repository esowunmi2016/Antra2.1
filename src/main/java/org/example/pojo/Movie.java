package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
    private String imdbID ;
    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private int year;


    public String getTitle() {
        return title;
    }
    public String getImdbID() {
        return imdbID;
    }

//
    public int getYear() {
        return year;
    }
}
