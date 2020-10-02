package framework.httpentity;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import testautomationexample.entities.User;

public class GetBodyTest {


    private String BASE_URL = "https://api.github.com";

    protected RestTemplate restTemplate = new RestTemplate();

    @Test
    public void bodyContainsCurrentUserUrl() {
        // Arrange
//        String body = "Test body";
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> request = new HttpEntity<>(body, headers);

        // Act
        ResponseEntity<User> response = restTemplate.getForEntity(BASE_URL + "/users/YanCanCode", User.class);

        // Assert
        Assertions.assertEquals("YanCanCode", response.getBody().getLogin());
    }
}
