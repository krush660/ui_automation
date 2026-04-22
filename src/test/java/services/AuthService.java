import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthService {

    public static Response login(String username, String password) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}")
                .post("https://dummyjson.com/auth/login");
    }
}