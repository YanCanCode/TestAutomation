package httpmethods;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Post {

    @Value("${api.url}")
    private static String BASE_URL;

    protected static RestTemplate restTemplate = new RestTemplate();

    public static ResponseEntity noAuthorizationPost(){
        //Setup
        String body = "Test body";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(body, headers);

        // Make request
        ResponseEntity response = restTemplate
                .exchange(BASE_URL + "user/repos", HttpMethod.POST, request, String.class);

        return response;
    }
}
