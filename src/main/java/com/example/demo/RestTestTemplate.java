package com.example.demo;


import com.example.demo.api.BandInfoDTO;
import com.example.demo.api.TokenDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Base64;


@Service
public class RestTestTemplate {

    @Value("${CLIENT.ID}")
    String id ;
    @Value("${CLIENT.SECRET}")
    String pwd;


    public void requestBand(String code){
       TokenDTO tokenDTO =  authToken(code);

       bandKey(tokenDTO.getAccess_token());
    }


    public TokenDTO authToken(String code){
        String credentials = id + ":" + pwd;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder
                .fromUriString("https://auth.band.us/oauth2/token")
                .queryParam("grant_type","authorization_code")
                .queryParam("code",code)
                .build()
                .encode()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Basic "+encodedCredentials);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ParameterizedTypeReference<TokenDTO> responseType = new ParameterizedTypeReference<>(){};
        ResponseEntity<TokenDTO> responseEntity = restTemplate.exchange(uri, HttpMethod.GET,requestEntity,responseType);

        return responseEntity.getBody();
    }
    public void bandKey(String accessToken){
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.band.us/v2.1/bands")
                .queryParam("access_token",accessToken)
                .build()
                .encode()
                .toUri();
        ParameterizedTypeReference<BandInfoDTO> responseType = new ParameterizedTypeReference<>(){};
        ResponseEntity<BandInfoDTO> responseEntity = restTemplate.exchange(uri, HttpMethod.GET,null,BandInfoDTO.class);

        System.out.println(responseEntity.getBody());
    }


}
