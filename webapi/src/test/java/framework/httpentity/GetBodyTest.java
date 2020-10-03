package framework.httpentity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import testautomationexample.entities.User;
import testautomationexample.exceptions.FailedAuthenticationException;

import static org.junit.Assert.assertEquals;

public class GetBodyTest {


    private final String BASE_URL = "https://api.github.com";
    protected RestTemplate restTemplate = new RestTemplate();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void bodyContainsCurrentUserUrl() {
        // Arrange
//        String body = "Test body";
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> request = new HttpEntity<>(body, headers);

        // Act
        ResponseEntity<User> response = restTemplate.getForEntity(BASE_URL + "/users/YanCanCode", User.class);

        // Assert
        assertEquals("YanCanCode", response.getBody().getLogin());
    }

    @Test
    public void negative_GetFailContainsMessage() {
        exceptionRule.expect(HttpClientErrorException.Unauthorized.class);
        exceptionRule.expectMessage("401 Unauthorized");

        //Act
        ResponseEntity<FailedAuthenticationException> response = restTemplate
                .getForEntity(BASE_URL + "/user/repos",FailedAuthenticationException.class);
        //Assert
        assertEquals("Requires Authentication", response.getBody().getMessage());
    }
}
