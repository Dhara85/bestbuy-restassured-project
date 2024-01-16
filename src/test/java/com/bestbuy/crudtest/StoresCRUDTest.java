package com.bestbuy.crudtest;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.model.StorePojo;
import com.bestbuy.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresCRUDTest  {
    static ValidatableResponse response;
    static int storeid;
    static String name = "Dhara" + TestUtils.getRandomValue();
    static String UpdatedName = "UpdatedName" + TestUtils.getRandomValue();
    static String type = "Testing";
    static String address = "home";

    static String address2 = "wembley";
    static String city = "diu";

    static String state = "diu";
    static String zip = "362570";

    static List<String> services;
    private String id;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        //  RestAssured.basePath = "/stores";
    }
    @Test
    public void test001() {

        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(storePojo)
                .post("/stores");
        response.then().log().all().statusCode(201);
        String responseBody = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        storeid = jsonPath.getInt("id");
        //  System.out.println("=================" + user_id);
    }

    @Test
    public void test002() {

        Response response = given()
                .when()
                .get("/" + id);
        response.then().statusCode(200);
        response.prettyPrint();

    }
        @Test
    public void test003() {
            ProductPojo productPojo = new ProductPojo();
            productPojo.setName(name + "_123");
            productPojo.setType(type + "_good");


            Response response = given()
                    .contentType(ContentType.JSON)
                    .body(productPojo)
                    .when()
                    .patch("/" + id);
            response.then().statusCode(200);
            response.then().log().body();
        }


    @Test
    public void test004() {

        given()
                .pathParam("id", storeid)
                .when()
                .delete("/stores/{id}")
                .then()
                .statusCode(404);
    }

}
