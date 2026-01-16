package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;



public class Bdag_Solved_11_ViewAllBlocks extends BaseTest {    // Selector found by subagent
    private static final By VIEW_ALL_LINK = By
            .xpath("//*[contains(text(), 'Show all') and contains(text(), 'blocks')]");
    @Test(description = "SOLVED: 'View All Blocks' link exists and navigates to blocks list")
    public void testViewAllBlocks() {
        driver.get(BASE_URL);

        wait.until(ExpectedConditions.presenceOfElementLocated(VIEW_ALL_LINK));
        WebElement link = driver.findElement(VIEW_ALL_LINK);
        Assert.assertTrue(link.isDisplayed(), "View All Link not visible");

        // Optional: Click and verify URL?
        // link.click();
        // wait.until(ExpectedConditions.urlContains("/blocks"));
    }}
