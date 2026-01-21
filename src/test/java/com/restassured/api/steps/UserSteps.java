package com.restassured.api.steps;

import com.restassured.api.specs.request.UserRequestSpec;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class UserSteps {

    public static Response getAllUsers() {
        return given()
                .spec(UserRequestSpec.user())
                .when()
                .get();
    }

    public static Response getUserById(String userId) {
        return given()
                .spec(UserRequestSpec.user())
                .when()
                .get("/" + userId);
    }
}
