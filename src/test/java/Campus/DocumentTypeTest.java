package Campus;

import Campus.POJO_Models.Document;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class DocumentTypeTest extends Hooks {


    Document document;

    Response response;

    public String randomDocumentName() {
        return RandomStringUtils.randomAlphanumeric(2);
    }
    public String stageList(){
        Random random=new Random();
        int randomStage=random.nextInt(6);
        ArrayList<String> stageList=new ArrayList<>(Arrays.asList("Student Registration", "Examination","Employment","Certificate","Contract","Dismissal"));
        return stageList.get(randomStage);
    }


    @Test
    public void createNewDocument() {
        document = new Document();
        document.setName(randomDocumentName());
        document.setSchoolId("646cbb07acf2ee0d37c6d984");
        document.setAttachmentStage(stageList());
        response = given()
               //.spec(requestSpec)
                .body(document)
                .contentType(ContentType.JSON)
                .cookies(cookies)
                .when()
                .post("/school-service/api/attachments/create")
                .then()
                //.spec(responseSpec)
                .statusCode(200)
               .log().body()
                .extract().response();
    }



    @Test(dependsOnMethods ="createNewDocument",priority = 1)
    public void createDocumentNegative() {
        document.setName(response.jsonPath().getString("name"));
        given()
                .body(document)
                .contentType(ContentType.JSON)
                .cookies(cookies)
                .when()
                .post("/school-service/api/attachments/create")
                .then()
                .statusCode(400)
                .log().body()
                .extract().response();
    }

    @Test(dependsOnMethods ="createNewDocument",priority = 2)
    public void getDocument() {
        document.setName(response.jsonPath().getString("name"));
        given()
                .body(document)
                .contentType(ContentType.JSON)
                .cookies(cookies)
                .when()
                .post("/school-service/api/attachments/search")
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();
    }

    @Test(dependsOnMethods ="createNewDocument",priority = 3)
    public void updateDocument() {
        document.setName(randomDocumentName());
        document.setSchoolId("646cbb07acf2ee0d37c6d984");
        document.setId(response.jsonPath().getString("id"));
        given()
                .body(document)
                .contentType(ContentType.JSON)
                .cookies(cookies)
                .when()
                .post("/school-service/api/attachments/search")
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

    }

    @Test(dependsOnMethods ="createNewDocument",priority = 4)
    public void deleteDocument() {

        given()
                .pathParam("DocumentId",response.jsonPath().getString("id"))
                .cookies(cookies)
                .when()
                .delete("/school-service/api/attachments/{DocumentId}")
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

    }
    @Test(dependsOnMethods ={"createNewDocument","deleteDocument"},priority = 5)
    public void deleteDocumentNegative() {

        given()
                .pathParam("DocumentId",response.jsonPath().getString("id"))
                .cookies(cookies)
                .when()
                .delete("/school-service/api/attachments/{DocumentId}")
                .then()
                .statusCode(400)
                .log().body()
                .extract().response();

    }
    @Test(dependsOnMethods ={"createNewDocument","deleteDocument"},priority = 6)
    public void getDocumentAfterDeleteDocument() {
    document.setName(response.jsonPath().getString("name"));
        given()
                .body(document)
                .cookies(cookies)
                .when()
                .post("/school-service/api/attachments/search")
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

    }

}

