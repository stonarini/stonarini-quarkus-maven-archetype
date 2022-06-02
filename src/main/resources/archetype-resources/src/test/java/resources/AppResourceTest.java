package ${package}.resources;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AppResourceTest {
    @Test
    public void rootTest() {
        given()
                .when().get("/")
                .then()
                .statusCode(200)
                .contentType(ContentType.TEXT)
                .body(is("Test OK Response"));
    }
}
