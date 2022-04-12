package com.MelDia.APIClient.util;

import com.MelDia.APIClient.models.BatmanById;
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

//    public static JSONObject toJsonObject(Batman batman) {
//        JSONObject jsonObj = new JSONObject();
//        jsonObj.put("id", batman.getId_movie());
//        jsonObj.put("movie_name", batman.getMovie_name());
//        jsonObj.put("release_date", batman.getRelease_date());
//        jsonObj.put("director", batman.getDirector());
//        jsonObj.put("protagonist", batman.getProtagonist());
//        return jsonObj;
//    }
}
