package Campus;

import Campus.POJO_Models.Notification_Keys_Value;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Notation_Keys extends Hooks{

    public String randomName(){
        return RandomStringUtils.randomAlphabetic(8);
    }
    public String randomShortName(){
        return RandomStringUtils.randomAlphabetic(3);
    }

    Notification_Keys_Value notKeyVal;
    Response response;

    @Test
    public void createNotKeys(){
        notKeyVal = new Notification_Keys_Value();
        notKeyVal.setName(randomName());
        notKeyVal.setShortName(randomShortName());
        notKeyVal.setSchool("646cbb07acf2ee0d37c6d984");
        notKeyVal.setMultiplier(2);


        response =given()
                .spec(requestSpec)
                .body(notKeyVal)

                .when()
                .post("/school-service/api/timesheet-multiplier")

                .then()
                .spec(responseSpec)
                .statusCode(201)
                .extract().response();

    }

    @Test(dependsOnMethods = "createNotKeys", priority = 1)
    public void getNotKeys(){
        given()
                .spec(requestSpec)
                .pathParam("nKId",response.jsonPath().getString("id"))

                .when()
                .get("/school-service/api/timesheet-multiplier/{nKId}")

                .then()
                .spec(responseSpec)
                .statusCode(200);
    }

    @Test(dependsOnMethods = "createNotKeys", priority = 2)
    public void createNegative(){
        given()
                .spec(requestSpec)
                .body(notKeyVal)

                .when()
                .post("/school-service/api/timesheet-multiplier")

                .then()
                .spec(responseSpec)
                .statusCode(400);
    }

    @Test(dependsOnMethods = "createNotKeys",priority = 3)
    public void editeNotKeys(){
        notKeyVal.setName(randomName());
        notKeyVal.setShortName(randomShortName());
        notKeyVal.setId(response.jsonPath().getString("id"));

        given()
                .spec(requestSpec)
                .body(notKeyVal)

                .when()
                .put("/school-service/api/timesheet-multiplier")

                .then()
                .spec(responseSpec)
                .statusCode(200);
    }

    @Test(dependsOnMethods = "createNotKeys",priority = 4)
    public void deleteNotKeys(){
        given()
                .spec(requestSpec)
                .pathParam("nKId", response.jsonPath().getString("id"))

                .when()
                .delete("/school-service/api/timesheet-multiplier/{nKId}")

                .then()
                .statusCode(200);
    }

    @Test(dependsOnMethods = {"createNotKeys","deleteNotKeys"},priority = 5)
    public void getFieldsNegative(){
        given()
                .spec(requestSpec)
                .pathParam("nKId", response.jsonPath().getString("id"))

                .when()
                .get("/school-service/api/timesheet-multiplier/{nKId}")

                .then()
                .spec(responseSpec)
                .statusCode(400);

    }

    @Test(dependsOnMethods = {"createNotKeys","deleteNotKeys"}, priority = 6)
    public void deleteFieldsNegative(){

        given()
                .spec(requestSpec)
                .pathParam("nKId", response.jsonPath().getString("id"))

                .when()
                .delete("/school-service/api/timesheet-multiplier/{nKId}")

                .then()
                .spec(responseSpec)
                .statusCode(400);

    }
}
