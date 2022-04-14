package com.MelDia.APIClient.control;

import com.MelDia.APIClient.models.*;
import com.MelDia.APIClient.response.OkResponse;
import com.MelDia.APIClient.response.OkResponseBatmanAdd;
import com.MelDia.APIClient.response.OkResponseBatmanAll;
import com.MelDia.APIClient.response.OkResponseBatmanUpdate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class BatmanController {

    private static final Logger log = LoggerFactory.getLogger(BatmanController.class);
    private final HTTPConsume consumeApi = new HTTPConsume(new RestTemplate());

    //GET ALL
    @GetMapping(value = "getAll", produces = {"application/json"})
    public String getAllMovie() throws JsonProcessingException {
        JSONObject json = new JSONObject();
        ResponseBatman batResponse = consumeApi.HttpConsumeAll();
        log.info("Response consume -> " + batResponse);

        if (batResponse.getStatus() == 200) {
            return OkResponseBatmanAll.okResponse(json, batResponse);
        } else {
            return "Bad response";
        }
    }

    //GET ID
    @GetMapping(value = "getById", produces = {"application/json"})
    public String getMovieById(@RequestBody Batman batman) throws JsonProcessingException {
        JSONObject json = new JSONObject();
        
        ResponseEntity<String> responseEnti = consumeApi.HttpConsumeId(batman.getId_movie());
        
        ObjectMapper objMap = new ObjectMapper().registerModule(new Jdk8Module());
        ResponseById responseId = objMap.readValue(responseEnti.getBody(), ResponseById.class);
        log.info("Response consume -> " + responseEnti);

        if (responseEnti.getStatusCodeValue() == 200 && responseId.getStatus() == 200) {
            return OkResponse.okResponse(json, responseId);
        } else {
            return "Bad response";
        }

    }

    //POST ADD
    @PostMapping(value = "add", produces = {"application/json"})
    public String postAddMovie(@RequestBody BatmanAdd batmanAdd) throws JsonProcessingException {
        JSONObject json = new JSONObject();

        ResponseEntity<String> responseEnti = consumeApi.HttpConsumeAdd(batmanAdd);

        ObjectMapper objMap = new ObjectMapper().registerModule(new Jdk8Module());
        
        ResponseBatmanAdd responseAdd = objMap.readValue(responseEnti.getBody(), ResponseBatmanAdd.class);
        log.info("Response consume -> " + responseEnti);

        if (responseEnti.getStatusCodeValue() == 200 && responseAdd.getStatus() == 200) {
            return OkResponseBatmanAdd.okResponse(json, batmanAdd, responseAdd);
        } else {
            return "Bad response";
        }
    }
    
    //DELETE
    @DeleteMapping(value = "delete", produces = {"application/json"})
    public String deleteMovie(@RequestBody BatmanRequest batReq) throws JsonProcessingException {
        JSONObject json = new JSONObject();
        
        ResponseEntity<String> responseEnti = consumeApi.HttpConsumeDelete(batReq);
        
        ObjectMapper objMap = new ObjectMapper().registerModule(new Jdk8Module());
        
        ResponseById responseId = objMap.readValue(responseEnti.getBody(), ResponseById.class);
        log.info("Response consume -> " + responseEnti);

        if (responseEnti.getStatusCodeValue() == 200 && responseId.getStatus() == 200) {
            return OkResponse.okResponse(json, responseId);
        } else {
            return "Bad response";
        }
    }
    
    //PUT UPDATE
    @PutMapping(value = "update", produces = {"application/json"})
    public String updateMovie(@RequestBody Batman batman) throws JsonProcessingException{
        JSONObject json = new JSONObject();
        
        ResponseEntity<String> responseEnti = consumeApi.HttpConsumeUpdate(batman);
        
        ObjectMapper objMap = new ObjectMapper().registerModule(new Jdk8Module());
        
        ResponseBatmanUpdate responseUpdate = objMap.readValue(responseEnti.getBody(), ResponseBatmanUpdate.class);
        log.info("Response consume -> " + responseEnti);
        
        if (responseEnti.getStatusCodeValue() == 200 && responseUpdate.getStatus() == 200) {
            return OkResponseBatmanUpdate.okResponse(json, batman, responseUpdate);
        } else {
            return "Bad response";
        }
        
    }
}
