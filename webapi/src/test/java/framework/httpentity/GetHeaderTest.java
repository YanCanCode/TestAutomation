package framework.httpentity;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GetHeaderTest {


    @Value("${api.url}")
    private static String BASE_URL;

    protected static RestTemplate restTemplate = new RestTemplate();
    private static HttpEntity<String> request;
    private static ResponseEntity response;

    @BeforeAll
    static void sendGetToBaseEndpoint() {
        // Arrange
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("User-Agent", "TestExample");

        HttpEntity<String> request = new HttpEntity<>(headers);

        // Act
        response = restTemplate.exchange(BASE_URL,HttpMethod.GET,request,String.class);
    }

    @Test
    public void getReturns200() {
        assertEquals(200,response.getStatusCodeValue());
    }

    @ParameterizedTest
    @CsvSource({
            "X-Ratelimit-Limit, 60",
            "content-type, application/json; charset=utf-8"
    })
    public void parameterizedHeaders(String header, String expectedValue) {
        String contentType = response.getHeaders().getFirst(header);
        assertEquals(expectedValue, contentType);
    }
    
    
    /*
     * This was the test before the above refactoring.  Multiple calls can be made by adding to the CSV source.
     * Parameterization maintains a clean codebase.
     *
    @Test
    public void xRateLimitIsPresent() {
        
        //Arrange
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("User-Agent", "TestExample");

        HttpEntity<String> request = new HttpEntity<>(headers);

        //Act
        ResponseEntity response = restTemplate.exchange(BASE_URL, HttpMethod.GET, request, String.class);
        String xRateLimit = response.getHeaders().getFirst("X-Ratelimit-Limit");

        //Assert
        assertEquals(60, Integer.parseInt(xRateLimit));
    }

 */
}
