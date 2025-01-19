import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

public class UserRestApiTest {

    @Test(description ="Kullanıcı oluşturuldu")
    @Step("siyah.0699 adlı kullanıcı oluşturuldu")
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

    @Test(description ="Kullanıcı çağrıldı")
    @Step("siyah.0699 adlı kullanıcı çağrıldı")
    public void GetUser() {
        RestAssured.given().contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/siyah.0699");
    }

    @Test(description ="Kullanıcı güncellendi")
    @Step("siyah.0699 adlı kullanıcı siyah.9999 olarak güncellendi")
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

    @Test(description ="Güncellemeden sonra kullanıcı doğrulandı")
    public void VerifyUpdatedUser() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/user/siyah.9999")
                .then()
                .statusCode(200);
    }

    @Test(description ="Kullanıcı silindi")
    @Step("siyah.9999 adlı kullanıcı silindi")
    public void DeleteUser(){
        RestAssured.given().contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/siyah.9999");
    }

    @Test(description ="Kullanıcı girişi gerçekleşti")
    @Step("siyah.0699 adlı kullanıcı giriş yaptı")
    public void UserLogin(){
        Map<String,Object> queryParamsMap = new HashMap<>();
        queryParamsMap.put("username","siyah.0699");
        queryParamsMap.put("password","Siyah.0699");
        RestAssured.given().contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/login");
    }

    @Test(description ="Kullanıcı çıkışı gerçekleşti")
    @Step("siyah.0699 adlı kullanıcı çıkış yaptı")
    public void UserLogout(){
        RestAssured.get("https://petstore.swagger.io/v2/user/logout");
    }
}

