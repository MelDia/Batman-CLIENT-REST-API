package com.MelDia.APIClient.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BatmanAdd {
    
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("movie_name")
    private String Movie_name;
    
    @JsonProperty("release_date")
    private String Release_date;
    
    @JsonProperty("director")
    private String Director;
    
    @JsonProperty("protagonist")
    private String Protagonist;

    public String getMovie_name() {
        return Movie_name;
    }

    public void setMovie_name(String Movie_name) {
        this.Movie_name = Movie_name;
    }

    public String getRelease_date() {
        return Release_date;
    }

    public void setRelease_date(String Release_date) {
        this.Release_date = Release_date;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getProtagonist() {
        return Protagonist;
    }

    public void setProtagonist(String Protagonist) {
        this.Protagonist = Protagonist;
    }

    @Override
    public String toString() {
        return "BatmanAdd{" 
                + "Movie name: " + Movie_name 
                + ", Release date: " + Release_date 
                + ", Director: " + Director 
                + ", Protagonist: " + Protagonist + '}';
    }
    
    
}
