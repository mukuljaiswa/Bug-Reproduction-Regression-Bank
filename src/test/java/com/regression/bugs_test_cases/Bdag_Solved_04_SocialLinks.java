package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;



public class Bdag_Solved_04_SocialLinks extends BaseTest {
    // Footer social links
    private static final String TWITTER_URL = "https://x.com/blockdagnetwork";
    @Test(description = "SOLVED: Footer contains valid Social Media links (e.g. Twitter)")
    public void testFooterLinks() {
        driver.get(BASE_URL);

        // Scroll to bottom
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Verify Twitter Link exists in DOM
        // We use a CSS selector for the href
        By twitterSelector = By.cssSelector("a[href='" + TWITTER_URL + "']");

        wait.until(ExpectedConditions.presenceOfElementLocated(twitterSelector));
        WebElement icon = driver.findElement(twitterSelector);

        Assert.assertTrue(icon.isDisplayed() || icon.isEnabled(), "Twitter link not visible/active in footer.");
    }}
