package com.example.lecture18;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class GitHub {
    public static final String GITHUB_API="https://api.github.com/";
    private RestTemplate restTemplate;

    public GitHub(String accessToken){
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

    public Repos[] getRepos(String name){
        return restTemplate.getForObject(
                GITHUB_API+"users/"+name+"/repos", Repos[].class
        );
    }

}
