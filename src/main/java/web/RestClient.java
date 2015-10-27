package web;

import domain.Country;
import domain.ResponseData;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import service.CountryService;
import java.util.List;

public class RestClient {

    private static final String URI = "http://tripcomposer.net/rest/test/countries/get";
    private static final  String KEY = "$1$12309856$euBrWcjT767K2sP9MHcVS/";

    private CountryService countryService;
    private RestTemplate restTemplate;

    public RestClient() {
        countryService = new CountryService();
        restTemplate = new RestTemplate();
    }

    public ResponseData sendPostRequest() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject postBodyJson = new JSONObject();
        postBodyJson.put("key", KEY);
        postBodyJson.put("echo", "echo");

        HttpEntity request = new HttpEntity(postBodyJson.toString(), headers);
        return restTemplate.postForObject(URI, request, ResponseData.class);
    }

    public void parseRequestResult(ResponseData result) {
        List<Country> countries = result.getCountries();
        for (Country country : countries) {
            countryService.save(country);
        }
    }
}
