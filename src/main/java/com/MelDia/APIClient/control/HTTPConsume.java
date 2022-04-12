package com.MelDia.APIClient.control;

import com.MelDia.APIClient.models.BatmanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HTTPConsume {

    @Autowired
    private final RestTemplate restTemp;

    public HTTPConsume(RestTemplate restTemp) {
        this.restTemp = restTemp;
    }

    //GET ALL RESPONSE
    public BatmanResponse HttpConsume() {
        String url = "http://localhost:8080/batman/list/allMovies";
        return restTemp.getForObject(url, BatmanResponse.class);
    }
    
    //GET BY ID RESPONSE
    public ResponseEntity<String> HttpConsume(Integer batman) {
        String url = "http://localhost:8080/batman/search/" + batman;
        ResponseEntity<String> responseEnti = restTemp.getForEntity(url, String.class);
        return responseEnti;
    }

}
