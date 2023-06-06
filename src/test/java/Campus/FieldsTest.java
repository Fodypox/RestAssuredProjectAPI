package Campus;

import Campus.POJO_Models.Fields;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class  FieldsTest extends Hooks{
    public String randomFieldsName(){
        return RandomStringUtils.randomAlphabetic(6);
    }
    public String randomFieldsCode(){
        return RandomStringUtils.randomAlphabetic(3);
    }

    Fields fields;
    Response response;

    @Test
    public void createFields(){
       fields = new Fields();
       fields.setName(randomFieldsName());
       fields.setCode(randomFieldsCode());
       fields.setType("STRING");
       fields.setSchoolId("646cbb07acf2ee0d37c6d984");

       response =given()
               .spec(requestSpec)
               .body(fields)

               .when()
               .post("/school-service/api/entity-field")

               .then()
               .spec(responseSpec)
               .statusCode(201)
               .extract().response();

    }

    @Test(dependsOnMethods = "createFields", priority = 1)
    public void getFields(){
        given()
                .spec(requestSpec)
                .pathParam("fieldsId", response.jsonPath().getString("id"))

                .when()
                .get("/school-service/api/entity-field/{fieldsId}")

                .then()
                .spec(responseSpec)
                .statusCode(200);
    }

    @Test(dependsOnMethods = "createFields", priority = 2)
    public void createFieldsNegative(){
        given()
                .spec(requestSpec)
                .body(fields)

                .when()
                .post("/school-service/api/entity-field")

                .then()
                .spec(responseSpec)
                .statusCode(400);
    }

    @Test(dependsOnMethods = "createFields", priority = 3)
    public void editFields(){
        fields.setName(randomFieldsName());
        fields.setCode(randomFieldsCode());
        fields.setId(response.jsonPath().getString("id"));

        given()
                .spec(requestSpec)
                .body(fields)

                .when()
                .put("/school-service/api/entity-field")

                .then()
                .spec(responseSpec)
                .statusCode(200);

    }

    @Test(dependsOnMethods = "createFields", priority = 4)
    public void deleteFields(){

        given()
                .spec(requestSpec)
                .pathParam("fieldsId", response.jsonPath().getString("id"))

                .when()
                .delete("/school-service/api/entity-field/{fieldsId}")

                .then()
                .statusCode(204);
    }

    @Test(dependsOnMethods = {"createFields","deleteFields"},priority = 5)
    public void getFieldsNegative(){
        given()
                .spec(requestSpec)
                .pathParam("fieldsId", response.jsonPath().getString("id"))

                .when()
                .get("/school-service/api/entity-field/{fieldsId}")

                .then()
                .spec(responseSpec)
                .statusCode(400);

    }

    @Test(dependsOnMethods = {"createFields","deleteFields"}, priority = 6)
    public void deleteFieldsNegative(){

        given()
                .spec(requestSpec)
                .pathParam("fieldsId", response.jsonPath().getString("id"))

                .when()
                .delete("/school-service/api/entity-field/{fieldsId}")

                .then()
                .spec(responseSpec)
                .statusCode(400);

    }
}
