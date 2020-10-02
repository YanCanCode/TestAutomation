package framework.httpentity;

import org.springframework.web.client.RestTemplate;

public class DeleteAndPost {

    private static String BASE_URL = "https://api.github.com";
    protected RestTemplate restTemplate = new RestTemplate();

    //commented out until TO-DO is done
//    @Test
//    public void deleteSuccessful() {
//        // Arrange
//        HttpHeaders headers = new HttpHeaders();
//        // TODO: find a way to hide passwords or token
//        headers.setBasicAuth("YanCanCode", "notCurrentlyAPassword");
//        headers.setBearerAuth("token");
//
//        HttpEntity<String> request = new HttpEntity<>(headers);
//
//        // Act
//        ResponseEntity response = restTemplate
//                .exchange(BASE_URL + "/repos/YanCanCode/TestAdd",
//                HttpMethod.DELETE, request, String.class);
//        // Assert
//        int responseCode = response.getStatusCodeValue();
//
//        Assertions.assertEquals(204, responseCode);
//    }

}
