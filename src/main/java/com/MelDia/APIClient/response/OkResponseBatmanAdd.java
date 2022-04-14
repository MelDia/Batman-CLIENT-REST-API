package com.MelDia.APIClient.response;

import com.MelDia.APIClient.models.BatmanAdd;
import com.MelDia.APIClient.models.RequestAdd;
import com.MelDia.APIClient.models.ResponseBatmanAdd;
import com.MelDia.APIClient.util.ToJSON;
import org.json.JSONObject;

public class OkResponseBatmanAdd {

    public static String okResponse(JSONObject json, BatmanAdd batmanAdd, ResponseBatmanAdd responseAdd) {
        json.put("status", responseAdd.getStatus());
        json.put("message", responseAdd.getMessage());
        json.put("movie", ToJSON.toJsonBatman(batmanAdd));
        return json.toString();
    }
    
    public static String okResponse(JSONObject json, RequestAdd requestAdd, ResponseBatmanAdd responseAdd) {
        json.put("status", responseAdd.getStatus());
        json.put("message", responseAdd.getMessage());
        json.put("movie", ToJSON.toJsonObject(requestAdd));
        return json.toString();
    }

//    public static String responseOK(JSONObject json, Person person, ResponseModifyPerson okResp) {
//        json.put("function", okResp.getFunction());
//        json.put("status", okResp.getStatus());
//        json.put("message", okResp.getMessage());
//        json.put("person", TransformToJson.toJsonPerson(person));
//        return json.toString();
//    }

}
