package com.MelDia.APIClient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Optional;

public class ResponseBatmanUpdate {
    
    @JsonProperty("movie")
    private Optional<Batman> batman;

    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private Integer status;

    public Optional<Batman> getBatman() {
        return batman;
    }

    public void setBatman(Optional<Batman> batman) {
        this.batman = batman;
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
        return "Response Update{" 
                + "movie" + batman 
                + ", message: " + message 
                + ", status: " + status 
                + '}';
    }
    
    
    
}
