package com.example.framework.httpentity;

import com.example.testautomationexample.entities.User;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetBodyTest {

    private static final String BASE_URL = "https://api.github.com/";
    protected static RestTemplate restTemplate = new RestTemplate();

    @Test
    public void bodyContainsCurrentUserUrl() {
        // Arrange
        String body = "Test body";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(body, headers);

        // Act
        ResponseEntity<User> response = restTemplate.getForEntity(BASE_URL + "users/YanCanCode", User.class);

        // Assert
        assertEquals("YanCanCode", response.getBody().getLogin());
    }
}
