package Campus;


import Campus.POJO_Models.Countries;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class CountriesTest extends Hooks {


    public String randomCountriesName() {
        return RandomStringUtils.randomAlphabetic(6);
    }

    public String randomCountriesCode() {
        return RandomStringUtils.randomAlphabetic(3);
    }

    Countries countries;
    Response response;

    @Test(priority = 1)
    public void createCountries() {
        countries = new Countries();
        countries.setName(randomCountriesName());
        countries.setCode(randomCountriesCode());

        response = given()
                .spec(requestSpec)
                .body(countries)
                .when()
                .post("/school-service/api/countries")  ///school-service/api/countries
                .then()
                .statusCode(201)
                .spec(responseSpec)
                .extract().response();
    }

    @Test(priority = 2)
    public void createWithSameCountriesName(){
        //  /school-service/api/countries
        countries.setName(response.jsonPath().getString("name"));
        given()
                .spec(requestSpec)
                .body(countries)
                .when()
                .post("/school-service/api/countries")  ///school-service/api/countries
                .then()
                .statusCode(400)
                .spec(responseSpec)
                .extract().response();
    }


}
