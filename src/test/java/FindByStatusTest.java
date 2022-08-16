import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.response.Response;
import model.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;

public class FindByStatusTest {
    Pet pet;
    Response response;
    private final ObjectMapper objectMapper = new ObjectMapper();
    //create object mapper for serialization/deserialization Json Object

    public FindByStatusTest() {
        baseURI = "https://petstore.swagger.io/v2"; //set base uri for api
        pet = new Pet();
    }

    //Create test case by test annotation
    @Test
    @DisplayName("Get Method For Status Available")//Create Test Name
    public void Test1() throws UnirestException, JsonProcessingException {

        //Assigning the elements of the pet object
        pet.setPetId(1);
        pet.setStatus("available");

        //Converting the Object to JSONString
        String jsonString = objectMapper.writeValueAsString(pet);

        //Unirest is a lightweight HTTP client library from Mashape
        Unirest.setTimeouts(0, 0);

        HttpResponse<String> response = Unirest.get(baseURI + "/pet" + "/findByStatus?status=" + pet.getStatus())
                .asString();

        //Checks response is 200
        Assertions.assertEquals(200, response.getStatus());
        //Checks response body include status code(available)
        Assertions.assertEquals(true, response.getBody().contains("available"));
    }

    //Create test case by test annotation
    @Test
    @DisplayName("Get Method For Status Pending")//Create Test Name
    public void Test2() throws UnirestException, JsonProcessingException {

        //Assigning the elements of the pet object
        pet.setPetId(2);
        pet.setStatus("pending");

        //Converting the Object to JSONString
        String jsonString = objectMapper.writeValueAsString(pet);

        //Unirest is a lightweight HTTP client library from Mashape
        Unirest.setTimeouts(0, 0);

        HttpResponse<String> response = Unirest.get(baseURI + "/pet" + "/findByStatus?status=" + pet.getStatus())
                .asString();


        //Checks response is 200
        Assertions.assertEquals(200, response.getStatus());
        //Checks response body include status code(pending)
        Assertions.assertEquals(true, response.getBody().contains("pending"));
    }

    //Create test case by test annotation
    @Test
    @DisplayName("Get Method For Status Sold")//Create Test Name
    public void Test3() throws UnirestException, JsonProcessingException {

        //Assigning the elements of the pet object
        pet.setPetId(3);
        pet.setStatus("available");


        //Converting the Object to JSONString
        String jsonString = objectMapper.writeValueAsString(pet);

        //Unirest is a lightweight HTTP client library from Mashape
        Unirest.setTimeouts(0, 0);

        HttpResponse<String> response = Unirest.get(baseURI + "/pet" + "/findByStatus?status=" + pet.getStatus())
                .asString();

        //Checks response is 200
        Assertions.assertEquals(200, response.getStatus());
        //Checks response body include status code(sold)
        Assertions.assertEquals(true, response.getBody().contains("available"));
    }
    @Test
    @DisplayName("Get Method By Using Json Body")//Create Test Name
    public void Test4() throws UnirestException {

        //Assigning the elements of the pet object
        pet.setPetId(4);
        pet.setStatus("sold");

        //Unirest is a lightweight HTTP client library from Mashape
        Unirest.setTimeouts(0, 0);

        //HttpResponse describes the result of an HttpRequest call and get HTTP response body as a JsonNode
        HttpResponse<JsonNode> response = Unirest.get(baseURI + "/pet" + "/findByStatus?status=" + pet.getStatus())
                .asJson();

        //Check if the response status code is 200
        Assertions.assertEquals(200, response.getStatus());
        //Checking response status title is valid or not
        Assertions.assertTrue(response.getBody().toString().contains("sold"));

    }

}