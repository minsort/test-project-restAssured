package com.restassured.api.specs.request;

import static com.restassured.api.config.TestConfig.BASE_URL;
import static com.restassured.api.config.TestConfig.TOKEN;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class UserRequestSpec {

    public static RequestSpecification user() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath("/api/users")
                .addHeader("Authorization", "Bearer " + TOKEN)
                .log(LogDetail.ALL)
                .build();
    }
}
