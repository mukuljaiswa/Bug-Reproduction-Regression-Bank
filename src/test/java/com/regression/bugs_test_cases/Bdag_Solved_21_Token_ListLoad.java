package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bdag_Solved_21_Token_ListLoad extends BaseTest {

    private static final String TOKEN_URL = BASE_URL + "token";
    // Selector for table rows in the token list
    private static final By TABLE_ROWS = By.cssSelector("tbody tr");

    @Test(description = "SOLVED: Token Tracker list loads and displays data")
    public void testTokenListLoads() {
        driver.get(TOKEN_URL);

        wait.until(ExpectedConditions.presenceOfElementLocated(TABLE_ROWS));
        int rowCount = driver.findElements(TABLE_ROWS).size();

        Assert.assertTrue(rowCount > 0, "Token list is empty!");
    }
}
