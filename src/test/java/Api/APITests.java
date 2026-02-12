package Api;

import client.ProductClient;
import client.UserClient;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class APITests {
    private final ProductClient productClient = new ProductClient();
    private final UserClient userClient = new UserClient();

    @Test
    @Feature("API")
    @Story("API Testing")
    public void getAllProductsList() {
        Response response = productClient.getAllProducts();
        response.then()
                .statusCode(200)
                .body("products", not(empty()));
        System.out.println(response.jsonPath().prettify());
    }
    @Test
    @Feature("API")
    @Story("API Testing")
    public void postToAllProductsList() {
        Response response = productClient.postAllProducts();
        response.then()
                .statusCode(200)
                .log().all();
        Assert.assertEquals(response.jsonPath().getInt("responseCode"),405);
        Assert.assertEquals(response.jsonPath().getString("message"), "This request method is not supported.");
    }
    @Test
    @Feature("API")
    @Story("API Testing")
    public void getAllBrandsList() {
        Response response = productClient.getAllBrands();
        response.then()
                .statusCode(200)
                .body("brands", not(empty()));
        System.out.println(response.jsonPath().prettify());

    }
    @Test
    @Feature("API")
    @Story("API Testing")
    public void putToAllProductsList() {
        Response response = productClient.putAllBrands();
        response.then()
                .statusCode(200)
                .log().all();


        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 405);
        Assert.assertEquals(response.jsonPath().getString("message"), "This request method is not supported.");
    }
    @Test
    @Feature("API")
    @Story("API Testing")
    public void searchProduct() {
        Response response = productClient.searchProduct("tshirt");
        response.then()
                .statusCode(200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 200);
        System.out.println(response.jsonPath().prettify());
    }
    @Test
    @Feature("API")
    @Story("API Testing")
    public void searchProductWithoutParameter() {
        Response response = productClient.searchProductWithoutParam();
        response.then()
                .statusCode(200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"),400);
        Assert.assertEquals(response.jsonPath().getString("message"), "Bad request, search_product parameter is missing in POST request.");
        System.out.println(response.jsonPath().prettify());
    }

    @Test
    @Feature("API")
    @Story("API Testing")
    public void verifyLoginWithValidDetails() {
        Response response = userClient.verifyLogin("lukaka@gmail.com","@daburakaraba123");
        response.then()
                .statusCode(200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 200);
        System.out.println(response.jsonPath().prettify());
    }
    @Test
    @Feature("API")
    @Story("API Testing")
    public void verifyLoginWithoutEmail() {
        Response response = userClient.verifyLoginWithoutEmail("luka123");
        response.then()
                .statusCode(200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"),400);
        Assert.assertEquals(response.jsonPath().getString("message"), "Bad request, email or password parameter is missing in POST request.");
        System.out.println(response.jsonPath().prettify());
    }
    @Test
    @Feature("API")
    @Story("API Testing")
    public void deleteToVerifyLogin() {
        Response response = userClient.deleteVerifyLogin("test@test.com", "test123");
        response.then()
                .statusCode(200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 405);
        Assert.assertEquals(response.jsonPath().getString("message"), "This request method is not supported.");
        System.out.println(response.jsonPath().prettify());
    }
    @Test
    @Feature("API")
    @Story("API Testing")
    public void getUserByEmail() {
        Response response = userClient.getUserByEmail("lukaka@gmail.com");
        response.then()
                .statusCode(200);
        Assert.assertEquals(response.jsonPath().getInt("responseCode"),200);
        System.out.println(response.jsonPath().prettify());
    }



}
