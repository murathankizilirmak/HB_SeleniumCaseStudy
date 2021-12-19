package TestCases.API;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
//import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

//import org.testng.annotations.Test;

public class PetCrud
{
    @Test //(priority=1)
    public void addNewPet()
    {
        Map<String,Object> data=new HashMap<>();
        data.put("id" , 3);
        data.put("name","new pet");
        data.put("status","available");
        Response res =
                given()
                        .contentType(JSON)
                        .accept("application/json")
                        .body(data)
                        .when()
                        .post("https://petstore.swagger.io/v2/pet")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .extract().response();
        String jsonString= res.asString();
        Assert.assertEquals(jsonString.contains("new pet"),true);
    }

    @Test
    public void getPetInfo()
    {
        Response res =
                given()
                        .when()
                        .get("https://petstore.swagger.io/v2/pet/3")
                        .then()
                        .statusCode(200)
                        .extract().response();
        String jsonString = res.asString();
        Assert.assertEquals(jsonString.contains("new pet"),true);
    }

    @Test
    public void deletePet()
    {
        Map<String,Object> data=new HashMap<>();
        Response res =
                given()
                        .contentType(JSON)
                        .accept("application/json")
                        .when()
                        .delete("https://petstore.swagger.io/v2/pet/3")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .extract().response();
        String jsonString= res.asString();
        Assert.assertEquals(jsonString.contains("unknown"),true);
    }
    @Test
    public void updatePet()
    {
        Map<String,Object> data=new HashMap<>();
        data.put("id" , 3);
        data.put("name","new pet update");
        data.put("status","available");
        Response res =
                given()
                        .contentType(JSON)
                        .accept("application/json")
                        .body(data)
                        .when()
                        .post("https://petstore.swagger.io/v2/pet")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .extract().response();
        String jsonString= res.asString();
        Assert.assertEquals(jsonString.contains("new pet update"),true);
    }

}
