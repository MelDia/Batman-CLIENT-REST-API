package com.MelDia.APIClient.control;

import com.MelDia.APIClient.models.Batman;
import com.MelDia.APIClient.models.BatmanAdd;
import com.MelDia.APIClient.models.BatmanRequest;
import com.MelDia.APIClient.models.ResponseBatman;
import com.MelDia.APIClient.util.ToJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HTTPConsume {

    @Autowired
    private final RestTemplate restTemp;

    public HTTPConsume(RestTemplate restTemp) {
        this.restTemp = restTemp;
    }

    //GET ALL
    public ResponseBatman HttpConsumeAll() {
        String url = "http://localhost:8080/batman/list/allMovies";
        return restTemp.getForObject(url, ResponseBatman.class);
    }
////////////////////////////////////////////////////////////////////////////////////
    
    //GET ID 
    public ResponseEntity<String> HttpConsumeId(Integer batman) {
        String url = "http://localhost:8080/batman/search/" + batman;
        ResponseEntity<String> responseEnti = restTemp.getForEntity(url, String.class);
        return responseEnti;
    }
////////////////////////////////////////////////////////////////////////////////////

    //POST ADD
    public ResponseEntity<String> HttpConsumeAdd(BatmanAdd batmanAdd) {
        String url = "http://localhost:8080/batman/add/newMovie";
        
        String toJson = ToJSON.toJsonBatman(batmanAdd).toString();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEnti = new HttpEntity<String>(toJson, headers);
        
        ResponseEntity<String> responseEnti = restTemp.postForEntity(url, httpEnti, String.class);
        return responseEnti;
    }
////////////////////////////////////////////////////////////////////////////////////

    //DELETE
    public ResponseEntity<String> HttpConsumeDelete(BatmanRequest batReq) {
        String url = "http://localhost:8080/batman/delete/" + batReq.getId_movie();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEnti = new HttpEntity<String>(headers);
        
        ResponseEntity<String> responseEnti = restTemp.exchange(url, HttpMethod.DELETE, httpEnti, String.class);
        return responseEnti;
    }
////////////////////////////////////////////////////////////////////////////////////
    
    //PUT
    public ResponseEntity<String> HttpConsumeUpdate(Batman batman){
        String url = "http://localhost:8080/batman/update/movie";
        
        String toJson = ToJSON.toJsonBatman(batman).toString();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEnti = new HttpEntity<String>(toJson, headers);
        
        ResponseEntity<String> responseEnti = restTemp.exchange(url, HttpMethod.PUT, httpEnti, String.class);
        return responseEnti;
    }
////////////////////////////////////////////////////////////////////////////////////
}
