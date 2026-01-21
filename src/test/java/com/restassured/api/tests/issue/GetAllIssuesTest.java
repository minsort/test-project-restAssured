package com.restassured.api.tests.issue;

import com.restassured.api.specs.response.IssueResponseSpec;
import com.restassured.api.steps.IssueSteps;
import com.restassured.api.tests.BaseTest;
import org.testng.annotations.Test;

public class GetAllIssuesTest extends BaseTest {

    @Test(description = "Проверка получения всех задач")
    public void shouldGetAllIssues() {

        IssueSteps.getAllIssues()
                .then()
                .spec(IssueResponseSpec.issuesList());
    }
}
