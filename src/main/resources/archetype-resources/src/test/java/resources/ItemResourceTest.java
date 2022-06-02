package ${package}.resources;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class ItemResourceTest {

    @Test
    @Order(1)
    public void getAllTest() {
        given()
                .when()
                .get("/item")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].id", is(1)).and()
                .body("[0].name", is("Noor")).and()
                .body("[0].count", is(1)).and()
                .body("[0].status", is("working")).and()
                .body("[1].id", is(2)).and()
                .body("[1].name", is("Samuele")).and()
                .body("[1].count", is(1)).and()
                .body("[1].status", is("working"));
    }

    @Test
    @Order(2)
    public void getOneTest() {
        given()
                .when()
                .get("/item/Noor")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", is(1)).and()
                .body("name", is("Noor")).and()
                .body("count", is(1)).and()
                .body("status", is("working"));
    }

    @Test
    @Order(3)
    public void createTest() {
        String item = "{\"name\":\"Erik\", \"count\":1, \"status\":\"not-working\"}";
        given()
                .when()
                .body(item).contentType(ContentType.JSON).post("/item")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("id", is(3)).and()
                .body("name", is("Erik")).and()
                .body("count", is(1)).and()
                .body("status", is("not-working"));
    }

    @Test
    @Order(4)
    public void updateTest() {
        String updatedItem = "{\"name\":\"Erik\", \"count\":1, \"status\":\"working\"}";
        given()
                .when()
                .body(updatedItem).contentType(ContentType.JSON).put("/item")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", is(3)).and()
                .body("name", is("Erik")).and()
                .body("count", is(1)).and()
                .body("status", is("working"));
    }

    @Test
    @Order(5)
    public void deleteTest() {
        given()
                .when()
                .delete("/item/Erik")
                .then()
                .statusCode(200);
    }
}
