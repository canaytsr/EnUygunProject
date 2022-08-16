import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

public class GetPetIdForFindByStatus {
    Pet pet;
    Response response;

    private final ObjectMapper objectMapper = new ObjectMapper();
    //create object mapper for serialization/deserialization Json Object

    public GetPetIdForFindByStatus() {
        baseURI = "https://petstore.swagger.io/v2"; //set base uri for api
        pet = new Pet();
    }

    @Test
    @DisplayName("Find Status by  using get PetId api result")//Set the test case name by DisplayName annotation
    public void Test1() throws JsonProcessingException {

        //Assign object
        pet.setPetId(15);
        pet.setName("name_pet");
        pet.setStatus("available");

        //RestAssured class to start creating response specifications with when() and then() methods
        response = given()
                .header("Content-Type", "application/json")
                .queryParams("status", pet.getStatus())
                .when()
                .get(baseURI + "/pet" +"/findByStatus")
                .then()
                .contentType(ContentType.JSON)
                .extract().response();

        //reponse id elements send the List
        List<?> elements = response.jsonPath().get("id");

        //get the third element of the list and assign to s;
        String s = elements.get(2).toString();

        Response response2 = given()
                .param("petId", s)
                .when()
                .get(baseURI + "/pet" + "/" + s)
                .then()
                .contentType(ContentType.JSON)
                .extract().response();

         //response status control
        Assertions.assertEquals(200, response2.getStatusCode());
        //Is that equals response id and selection id(string s)
        Assertions.assertEquals(s, response2.getBody().jsonPath().get("id").toString());

    }

}
