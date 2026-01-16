package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;



public class Bdag_Solved_12_ErrorPageHomeButton extends BaseTest {    private static final String ERROR_URL = "https://awakening.bdagscan.com/errorpage";
    // Selector found by subagent: a.style_button__uUyRg
    private static final By HOME_BTN = By.cssSelector("a.style_button__uUyRg");
    @Test(description = "SOLVED: 404 Page contains a working 'Go Home' button")
    public void testErrorPageNavigation() {
        driver.get(ERROR_URL);

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(HOME_BTN));
        Assert.assertTrue(btn.getText().contains("Main Website"), "Button text incorrect");

        btn.click();

        // Wait for Home
        wait.until(ExpectedConditions.urlToBe("https://awakening.bdagscan.com/"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://awakening.bdagscan.com/", "Did not return home");
    }}
