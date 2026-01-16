package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;



public class Bdag_Solved_02_InvalidSearchRedirect extends BaseTest {    private static final String INVALID_HASH = "invalid_hash_xyz_123";

    private static final By SEARCH_INPUT = By.cssSelector("input[placeholder*='Search']");
    @Test(description = "SOLVED: Invalid search string redirects to valid 404 Error page")
    public void testInvalidSearch() {
        driver.get(BASE_URL);

        // Use a JS submit or Enter key if simple click fails? Selenium keys.enter is
        // standard
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(SEARCH_INPUT));
        search.sendKeys(INVALID_HASH);
        search.submit(); // different approach than Keys.ENTER to be robust

        // Expectation: Redirect to /errorpage
        // We handle potential sluggishness by waiting for URL
        try {
            wait.until(ExpectedConditions.urlContains("errorpage"));
        } catch (Exception e) {
            System.out.println("Warning: URL update lag.");
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("errorpage"),
                "Did not redirect to error page for invalid hash.");
    }}
