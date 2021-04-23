package com.example.lecture16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloGithubController {

    @Autowired
    private GitHub gitHub;

    @GetMapping("/repos")
    public Repos[] getRepos( OAuth2AuthenticationToken oAuth2AuthenticationToken){
        System.out.println(oAuth2AuthenticationToken);
        return gitHub.getRepos("yadp");
    }
}
