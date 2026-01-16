package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;



public class Bdag_Solved_09_GasTracking extends BaseTest {
    // Check if Gas Price is visible
    private static final By GAS_LABEL = By.xpath("//*[contains(text(), 'Gas') or contains(text(), 'Gwei')]");
    @Test(description = "SOLVED: Gas price/usage tracking is visible on dashboard")
    public void testGasVisibility() {
        driver.get(BASE_URL);

        wait.until(ExpectedConditions.presenceOfElementLocated(GAS_LABEL));
        Assert.assertTrue(driver.findElement(GAS_LABEL).isDisplayed());
    }}
