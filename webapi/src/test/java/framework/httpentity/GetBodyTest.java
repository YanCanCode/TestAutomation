package framework.httpentity;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import testautomationexample.entities.User;

public class GetBodyTest {

    //TODO: Move BASE_URL to properties file
    private static final String BASE_URL = "https://api.github.com/";
    protected static RestTemplate restTemplate = new RestTemplate();

    @Test
    public void bodyContainsCurrentUserUrl() {
        // Arrange
//        String body = "Test body";
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> request = new HttpEntity<>(body, headers);

        // Act
        ResponseEntity<User> response = restTemplate.getForEntity(BASE_URL + "users/YanCanCode", User.class);

        // Assert
        Assertions.assertEquals("YanCanCode", response.getBody().getLogin());
    }
}
