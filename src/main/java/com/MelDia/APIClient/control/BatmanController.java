package com.MelDia.APIClient.control;

import com.MelDia.APIClient.models.Batman;
import com.MelDia.APIClient.models.BatmanResponse;
import com.MelDia.APIClient.models.ResponseById;
import com.MelDia.APIClient.response.OkResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BatmanController {
    
    private static final Logger log = LoggerFactory.getLogger(BatmanController.class);
    private final HTTPConsume consumeApi = new HTTPConsume(new RestTemplate());
    
    //Get all movies
    @GetMapping(value = "getAll", produces = {"application/json"})
    public String getAllMovie() throws JsonProcessingException {
        JSONObject json = new JSONObject();
        BatmanResponse batResponse = consumeApi.HttpConsume();
        log.info("Response consume -> " + batResponse);

        if (batResponse.getStatus() == 200) {
            return OkResponse.okResponseAllMovies(json, batResponse);
        } else {
            return "Bad response";
        }
    } 
    
    //Get movie by id
    @GetMapping(value = "getById", produces = {"application/json"})
    public String getMovieById(@RequestBody Batman batman) throws JsonProcessingException {
        JSONObject json = new JSONObject();
        ResponseEntity<String> responseEnti = consumeApi.HttpConsume(batman.getId_movie());
        ObjectMapper objMap = new ObjectMapper().registerModule(new Jdk8Module());
        ResponseById responseId = objMap.readValue(responseEnti.getBody(), ResponseById.class);
        log.info("Response consume -> " + responseEnti);
        
        if (responseEnti.getStatusCodeValue() == 200 && responseId.getStatus() == 200) {
            return OkResponse.okResponseById(json, responseId);
        } else {
            return "Bad response";
        }
        
    }
}
