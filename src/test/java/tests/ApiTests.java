package tests;


import contains.ArgumentsForParameterization;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests extends BaseTest {
    @ParameterizedTest
    @ArgumentsSource(ArgumentsForParameterization.class)
    public void testGetStatus(String numOfStatus, int statusCode) {
        given()
                .spec(rspec)
                .get(numOfStatus)
                .then()
                .statusCode(statusCode)
                .assertThat()
                .header("Content-Type", equalTo("text/html; charset=utf-8"));
    }

    @ParameterizedTest
    @ArgumentsSource(ArgumentsForParameterization.class)
    public void testPostStatus(String numOfStatus, int statusCode) {
        given()
                .spec(rspec)
                .post(numOfStatus)
                .then()
                .statusCode(statusCode)
                .assertThat()
                .header("Content-Type", equalTo("text/html; charset=utf-8"));
    }
}

