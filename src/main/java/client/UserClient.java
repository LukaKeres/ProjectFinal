package client;

import io.restassured.response.Response;
import model.User;
import utils.RequestSpecFactory;

import static io.restassured.RestAssured.given;

public class UserClient {
    public Response verifyLogin(String email, String password) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post("/api/verifyLogin");
    }

    public Response verifyLoginWithoutEmail(String password) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .formParam("password", password)
                .when()
                .post("/api/verifyLogin");
    }

    public Response deleteVerifyLogin(String email, String password) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .delete("/api/verifyLogin");
    }
    public Response getUserByEmail(String email) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .queryParam("email", email)
                .when()
                .get("/api/getUserDetailByEmail");
    }
}
