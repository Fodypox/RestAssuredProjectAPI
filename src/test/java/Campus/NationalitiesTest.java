package Campus;

import Campus.POJO_Models.Nationalities;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NationalitiesTest extends Hooks {
    Response response;
    Nationalities nationalities;

    @Test(priority = 1)
    public void createNationality(){
        nationalities=new Nationalities();
        nationalities.setName(randomNationalityName());
        response = given()
                .spec(requestSpec)
                .body(nationalities)
                .when()
                .post("/school-service/api/nationality")
                .then()
                .statusCode(201)
                .spec(responseSpec)
                .extract().response();
    }
    @Test(priority = 2)
    public void createNationalityNegative(){
        nationalities.setName(response.jsonPath().getString("name"));
        given()
                .spec(requestSpec)
                .body(nationalities)
                .when()
                .post("/school-service/api/nationality")
                .then()
                .statusCode(400)
                .spec(responseSpec);

    }
    @Test(priority = 3)
    public void getNationality(){
        nationalities.setName(response.jsonPath().getString("name"));
        given()
                .spec(requestSpec)
                .body(nationalities)
                .when()
                .post("/school-service/api/nationality/search")
                .then()
                .statusCode(200)
                .spec(responseSpec);


    }
    @Test(priority = 4)
    public void updateNationality(){
        nationalities.setName(randomNationalityName());
        nationalities.setId(response.jsonPath().getString("id"));
        given()
                .spec(requestSpec)
                .body(nationalities)
                .when()
                .put("/school-service/api/nationality")
                .then()
                .statusCode(200)
                .spec(responseSpec);
    }

    @Test(priority = 5)
    public void deleteNationality(){
        given()
                .pathParam("NationalityId", response.jsonPath().getString("id"))
                .cookies(cookies)
                .when()
                .delete("/school-service/api/nationality/{NationalityId}")
                .then()
                .statusCode(200)
                .log().body();

    }
    @Test(priority = 6)
    public void getNationalityAfterDelete(){
        nationalities.setName(response.jsonPath().getString("name"));
        given()
                .spec(requestSpec)
                .body(nationalities)
                .when()
                .post("/school-service/api/nationality/search")
                .then()
                .statusCode(200)
                .spec(responseSpec);
    }

    @Test(priority = 7)
    public void deleteNationalityNegative(){
        given()
                .pathParam("NationalityId", response.jsonPath().getString("id"))
                .cookies(cookies)
                .when()
                .delete("/school-service/api/nationality/{NationalityId}")
                .then()
                .statusCode(400)
                .log().body();

    }
    public String randomNationalityName() {
        return RandomStringUtils.randomAlphabetic(7);
    }

}
