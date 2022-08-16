import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ApiTest {
    Grocery grocery;
    Response response;

    //create object mapper for serialization/deserialization Json Object
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ApiTest() {
        baseURI = "https://3geog.mocklab.io"; //set base uri for api
        grocery = new Grocery();
    }

    //Create test case by test annotation
    @Test
    @DisplayName("Get allGrocery Method Test")//Set the test case name by DisplayName annotation
    public void Test1() {

        //RestAssured class to start creating response specifications with when() and then() methods
        response = given().header("Content-Type", "application/json")
                .when()
                .get(baseURI + "/allGrocery")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        //Getting the JsonPath object instance from the Response interface and assign to list
        List<?> response_list = response.getBody().jsonPath().getList("data");

        //Controlling whether the response body(from list) is null or not
        Assertions.assertNotNull(response_list.toString());

        //Checking if the value of the field titled id of the first element in the list is 1 or not
        Assertions.assertEquals(((LinkedHashMap) response_list.get(0)).get("id"), 1);
        //Checking if the value of the field titled id of the second element in the list is 2 or not
        Assertions.assertEquals(((LinkedHashMap) response_list.get(1)).get("id"), 2);

        //Checking if the value of the field titled name of the first element in the list is apple or not
        Assertions.assertEquals(((LinkedHashMap) response_list.get(0)).get("name"), "apple");
        //Checking if the value of the field titled name of the second element in the list is grapes or not
        Assertions.assertEquals(((LinkedHashMap) response_list.get(1)).get("name"), "grapes");

        //Checking if the value of the field titled price of the first element in the list is 3 or not
        Assertions.assertEquals(((LinkedHashMap) response_list.get(0)).get("price"), 3);
        //Checking if the value of the field titled price of the second element in the list is 5 or not
        Assertions.assertEquals(((LinkedHashMap) response_list.get(1)).get("price"), 5);

        //Checking if the value of the field titled stock of the first element in the list is 100 or not
        Assertions.assertEquals(((LinkedHashMap) response_list.get(0)).get("stock"), 100);
        //Checking if the value of the field titled stock of the second element in the list is 50 or not
        Assertions.assertEquals(((LinkedHashMap) response_list.get(1)).get("stock"), 50);

    }

    //Create test case by test annotation
    @Test
    @DisplayName("Get allGrocery/{name} Method Test")//Set the test case name by DisplayName annotation
    public void Test2() {

        //RestAssured class to start creating response specifications with when() and then() methods
        response = given()
                .header("Content-Type", "application/json")
                .pathParam("name", "apple")
                .when()
                .get(baseURI + "/allGrocery/{name}")
                .then()
                .statusCode(200)
                .extract().response();

        //Getting the JsonPath object instance from the Response interface and assign to list
        JsonPath getJson = response.getBody().jsonPath();
        List<?> response_list2 = getJson.getList("data");

        //Controlling whether the response body is null or not
        Assertions.assertNotNull(response_list2.get(0));

        //Controlling the value of the id is 1 or not
        Assertions.assertEquals(((LinkedHashMap) response_list2.get(0)).get("id"), 1);
        //Controlling the value of the element name apple or not
        Assertions.assertEquals(((LinkedHashMap) response_list2.get(0)).get("name"), "apple");
        //Controlling the value of the element price is 3 or not
        Assertions.assertEquals(((LinkedHashMap) response_list2.get(0)).get("price"), 3);
        //Controlling the value of the element stock is 100 or not
        Assertions.assertEquals(((LinkedHashMap) response_list2.get(0)).get("stock"), 100);

    }

    //Create test case by test annotation
    @Test
    @DisplayName("Post Grocery/add Method Test")//Set the test case name by DisplayName annotation
    public void Test3() throws JsonProcessingException {

        //Assigning the elements of the grocery object
        grocery.setId(4);
        grocery.setName("string");
        grocery.setPrice(12.3);
        grocery.setStock(3);

        //Converting the Object to JSONString
        String jsonString = objectMapper.writeValueAsString(grocery);

        //RestAssured class to start creating response specifications with when() and then() methods
        response = given()
                .header("Content-Type", "application/json")
                .body(jsonString)
                .when()
                .post(baseURI + "/add")
                .then()
                .extract().response();

        //Controlling whether the response content type is the same as "application/json"
        Assertions.assertEquals("application/json", response.getContentType());
        //Checking if the response body content is equal to "Adding Successful!"
        Assertions.assertEquals("Adding Successful!", response.asString());
        //Validate the response status codes
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertNotEquals(400, response.statusCode());
        Assertions.assertNotEquals(404, response.statusCode());

    }

}
