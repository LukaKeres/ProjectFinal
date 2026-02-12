package client;

import io.restassured.response.Response;
import utils.RequestSpecFactory;

import static io.restassured.RestAssured.given;

public class ProductClient {
    public Response getAllProducts() {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .accept("application/json")
                .when()
                .get("/api/productsList");
    }
    public Response postAllProducts() {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .post("/api/productsList");
    }
    public Response getAllBrands() {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .get("/api/brandsList");
    }
    public Response putAllBrands() {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .put("/api/brandsList");
    }
    public Response searchProduct(String searchTerm) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .formParam("search_product", searchTerm)
                .when()
                .post("/api/searchProduct");
    }

    public Response searchProductWithoutParam() {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .post("/api/searchProduct");
    }
}
