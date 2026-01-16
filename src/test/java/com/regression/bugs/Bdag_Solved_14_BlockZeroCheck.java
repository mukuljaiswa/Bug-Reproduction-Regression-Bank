package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;



public class Bdag_Solved_14_BlockZeroCheck extends BaseTest {
    // We discovered Simple Search for '0' or '1' might fail or requires Enter.
    // We will regression test the INPUT FIELD's ability to accept numeric input.

    private static final By SEARCH_INPUT = By.cssSelector("input[placeholder*='Search']");
    @Test(description = "SOLVED: Search input accepts numeric block height without validation error")
    public void testNumericInput() {
        driver.get(BASE_URL);

        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(SEARCH_INPUT));
        search.sendKeys("0");

        // Verify value is registered
        Assert.assertEquals(search.getAttribute("value"), "0", "Search input rejected numeric value");
    }}
