package com.MelDia.APIClient.response;

import com.MelDia.APIClient.models.Batman;
import com.MelDia.APIClient.models.ResponseBatmanUpdate;
import com.MelDia.APIClient.util.ToJSON;
import org.json.JSONObject;

public class OkResponseBatmanUpdate {

    public static String okResponse(JSONObject json, Batman batman, ResponseBatmanUpdate responseUpdate) {
        json.put("status", responseUpdate.getStatus());
        json.put("message", responseUpdate.getMessage());
        json.put("movie", ToJSON.toJsonBatman(batman));
        return json.toString();
    }
}
