package com.example.lecture16;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class Twitter {

    public static final String TWITTER_API="https://api.twitter.com/";
    private RestTemplate restTemplate;

    public Twitter(String accessToken){
        this.restTemplate= new RestTemplate();
        restTemplate.getInterceptors().add(generateInterceptor(accessToken));
    }

    private ClientHttpRequestInterceptor generateInterceptor(String accessToken) {
        return new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

                httpRequest.getHeaders().add("Authorization", "Bearer "+ accessToken);
                return clientHttpRequestExecution.execute(httpRequest,bytes);
            }
        };
    }

    public String getTweets(){
        return restTemplate.getForObject(TWITTER_API+"2/tweets/search/recent?query=nyc", String.class);
    }
}
