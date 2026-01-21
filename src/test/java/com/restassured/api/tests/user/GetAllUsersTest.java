package com.restassured.api.tests.user;

import com.restassured.api.specs.response.UserResponseSpec;
import com.restassured.api.steps.UserSteps;
import com.restassured.api.tests.BaseTest;
import org.testng.annotations.Test;

public class GetAllUsersTest extends BaseTest {

    @Test(description = "Проверка получения всех пользователей")
    public void shouldGetAllUsers() {

        UserSteps.getAllUsers()
                .then()
                .spec(UserResponseSpec.usersList());
    }

}
