package Campus;

import Campus.POJO_Models.Citizenship;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CitizenshipTest extends Hooks{
    public String randomCitizenshipName(){
        return RandomStringUtils.randomAlphabetic(6);
    }

    public String randomCitizenshipShortName(){
        return RandomStringUtils.randomAlphabetic(3);
    }

    Response response;
    Citizenship citizenship;

    @Test
    public void createCitizenship(){
        citizenship = new Citizenship();
        citizenship.setName(randomCitizenshipName());
        citizenship.setShortName(randomCitizenshipShortName());

        response = given()
                .spec(requestSpec)
                .body(citizenship)
                .contentType(ContentType.JSON)
                .cookies(cookies)

                .when()
                .post("/school-service/api/citizenships")

                .then()
                .statusCode(201)
                .spec(responseSpec)
                .log().body()
                .extract().response();
    }

    @Test(dependsOnMethods = "createCitizenship", priority = 1)
    public void createCitizenshipWithSameName(){
        given()
                .spec(requestSpec)
                .body(citizenship)
                .contentType(ContentType.JSON)
                .cookies(cookies)

                .when()
                .post("/school-service/api/citizenships")

                .then()
                .statusCode(400)
                .spec(responseSpec)
                .extract().response();
    }

    @Test(dependsOnMethods = "createCitizenship", priority = 2)
    public void updateCitizenship(){
        citizenship.setId(response.jsonPath().getString("id"));
        citizenship.setName((randomCitizenshipName()));
        citizenship.setShortName(randomCitizenshipShortName());

        given()
                .spec(requestSpec)
                .body(citizenship)
                .contentType(ContentType.JSON)
                .cookies(cookies)
                .when()
                .put("/school-service/api/citizenships")
                .then()
                .statusCode(200)
                .spec(responseSpec)
                .extract().response();
    }

    @Test(dependsOnMethods = "createCitizenship", priority = 3)
    public void deleteCitizenship(){
        given()
                .spec(requestSpec)
                .cookies(cookies)
                .pathParam("citizenshipId", response.jsonPath().getString("id"))
                .when()
                .delete("/school-service/api/citizenships/{citizenshipId}")
                .then()
                .statusCode(200);
    }

    @Test(dependsOnMethods = {"createCitizenship", "deleteCitizenship"}, priority = 4)
    public void deleteCitizenshipAlreadyDeleted(){
        given()
                .spec(requestSpec)
                .cookies(cookies)
                .pathParam("citizenshipId", response.jsonPath().getString("id"))
                .when()
                .delete("/school-service/api/citizenships/{citizenshipId}")
                .then()
                .statusCode(400);
    }
}
