package com.MelDia.APIClient.response;

import com.MelDia.APIClient.models.ResponseBatman;
import com.MelDia.APIClient.models.ResponseById;
import com.MelDia.APIClient.util.ToJSON;
import org.json.JSONObject;

public class OkResponse {

    public static String okResponse(JSONObject json, ResponseById responseId) {
        json.put("status", responseId.getStatus());
        json.put("message", responseId.getMessage());
        json.put("movie", ToJSON.toJsonBatman(responseId.getBatmanById()));
        return json.toString();
    }
    
}
