package framework.httpentity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Options204Test {

    private static String BASE_URL = "https://api.github.com";

    protected static RestTemplate restTemplate = new RestTemplate();

    @Test
    public void optionsReturnsMethodsList(){
        // Arrange
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);

        // Act
        ResponseEntity response = restTemplate.exchange(BASE_URL, HttpMethod.OPTIONS, request, String.class);

        // Assert
        String expectedMethods = "GET, POST, PATCH, PUT, DELETE";
        String targetHeader =  response.getHeaders().getFirst("Access-Control-Allow-Methods");
        Assertions.assertEquals(expectedMethods, targetHeader);

    }
}
