package Campus;

import Campus.POJO_Models.Locations;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LocationsTest extends Hooks {
    Locations locations;
    Response response;

    public String randomLocationsName() {
        return RandomStringUtils.randomAlphabetic(7);
    }

    public String randomLocationsShortName() {
        return RandomStringUtils.randomAlphabetic(2);
    }

    @Test(priority = 1)
    public void createLocations() {
        locations = new Locations();
        locations.setName(randomLocationsName());
        locations.setShortName(randomLocationsShortName());
        response = given()
                .spec(requestSpec)
                .body(locations)
                .when()
                .post("/school-service/api/location")
                .then()
                .statusCode(201)
                .spec(responseSpec)
                .extract().response();
    }

    @Test(priority = 2)
    public void createLocationsWithSameName() {
        locations.setName(response.jsonPath().getString("name"));
        given()
                .spec(requestSpec)
                .body(locations)
                .when()
                .post("/school-service/api/location")
                .then()
                .statusCode(400)
                .spec(responseSpec)
                .extract().response();
    }

    @Test(priority = 3)
    public void getLocations() {
        given()
                .spec(requestSpec)
                .pathParam("locationsId", response.jsonPath().getString("id"))
                .when()
                .get("/school-service/api/location/{locationsId}")
                .then()
                .statusCode(200)
                .spec(responseSpec)
                .extract().response();
    }

    @Test(priority = 4)
    public void editLocations() {
        locations.setName(randomLocationsName());
        locations.setShortName(randomLocationsShortName());
        locations.setId(response.jsonPath().getString("id"));

        given()
                .spec(requestSpec)
                .body(locations)
                .when()
                .put("/school-service/api/location")
                .then()
                .statusCode(200)
                .spec(responseSpec)
                .extract().response();
    }

    @Test(priority = 5)
    public void deleteLocations() {
        given()
                .spec(requestSpec)
                .pathParam("locationsId", response.jsonPath().getString("id"))
                .when()
                .delete("/school-service/api/location/{locationsId}")
                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 6)
    public void getLocationsNegativeTest() {
        given()
                .spec(requestSpec)
                .pathParam("locationsId", response.jsonPath().getString("id"))
                .when()
                .get("/school-service/api/location/{locationsId}")
                .then()
                .statusCode(400)
                .spec(responseSpec)
                .extract().response();
    }

    @Test(priority = 7)
    public void deleteLocationsAfterDeleted() {
        given()
                .spec(requestSpec)
                .pathParam("locationsId", response.jsonPath().getString("id"))
                .when()
                .delete("/school-service/api/location/{locationsId}")
                .then()
                .statusCode(400)
                .extract().response();
    }


}


