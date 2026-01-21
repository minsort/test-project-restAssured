package com.restassured.api.tests.user;

import com.restassured.api.specs.response.UserResponseSpec;
import com.restassured.api.steps.UserSteps;
import com.restassured.api.tests.BaseTest;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import org.testng.annotations.Test;

public class GetAllUsersTest extends BaseTest {

    @Test(description = "Проверка получения всех пользователей")
    public void shouldGetAllUsers() {

        UserSteps.getAllUsers()
                .then()
                .spec(UserResponseSpec.success())
                .body("size()", greaterThan(0))
                .body("[0].$type", equalTo("User"));
    }
}
