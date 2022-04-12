package com.MelDia.APIClient.response;

import com.MelDia.APIClient.models.BatmanResponse;
import com.MelDia.APIClient.models.ResponseById;
import com.MelDia.APIClient.util.ToJSON;
import org.json.JSONObject;

public class OkResponse {

    public static String okResponseAllMovies(JSONObject json, BatmanResponse batResponse) {
        json.put("status", batResponse.getStatus());
        json.put("message", batResponse.getMessage());
        json.put("movies", batResponse.getListMovies());
        return json.toString();
    }
    
    public static String okResponseById(JSONObject json, ResponseById responseId) {
        json.put("status", responseId.getStatus());
        json.put("message", responseId.getMessage());
        json.put("movie", ToJSON.toJsonBatman(responseId.getBatmanById()));
        return json.toString();
    }
}
