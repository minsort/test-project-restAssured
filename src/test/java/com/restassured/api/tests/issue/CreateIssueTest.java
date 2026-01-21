package com.restassured.api.tests.issue;

import com.restassured.api.dto.IssueDTO;
import com.restassured.api.specs.response.IssueResponseSpec;
import com.restassured.api.steps.IssueSteps;
import com.restassured.api.tests.BaseTest;
import org.testng.annotations.Test;

public class CreateIssueTest extends BaseTest {

    @Test(dataProvider = "issuesData", description = "Проверка создания новой задачи")
    public void shouldCreateIssue(String description, String summary, String projectId) {

        IssueDTO issue = IssueDTO.builder()
                .summary(summary.trim())
                .description(description.trim())
                .project(new IssueDTO.Project(projectId.trim()))
                .build();

        IssueSteps.createIssue(issue)
                .then()
                .spec(IssueResponseSpec.issueCreated());
    }
}
