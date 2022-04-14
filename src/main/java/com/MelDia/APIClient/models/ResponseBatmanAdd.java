package com.MelDia.APIClient.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseBatmanAdd {
    
    @JsonProperty("movie")
    private Batman batman;
    
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("status")
    private Integer status;
    
    @JsonProperty("ErrorCode")
    private String errorCode;

    @JsonProperty("ErrorMessage")
    private String errorMessage;

    public Batman getBatman() {
        return batman;
    }

    public void setBatman(Batman batman) {
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

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    

    @Override
    public String toString() {
        return "Response Add {" 
                + batman 
                + ", message: " + message 
                + ", status: " + status 
                + '}';
    }
    
    
}
