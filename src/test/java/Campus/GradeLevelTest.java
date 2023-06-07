package Campus;

import Campus.POJO_Models.GradeLevel;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.random.RandomGenerator;

import static io.restassured.RestAssured.given;

public class GradeLevelTest extends Hooks{

    public String randomName(){
        return RandomStringUtils.randomAlphabetic(7);
    }
    public String randomShortName(){
        return RandomStringUtils.randomAlphabetic(3);
    }
    public int randomOrderNumber(){int randomNumber= Integer.parseInt(RandomStringUtils.randomNumeric(2));
        return randomNumber;}
    GradeLevel gradeLevel;
    Response response;

    @Test(priority = 1)
    public void createGradeLevel(){
        gradeLevel=new GradeLevel();
        gradeLevel.setName(randomName());
        gradeLevel.setShortName(randomShortName());
        gradeLevel.setOrder(randomOrderNumber());
        gradeLevel.setMaxApplicationCount(randomOrderNumber());

        response =given()
                .spec(requestSpec)
                .body(gradeLevel)

                .when()
                .post("/school-service/api/grade-levels")

                .then()
                .spec(responseSpec)
                .statusCode(201)
                .extract().response();

    }
    @Test(priority = 2)
    public void createNegativeGradeLevel(){
        given()
                .spec(requestSpec)
                .body(gradeLevel)

                .when()
                .post("/school-service/api/grade-levels")

                .then()
                .spec(responseSpec)
                .statusCode(400);
    }
    @Test(priority = 3)
    public void editGradeLevel(){
        gradeLevel.setName(randomName());
        gradeLevel.setShortName(randomShortName());
        gradeLevel.setId(response.jsonPath().getString("id"));

        given()
                .spec(requestSpec)
                .body(gradeLevel)

                .when()
                .put("/school-service/api/grade-levels")

                .then()
                .spec(responseSpec)
                .statusCode(200);
    }
    @Test(priority = 4)
    public void deleteGradeLevel(){

        given()
                .spec(requestSpec)
                .pathParam("gradeLevelId", response.jsonPath().getString("id"))

                .when()
                .delete("/school-service/api/grade-levels/{gradeLevelId}")

                .then()
                .statusCode(200);
    }
    @Test(priority = 5)
    public void deleteNegativeGradeLevel(){
        given()
                .spec(requestSpec)
                .pathParam("gradeLevelId", response.jsonPath().getString("id"))

                .when()
                .delete("/school-service/api/grade-levels/{gradeLevelId}")

                .then()
                .statusCode(400);

    }
}
