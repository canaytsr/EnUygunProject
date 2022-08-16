import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RestAssuredTest {
    Pet pet;
    Response response;

    private final ObjectMapper objectMapper = new ObjectMapper();
    //create object mapper for serialization/deserialization Json Object

    public RestAssuredTest() {
        baseURI = "https://petstore.swagger.io/v2"; //set base uri for api
        pet = new Pet();
    }

    @Test
    @DisplayName("Get Method For Status Code Available By Using RestAssured")//Set the test case name by DisplayName annotation
    public void Test1() throws JsonProcessingException {

        //Assigning the elements of the pet object
        pet.setPetId(7);
        pet.setStatus("available");

        //Converting the Object to JSONString
        String jsonString = objectMapper.writeValueAsString(pet);

        //RestAssured class to start creating response specifications with when() and then() methods
        response = given()
                .header("Content-Type", "application/json")
                .queryParam("status", pet.getStatus())
                .when()
                .get(baseURI + "/pet" + "/findByStatus{status}")
                .then()
                .contentType(ContentType.JSON)
                .extract().response();

        //Getting the JsonPath object instance from the Response interface
        JsonPath postJson = response.jsonPath();

        //Controlling whether the response body is not null
        Assertions.assertNotNull(response.getBody().asString());
        //Node queries the JsonPath object for the String value.
        Assertions.assertEquals(true, postJson.get("name").toString().contains("doggie"));
        //Controlling whether the response body status code is not null
        Assertions.assertNotNull(postJson.get("status").toString().contains(pet.getStatus()));
        //Validate the response
        Assertions.assertNotNull(postJson.get("petId"));
    }

    @Test
    @DisplayName("Get Method For Status Code Pending By Using RestAssured")//Set the test case name by DisplayName annotation
    public void Test2() throws JsonProcessingException {

        //Assigning the elements of the pet object
        pet.setPetId(8);
        pet.setStatus("pending");

        //Converting the Object to JSONString
        String jsonString = objectMapper.writeValueAsString(pet);

        //RestAssured class to start creating response specifications with when() and then() methods
        response = given()
                .header("Content-Type", "application/json")
                .queryParams("status", pet.getStatus())
                .when()
                .get(baseURI + "/pet" + "/findByStatus{status}")
                .then()
                .contentType(ContentType.JSON)
                .extract().response();

        //Getting the JsonPath object instance from the Response interface
        JsonPath getJson = response.jsonPath();

        //Controlling whether the response body is not null
        Assertions.assertNotNull(response.getBody().asString());
        //Node queries the JsonPath object for the String value.
        Assertions.assertTrue(getJson.get("name").toString().length() > 0);
        //Controlling whether the response body status code is not null
        Assertions.assertNotNull(getJson.get("status").toString().contains(pet.getStatus()));
        //Validate the response
        Assertions.assertNotNull(getJson.get("petId"));
    }

    @Test
    @DisplayName("Get Method For Status Code Sold By Using RestAssured")//Set the test case name by DisplayName annotation
    public void Test3() throws JsonProcessingException {

        //Assigning the elements of the pet object
        pet.setStatus("sold");

        //Converting the Object to JSONString
        String jsonString = objectMapper.writeValueAsString(pet);

        //RestAssured class to start creating response specifications with when() and then() methods
        response = given()
                .header("Content-Type", "application/json")
                .queryParam("status", pet.getStatus())
                .when()
                .get(baseURI + "/pet" + "/findByStatus{status}")
                .then()
                .contentType(ContentType.JSON)
                .extract().response();

        //Getting the JsonPath object instance from the Response interface
        JsonPath getJson = response.jsonPath();

        //Controlling whether the response body is not null
        Assertions.assertNotNull(response.getBody().asString());
        //Controlling whether the response body status code is not null
        Assertions.assertNotNull(getJson.get("status").toString().contains(pet.getStatus()));
        //Validate the response
        Assertions.assertNotNull(getJson.get("petId"));
        //Check if the response status code is 200
        Assertions.assertEquals(200, response.statusCode());
    }

}