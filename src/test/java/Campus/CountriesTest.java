package Campus;


import Campus.POJO_Models.Countries;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.*;

//import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.*;

public class CountriesTest extends Hooks {

    // some test nor run properly!!!!


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
    public void createWithSameCountriesName() {
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

    @Test(priority = 3)
    public void getCountries() {
        given()
                .spec(requestSpec)
                .pathParam("countriesId", response.jsonPath().getString("id"))
//                .body(countries)  no need!
                .when()
                .get("/school-service/api/countries/{countriesId}")  // HOW WE GET?? {countriesId}  and  ///school-service/api/countries
                .then()
                .statusCode(200)
                .spec(responseSpec)
                .extract().response();
    }

    @Test(priority = 4)
    public void editCountries() {
        countries.setName(randomCountriesName());
        countries.setCode(randomCountriesCode());
        countries.setId(response.jsonPath().getString("id"));
        given()
                .spec(requestSpec)
                .body(countries)  //no need!
                .when()
                .put("/school-service/api/countries")  // HOW WE GET?? {countriesId}  and  ///school-service/api/countries
                .then()
                .statusCode(200)
                .spec(responseSpec)
                .extract().response();
    }

    @Test(priority = 5)
    public void deleteCountries() {
        given()
                .spec(requestSpec)
                .pathParam("countriesId", response.jsonPath().getString("id"))
                //.body(countries)  //no need!
                .when()
                .delete("/school-service/api/countries/{countriesId}")  // HOW WE GET?? {countriesId}  and  ///school-service/api/countries
                .then()
                .statusCode(200)
//                .spec(responseSpec)      // thats the mistake here!
                .extract().response();
    }

    @Test(priority = 6)
    public void getCountriesNegativeTest() {
        given()
                .spec(requestSpec)
                .pathParam("countriesId", response.jsonPath().getString("id"))
                .when()
                .get("/school-service/api/countries/{countriesId}")
                .then()
                .statusCode(400)
                .spec(responseSpec)
                .extract().response();
    }

    @Test(priority = 7)
    public void deleteCountriesAfterDeleted() {
        given()
                .spec(requestSpec)
                .pathParam("countriesId", response.jsonPath().getString("id"))
                .when()
                .delete("/school-service/api/countries/{countriesId}")
                .then()
                .statusCode(400)
                .extract().response();

    }
}