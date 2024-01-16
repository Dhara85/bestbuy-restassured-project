package com.bestbuy.testbase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {

    @BeforeClass
    public void inIt() {
        RestAssured.baseURI = "http://localhost"; // RestAssured is a class use that function to set our base URI
        RestAssured.port = 3030;
        RestAssured.basePath = "/products"; // basepath is a function
    }
}
