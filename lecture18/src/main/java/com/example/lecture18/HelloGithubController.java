package com.example.lecture18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloGithubController {

    @Autowired
    private GitHub gitHub;


    private Twitter twitter = new Twitter("AAAAAAAAAAAAAAAAAAAAAHaxOgEAAAAAjQaHvU%2BU5fJf5Hj6%2F0KjbLGTb%2Bg%3D8OoKSNeAAQewdSUdYOFKgS3lcThYI1isahLhQ27phQIOHLwdKG");

    @GetMapping("/repos")
    public Repos[] getRepos( OAuth2AuthenticationToken oAuth2AuthenticationToken){
        System.out.println(oAuth2AuthenticationToken);
        return gitHub.getRepos("yadp");
    }

    @GetMapping("/tweets")
    public  String getTweets(){
        return twitter.getTweets();
    }
}
