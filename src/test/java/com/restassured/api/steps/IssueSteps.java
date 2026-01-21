package com.restassured.api.steps;

import com.restassured.api.dto.IssueDTO;
import com.restassured.api.specs.request.IssueRequestSpec;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class IssueSteps {

    public static Response getAllIssues() {
        return given()
                .spec(IssueRequestSpec.issue())
                .when()
                .get("?fields=id,summary,project(shortName)");
    }

    public static Response getIssueById(String issueId) {
        return given()
                .spec(IssueRequestSpec.issue())
                .when()
                .get("/" + issueId);
    }

    public static Response createIssue(IssueDTO issue) {
        return given()
                .spec(IssueRequestSpec.issue())
                .body(issue)
                .when()
                .post();
    }
}