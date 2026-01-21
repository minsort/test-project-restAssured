package com.restassured.api.specs.response;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class UserResponseSpec {

    public static ResponseSpecification usersList() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("size()", greaterThan(0))
                .expectBody("[0].$type", equalTo("User"))
                .build();
    }

    public static ResponseSpecification userById(String userId) {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("id", equalTo(userId))
                .expectBody("$type", equalTo("User"))
                .build();
    }
}
