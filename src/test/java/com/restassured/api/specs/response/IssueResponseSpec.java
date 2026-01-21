package com.restassured.api.specs.response;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;

public class IssueResponseSpec {

    public static ResponseSpecification issuesList() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("size()", greaterThan(0))
                .expectBody("[0].summary", not(emptyOrNullString()))
                .expectBody("[0].project.shortName", not(emptyOrNullString()))
                .build();
    }

    public static ResponseSpecification issueById() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("$type", equalTo("Issue"))
                .expectBody("id", not(emptyOrNullString()))
                .build();
    }

    public static ResponseSpecification issueCreated() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("id", not(emptyOrNullString()))
                .expectBody("$type", equalTo("Issue"))
                .build();
    }
}

