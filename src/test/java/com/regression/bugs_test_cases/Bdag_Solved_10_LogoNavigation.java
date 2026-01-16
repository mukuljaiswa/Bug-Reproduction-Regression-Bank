package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;



public class Bdag_Solved_10_LogoNavigation extends BaseTest {    // Deep link to test logo click
    private static final String DEEP_URL = "https://awakening.bdagscan.com/errorpage";

    // Logo (Usually the first image in nav)
    private static final By LOGO = By.cssSelector("nav img, header img");
    @Test(description = "SOLVED: Clicking the Logo redirects to Homepage")
    public void testLogoHomeLink() {
        driver.get(DEEP_URL);

        WebElement logo = wait.until(ExpectedConditions.elementToBeClickable(LOGO));
        logo.click();

        // Wait for URL to be base
        wait.until(ExpectedConditions.urlToBe(BASE_URL));

        Assert.assertEquals(driver.getCurrentUrl(), BASE_URL, "Logo did not redirect to home.");
    }}
