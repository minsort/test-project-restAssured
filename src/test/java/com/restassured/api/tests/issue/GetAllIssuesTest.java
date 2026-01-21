package com.restassured.api.tests.issue;

import com.restassured.api.specs.response.UserResponseSpec;
import com.restassured.api.steps.IssueSteps;
import com.restassured.api.tests.BaseTest;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import org.testng.annotations.Test;

public class GetAllIssuesTest extends BaseTest {

    @Test(description = "Проверка получения всех задач")
    public void shouldGetAllIssues() {

        IssueSteps.getAllIssues()
                .then()
                .spec(UserResponseSpec.success())
                .body("size()", greaterThan(0))
                .body("[0].summary", not(emptyOrNullString()))
                .body("[0].project.shortName", not(emptyOrNullString()));
    }
}
