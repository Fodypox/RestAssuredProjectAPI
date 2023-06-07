package Campus;

import Campus.POJO_Models.Discounts;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DiscountTest extends Hooks{

    Discounts discounts;

    Response response;

    public String randomDiscountDescription() {return RandomStringUtils.randomAlphabetic(6);}

    public String randomDiscountCode() {return RandomStringUtils.randomAlphabetic(2);}



    /** Validate create new Discount under Setup Parameters */
    @Test(priority = 1)
    public void createDiscount(){

        discounts = new Discounts();
        discounts.setDescription(randomDiscountDescription());
        discounts.setCode(randomDiscountCode());

        response = given()
                .spec(requestSpec)
                .body(discounts)
                .when()
                .post("/school-service/api/discounts")
                .then()
                .statusCode(201)
                .spec(responseSpec)
                .extract().response();

    }

    /** Validate create new Discount under Setup Parameters as negatively */
    @Test( priority = 2)
    public void createDiscountNegativeTest(){
        discounts.setDescription(response.jsonPath().getString("description"));
        given()
                .spec(requestSpec)
                .body(discounts)


                .when()
                .post("/school-service/api/discounts")

                .then()
                .statusCode(400)
                .spec(responseSpec)
                .extract().response();

    }

    /** Validate edit Discount under Setup Parameters */

    @Test( priority = 3)
    public void editDiscount(){
        discounts.setDescription(randomDiscountDescription());
        discounts.setCode("yattara");
        discounts.setId(response.jsonPath().getString("id"));

        given()
                .spec(requestSpec)
                .body(discounts)
                .contentType(ContentType.JSON)


                .when()
                .put("/school-service/api/discounts")

                .then()
                .statusCode(200)
                .spec(responseSpec)
                .extract().response();
    }

    /** Validate delete Discount under Setup Parameters */
    @Test( priority = 4)
    public void deleteDiscount(){


        given()
                .spec(requestSpec)
                .pathParam("discountsId", response.jsonPath().getString("id"))

                .when()
                .delete("/school-service/api/discounts/{discountsId}")

                .then()
                .statusCode(200);

    }

    /** Delete discount as negatively **/

    @Test( priority = 5)
    public void deleteDiscountNegativeTest(){
        given()
                .spec(requestSpec)
                .pathParam("discountId", response.jsonPath().getString("id"))
                .when()


                .delete("/school-service/api/discounts/{discountId}")

                .then()
                .statusCode(400)
                .extract().response();

    }
}


