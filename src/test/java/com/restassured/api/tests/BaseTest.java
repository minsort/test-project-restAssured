package com.restassured.api.tests;

import com.restassured.api.utils.ExcelUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class BaseTest {
    @DataProvider(name = "issuesData")
    public static Object[][] issuesData() throws IOException {
        return ExcelUtils.getExcelData("src/test/resources/issues.xlsx", "Sheet1");
    }
}
