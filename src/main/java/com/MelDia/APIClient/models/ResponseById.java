package com.MelDia.APIClient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Optional;

public class ResponseById {

    @JsonProperty("movie")
    private Optional<BatmanById> batmanById;

    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("ErrorCode")
    private String errorCode;

    @JsonProperty("ErrorMessage")
    private String errorMessage;

    public Optional<BatmanById> getBatmanById() {
        return batmanById;
    }

    public void setBatmanById(Optional<BatmanById> batmanById) {
        this.batmanById = batmanById;
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
        return "Response search by Id{"
                + "Id: " + batmanById
                + ", message: " + message
                + ", status: " + status + '}';
    }

}
