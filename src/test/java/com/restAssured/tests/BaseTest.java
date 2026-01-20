package com.restAssured.tests;

import com.restAssured.tests.utils.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class BaseTest {
    protected static final String BASE_URL = "http://localhost:8080";

    @DataProvider(name = "issuesData")
    public static Object[][] issuesData() throws IOException {
        return ExcelUtils.getExcelData("src/test/resources/issues.xlsx", "Sheet1");
    }

    public RequestSpecification getRequestSpec() {
        String token = System.getenv("YOUTRACK_TOKEN");

        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .contentType("application/json");
    }


}