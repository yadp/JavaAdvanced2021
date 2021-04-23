package com.example.lecture18;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TwitterTest {
    @Value( "${oauth.token}" )
    private String token;

    @Test
    void getTweets() {

        Twitter twitter = new Twitter(token);
        assertNotNull(twitter.getTweets());

        twitter=new Twitter("fakeKey");
        Twitter finalTwitter = twitter;
        assertThrows(HttpClientErrorException.class, ()-> finalTwitter.getTweets());
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetTweets() {
    }
}