package com.MelDia.APIClient.response;

import com.MelDia.APIClient.models.Batman;
import com.MelDia.APIClient.models.BatmanAdd;
import com.MelDia.APIClient.models.ResponseBatman;
import com.MelDia.APIClient.models.ResponseById;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

public class BadResponse {

    public static String ExceptionResponse(JSONObject jsonObj, ResponseBatman batResponse) {
        jsonObj.put("ErrorCode", batResponse);
        return jsonObj.toString();
    }
///////////////////////////////////////////////////////////////////////////////////////////////
    
    public static String ExceptionResponseId(JSONObject jsonObj, ResponseById responseId) throws JsonProcessingException {
        jsonObj.put("status", responseId.getStatus());
        jsonObj.put("ErrorCode", responseId.getErrorCode());
        jsonObj.put("ErrorMessage", responseId.getErrorMessage());
        return jsonObj.toString();
    }
///////////////////////////////////////////////////////////////////////////////////////////////
    
    public static String ExceptionResponseAdd(JSONObject jsonObj, BatmanAdd batmanAdd) {
        if (!(batmanAdd.getMovie_name() == null 
                || batmanAdd.getRelease_date() == null 
                || batmanAdd.getDirector() == null
                || batmanAdd.getProtagonist() == null)) {
            
            jsonObj.put("status", HttpStatus.BAD_REQUEST.value());
            jsonObj.put("ErrorCode", "NN-0001");
            jsonObj.put("ErrorMessage", "Some attributes  are null"); 
        }
        return jsonObj.toString(); 
    }
///////////////////////////////////////////////////////////////////////////////////////////////
    
    public static String ExceptionResponseUpdate(JSONObject jsonObj, Batman batman) {
        if (!(batman.getId_movie() == null) || batman.getId_movie() <= 0) {
            jsonObj.put("status", HttpStatus.BAD_REQUEST.value());
            jsonObj.put("ErrorCode", "NF-0002");
            jsonObj.put("ErrorMessage", "The movie you are trying to update does not exist");
        }
        return jsonObj.toString();
    }
///////////////////////////////////////////////////////////////////////////////////////////////
    
    public static String ExceptionResponseDelete(JSONObject jsonObj, ResponseById responseId) {
        jsonObj.put("status", responseId.getStatus());
        jsonObj.put("ErrorCode", "CD-0003");
        jsonObj.put("ErrorMessage", "The movie you are trying to delete has already been deleted before or does not exist");
        return jsonObj.toString();
    }

}
