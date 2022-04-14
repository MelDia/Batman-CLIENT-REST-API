package com.MelDia.APIClient.util;

import com.MelDia.APIClient.models.Batman;
import com.MelDia.APIClient.models.BatmanAdd;
import com.MelDia.APIClient.models.BatmanById;
import com.MelDia.APIClient.models.RequestAdd;
import java.util.Optional;
import org.json.JSONObject;

public class ToJSON {

    public static JSONObject toJsonBatman(Optional<BatmanById> batmanById) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", batmanById.get().getId_movie());
        jsonObj.put("movie_name", batmanById.get().getMovie_name());
        jsonObj.put("release_date", batmanById.get().getRelease_date());
        jsonObj.put("director", batmanById.get().getDirector());
        jsonObj.put("protagonist", batmanById.get().getProtagonist());
        return jsonObj;
    }
    
    public static JSONObject toJsonBatman(Batman batman) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", batman.getId_movie());
        jsonObj.put("movie_name", batman.getMovie_name());
        jsonObj.put("release_date", batman.getRelease_date());
        jsonObj.put("director", batman.getDirector());
        jsonObj.put("protagonist", batman.getProtagonist());
        return jsonObj;
    }

    public static JSONObject toJsonObject(RequestAdd requestAdd) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("movie_name", requestAdd.getMovie_name());
        jsonObj.put("release_date", requestAdd.getRelease_date());
        jsonObj.put("director", requestAdd.getDirector());
        jsonObj.put("protagonist", requestAdd.getProtagonist());
        return jsonObj;
    }

    public static JSONObject toJsonBatman(BatmanAdd batmanAdd) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("movie_name", batmanAdd.getMovie_name());
        jsonObj.put("release_date", batmanAdd.getRelease_date());
        jsonObj.put("director", batmanAdd.getDirector());
        jsonObj.put("protagonist", batmanAdd.getProtagonist());
        return jsonObj;
    }
}
