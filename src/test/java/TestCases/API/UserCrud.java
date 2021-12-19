package TestCases.API;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedHashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UserCrud {
    @Test
    public void userCreate() {
        Map<String, Object> data = new LinkedHashMap<>();

        data.put("username", "Mahmut");
        data.put("lastName", "Can");
        data.put("email", "Mahmut.can@mail.com");
        data.put("password", "Cevval");
        data.put("phone", "5555555");
        data.put("userStatus", "0");
        Response res =
                given()
                        .contentType(JSON)
                        .accept("application/json")
                        .body(data)
                        .when()
                        .post("https://petstore.swagger.io/v2/user")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .extract().response();
        String jsonString = res.asString();
        Assert.assertNotEquals(jsonString.compareTo("message"), null);
    }

    @Test
    public void userLogin() {
        Map<String, Object> data = new LinkedHashMap<>();
        Response res =
                given()
                        .contentType(JSON)
                        .accept("application/json")
                        .body(data)
                        .when()
                        .get("https://petstore.swagger.io/v2/user/login?username=Mahmut&password=Cevval")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .extract().response();
        String jsonString = res.asString();
        Assert.assertEquals(jsonString.contains("logged in user session"), true);
    }

    @Test
    public void userDelete() {
        Map<String, Object> data = new LinkedHashMap<>();
        Response res =
                given()
                        .contentType(JSON)
                        .accept("application/json")
                        .body(data)
                        .when()
                        .delete("https://petstore.swagger.io/v2/user/Mahmut")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .extract().response();
        String jsonString = res.asString();
        Assert.assertEquals(jsonString.contains("Mahmut"), true);
    }
}
