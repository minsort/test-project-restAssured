package com.restassured.api.specs.response;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class IssueResponseSpec {

    public static ResponseSpecification issueCreated() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("$type", equalTo("Issue"))
                .expectBody("id", not(emptyOrNullString()))
                .build();
    }
}
