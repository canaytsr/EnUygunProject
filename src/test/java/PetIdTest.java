import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PetIdTest {
    Pet pet;
    Response response;
    String pet_id;

    public PetIdTest() {
        baseURI = "https://petstore.swagger.io/v2"; //set base uri for api
        pet = new Pet();

        //getting valid ip from findByStatus api
        response = given()
                .header("Content-Type", "application/json")
                .pathParam("status", pet.getStatus())
                .when()
                .get(baseURI + "/pet" + "/findByStatus{status}")
                .then()
                .contentType(ContentType.JSON)
                .extract().response();


        //response id elements send the List
        List<?> elements = response.jsonPath().get("id");
        pet_id = elements.get(1).toString();

    }

    @Test
    @DisplayName("Post PetId Method RestAssured Test")//Set the test case name by DisplayName annotation
    public void Test1() {

        String new_name = "doggie";
        String new_status = "sold";

        Response response2 = given()
                .when()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .post(baseURI + "/pet/" + pet_id)
                .then()
                .extract().response();

        //Getting the JsonPath object instance from the Response interface
        JsonPath postJson = response2.jsonPath();

        Assertions.assertEquals(200, response2.getStatusCode());
        Assertions.assertEquals(pet_id.toString(), postJson.get("message").toString());

    }

    @Test
    @DisplayName("Post PetId Method Unirest Test")//Set the test case name by DisplayName annotation
    public void Test2() throws UnirestException {

        String new_name = "doggie";
        String new_status = "pending";

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> unirest_response =
                Unirest.post(baseURI + "/pet/" + pet_id)
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .field("name", new_name)
                        .field("status", new_status)
                        .asString();


        Assertions.assertEquals(200, unirest_response.getStatus());
        Assertions.assertTrue(unirest_response.getBody().contains(pet_id.toString()));

    }

    @Test
    @DisplayName("Delete PetId Method Test")//Set the test case name by DisplayName annotation
    public void Test3() throws UnirestException {

        Response response3 = given()
                .when()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .delete(baseURI + "/pet/" + pet_id)
                .then()
                .extract().response();

        //Getting the JsonPath object instance from the Response interface
        JsonPath postJson = response3.jsonPath();

        Assertions.assertEquals(200, response3.getStatusCode());
        Assertions.assertEquals(pet_id.toString(), postJson.get("message").toString());
        Assertions.assertEquals("200", postJson.get("code").toString());

    }

}
