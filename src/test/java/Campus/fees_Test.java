package Campus;

import Campus.Hooks;
import Campus.POJO_Models.Fees;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class fees_Test extends Hooks {

    public String randomFeesName() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public String randomFeesCode() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomIntegrationCode() {
        return RandomStringUtils.randomAlphabetic(3);
    }

    public int randomPriority() {
        return Integer.parseInt(RandomStringUtils.randomNumeric(3));
    }



    Response response;
    Fees fees;

    @Test
    public void createFee() {

        fees = new Fees();


//            fees.getId();
//            fees.getIntegrationCode("char");
//            fees.getName(randomFeesName());
//            fees.getCode(randomFeesCode());
//            fees.getPriority(120);
//            fees.isActive(true);
//            fees.getTranslateName();
        fees.setActive(true);
        fees.setBudgetAccountIntegrationCode(randomIntegrationCode());
        fees.setCode(randomFeesCode());
        fees.setName(randomFeesName());
        fees.setPriority(randomPriority());

            response = given()
                    .contentType(ContentType.JSON)
                    .spec(requestSpec)
                    .body(fees)

                    .when()
                    .post("/school-service/api/fee-types")

                    .then()
                    .statusCode(201)
                    .log().body()
                    .spec(responseSpec)
                    .extract().response();
        }

        @Test(priority = 1, dependsOnMethods = "createFee")

        public void createNegativeTest() {

           fees = new Fees();

           response=  given()
                    .spec(requestSpec)
                    .body(fees)

                   .when()
                    .post("/school-service/api/fee-types")

                    .then()
                    .spec(responseSpec)
                    .statusCode(400)
                   .extract().response();


        }
        @Test(priority = 2)
    public void editFeesTest(){

            fees.getId();
//            fees.setIntegrationCode("12");
            fees.setName(randomFeesName());
            fees.setCode(randomFeesCode());
            fees.setPriority(110);
            fees.isActive(true);
            fees.getTranslateName();


            given()
                    .spec(requestSpec)
                    .body(fees)
                    .when()
                    .put("/school-service/api/fee-types")
                    .then()
                    .spec(responseSpec)
                    .statusCode(200);

    }

    @Test(priority = 3)
    public void deleteFees(){
        fees.getId("647ec8ab873f2e44790378a3");
//        fees.setIntegrationCode("memis");
        fees.setName(randomFeesName());
        fees.setCode(randomFeesCode());
        fees.setPriority(110);
        fees.isActive(true);
        fees.getTranslateName();

        given()
                .spec(requestSpec)
                .pathParam("feeId",response.jsonPath().getString("id"))
                .delete("/school-service/api/fee-types/feeId")
                .then()
                .statusCode(200);
    }
@Test(priority = 4)
    public void searchTest(){
        fees.getPriority(1110);
        fees.getName(randomFeesName());
        fees.getCode(randomFeesCode());

        given()
                .spec(requestSpec)
                .body(fees)
                .when()
                .post("/school-service/api/fee-types/search")
                .then()
                .spec(responseSpec)
                .statusCode(200);

}

    }



