package ${package};

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class AppResourceTest {
    @Test
    public void firstTest() {
        given()
        .when().get("/")
        .then()
           .statusCode(200)
           .body(is("Quarkus is working!"));
    }
}
