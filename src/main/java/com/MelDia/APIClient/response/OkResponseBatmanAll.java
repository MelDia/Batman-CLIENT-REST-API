package com.MelDia.APIClient.response;

import com.MelDia.APIClient.models.ResponseBatman;
import org.json.JSONObject;

public class OkResponseBatmanAll {
    
    public static String okResponse(JSONObject json, ResponseBatman batResponse) {
        json.put("status", batResponse.getStatus());
        json.put("message", batResponse.getMessage());
        json.put("movies", batResponse.getListMovies());
        return json.toString();
    }
}
