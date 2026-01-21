package com.restassured.api.tests.issue;

import com.restassured.api.specs.response.UserResponseSpec;
import com.restassured.api.steps.IssueSteps;
import com.restassured.api.tests.BaseTest;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class GetIssueByIdTest extends BaseTest {

    @Test(description = "Проверка получения задачи по id")
    public void shouldGetIssueById() {

        IssueSteps.getIssueById("demo-4")
                .then()
                .spec(UserResponseSpec.success())
                .body("id", not(emptyOrNullString()))
                .body("$type", equalTo("Issue"));
    }
}
