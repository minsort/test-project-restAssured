package com.restassured.api.tests.issue;

import com.restassured.api.specs.response.IssueResponseSpec;
import com.restassured.api.steps.IssueSteps;
import com.restassured.api.tests.BaseTest;
import org.testng.annotations.Test;

public class GetIssueByIdTest extends BaseTest {

    @Test(description = "Проверка получения задачи по id")
    public void shouldGetIssueById() {

        IssueSteps.getIssueById("demo-4")
                .then()
                .spec(IssueResponseSpec.issueById());
    }
}
