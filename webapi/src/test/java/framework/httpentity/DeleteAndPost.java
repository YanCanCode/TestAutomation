package framework.httpentity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class DeleteAndPost {


    private final String BASE_URL = "https://api.github.com";
    private String token = "";
    protected RestTemplate restTemplate = new RestTemplate();


    @Test
    public void createRepoReturns201() {
        // Arrange
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        String body = "{\"name\": \"deleteme\"}";

        HttpEntity request = new HttpEntity(body, headers);

        // Act
        ResponseEntity response = restTemplate.postForEntity(BASE_URL + "/user/repos",
                request, String.class);

        // Assert
        Assertions.assertEquals(201,response.getStatusCodeValue());

    }

    @Test
    public void deleteSuccessful() {
        // Arrange
        HttpHeaders headers = new HttpHeaders();

        headers.setBearerAuth(token);

        HttpEntity<String> request = new HttpEntity<>(headers);

        // Act
        ResponseEntity response = restTemplate
                .exchange(BASE_URL + "/repos/YanCanCode/deleteme",
                        HttpMethod.DELETE, request, String.class);

        // Assert
        int responseCode = response.getStatusCodeValue();
        Assertions.assertEquals(204, responseCode);
    }
}
