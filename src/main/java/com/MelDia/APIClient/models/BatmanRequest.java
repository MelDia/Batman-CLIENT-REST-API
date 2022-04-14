package com.MelDia.APIClient.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BatmanRequest {
    
    @JsonProperty("id")
    private Integer id;
    
    public BatmanRequest() {
    }

    public BatmanRequest(Integer id) {
        this.id = id;
    }

    public Integer getId_movie() {
        return id;
    }

    public void setId_movie(Integer id) {
        this.id = id;
    }    
}
