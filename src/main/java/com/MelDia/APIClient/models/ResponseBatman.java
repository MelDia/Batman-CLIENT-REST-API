package com.MelDia.APIClient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

public class ResponseBatman implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("movies")
    private List<Batman> listMovies;
    
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("status")
    private Integer status;

    public List<Batman> getListMovies() {
        return listMovies;
    }

    public void setListMovies(List<Batman> listMovies) {
        this.listMovies = listMovies;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Response{" 
                + "list of movies: " + listMovies 
                + ", message: " + message 
                + ", status: " + status + '}';
    }    
}
