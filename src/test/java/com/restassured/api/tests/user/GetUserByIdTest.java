package com.restassured.api.tests.user;

import com.restassured.api.specs.response.UserResponseSpec;
import com.restassured.api.steps.UserSteps;
import com.restassured.api.tests.BaseTest;
import org.testng.annotations.Test;

public class GetUserByIdTest extends BaseTest {

    @Test(description = "Проверка получения пользователя по id")
    public void shouldGetUserById() {

        UserSteps.getUserById("2-1")
                .then()
                .spec(UserResponseSpec.userById("2-1"));
    }
}

