package framework.restassured;

import io.restassured.RestAssured;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class BasicRestAssuredApiTest {

    private final String BASE_URL = "https://api.github.com/";

    @Test
    public void getStatusCodeIs200(){
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200);
    }

    @Test
    public void headersContainsCorrectValues() {
        RestAssured.get(BASE_URL)
                .then()
                .assertThat()
                .header("content-type", "application/json; charset=utf-8")
                .header("X-Ratelimit-Limit", "60");
    }

    @Test
    public void bodyContainsCorrectValues() {
        // equalTo is a Hamcrest matcher
        RestAssured.get(BASE_URL + "users/YanCanCode")
                .then()
                .assertThat()
                .body("login", equalTo("YanCanCode"))
                .body("type", equalTo("User"));
    }
}
