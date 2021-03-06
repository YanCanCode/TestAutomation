package framework.httpentity;


import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import test.framework.httpmethods.Post;

public class PostFailsTest {

    protected static RestTemplate restTemplate = new RestTemplate();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void negative_PostWithoutAuthorization() {
        // Sets expected exception class and message
        // If any other exceptions are thrown by the code, test will fail
        exceptionRule.expect(HttpClientErrorException.Unauthorized.class);
        exceptionRule.expectMessage("401 Unauthorized");
        Post.noAuthorizationPost();
    }

    //Junit5 Style
    @Test
    public void negative_PostWithoutAuthorizationLambda() {
        Assertions.assertThrows(HttpClientErrorException.Unauthorized.class, () -> {
            Post.noAuthorizationPost();
        });
    }
}
















    /*
    @Test
    public void negative_PostWithoutAuthorizationTest() throws Exception{
        // Arrange

        // Check github doc to see what this body should be.
        String body = null;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(body, headers);


        // Act and assert
        try{
            response = restTemplate
                    .exchange(BASE_URL + "user/repos", HttpMethod.POST, request, String.class);
            assertEquals(401, response.getStatusCodeValue());
            fail("Missing body exception should be thrown with 401 Unauthorized");
        } catch (Exception e){
            assertEquals("401 Unauthorized: [no body]", e.getMessage());
        }
    }
     */

