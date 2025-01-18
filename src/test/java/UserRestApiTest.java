import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class UserRestApiTest {

    @Test
    public void CreateUser() {
        String bodyPayload = "{\n" +
                "  \"id\": 1,\n" +
                "  \"username\": \"siyah.0699\",\n" +
                "  \"firstName\": \"siyah\",\n" +
                "  \"lastName\": \"0699\",\n" +
                "  \"email\": \"siyah.0699@hotmail.com\",\n" +
                "  \"password\": \"Siyah.0699\",\n" +
                "  \"phone\": \"05555555555\",\n" +
                "  \"userStatus\": 1\n" +
                "}";
        RestAssured.given().body(bodyPayload).contentType(ContentType.JSON).when().post("https://petstore.swagger.io/v2/user");
    }

    @Test
    public void GetUser() {
        RestAssured.given().contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/siyah.0699");
    }

    @Test
    public void UpdateUser() {
        String bodyPayload = "{\n" +
                "  \"id\": 1,\n" +
                "  \"username\": \"siyah.9999\",\n" +
                "  \"firstName\": \"siyah\",\n" +
                "  \"lastName\": \"9999\",\n" +
                "  \"email\": \"siyah.0699@hotmail.com\",\n" +
                "  \"password\": \"Siyah.0699\",\n" +
                "  \"phone\": \"05555555555\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        RestAssured.given().body(bodyPayload).contentType(ContentType.JSON).when().put("https://petstore.swagger.io/v2/user/siyah.0699");
    }

    @Test
    public void DeleteUser(){
        RestAssured.given().contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/siyah.0699");
    }

    @Test
    public void UserLogin(){
        Map<String,Object> queryParamsMap = new HashMap<>();
        queryParamsMap.put("username","siyah.0699");
        queryParamsMap.put("password","Siyah.0699");
        RestAssured.given().contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/login");
    }

    @Test
    public void UserLogout(){
        RestAssured.get("https://petstore.swagger.io/v2/user/logout");
    }
}

