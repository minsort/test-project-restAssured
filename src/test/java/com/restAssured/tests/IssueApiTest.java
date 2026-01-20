package com.restAssured.tests;

import com.restAssured.tests.dto.IssueDTO;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import org.testng.annotations.Test;

public class IssueApiTest extends BaseTest {

    @Test(description = "Проверка получения всех задач")
    public void getAllIssuesTest() {

        getRequestSpec()
                .when()
                .get("/api/issues?fields=id,summary,project(shortName)")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("[0].summary", not(emptyOrNullString()))
                .body("[0].project.shortName", not(emptyOrNullString()));
    }

    @Test(description = "Проверка получения задачи по id")
    public void getIssueOnIdTest() {
        getRequestSpec()

                .when()
                .get("/api/issues/demo-4")
                .then()
                .statusCode(200)
                .body("id", not(emptyOrNullString()))
                .body("$type", equalTo("Issue"));
    }

    @Test(dataProvider = "issuesData", description = "Проверка создания новой задачи из Exel")
    public void createIssueTest(String description, String summary, String projectId) {

        IssueDTO issue = IssueDTO.builder()
                .summary(summary.trim())
                .description(description.trim())
                .project(new IssueDTO.Project(projectId.trim()))
                .build();

        getRequestSpec()

                .body(issue)
                .when()
                .log().all()
                .post("/api/issues")
                .then()
                .log().all()
                .statusCode(200)
                .body("id", not(emptyOrNullString()))
                .body("$type", equalTo("Issue"));
    }

    @Test(description = "Проверка получения всех пользователей")
    public void getAllUsersTest() {
        getRequestSpec()

                .when()
                .get("/api/users")
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].$type", equalTo("User"))
                .body("size()", greaterThan(0));
    }

    @Test(description = "Проверка получения пользователя по id")
    public void getUserOnIdTest() {
        getRequestSpec()

                .when()
                .get("/api/users/2-1")
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo("2-1"))
                .body("$type", equalTo("User"));
    }

}
