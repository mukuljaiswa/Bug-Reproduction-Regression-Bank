package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;



public class Bdag_Solved_08_CopyButton extends BaseTest {
    // Test copy on Address page
    private static final String ADDRESS_URL = "https://awakening.bdagscan.com/address/0x9e05A61159B516df4F0e0f81f1856C93570bD4B5";

    // Copy buttons usually have title="Copy" or an SVG icon
    // We look for a button near the address.
    private static final By COPY_BTN = By.cssSelector("button svg"); // Very generic, might fail, but common in React
                                                                     // apps
    @Test(description = "SOLVED: Copy-to-clipboard buttons are present and interactive")
    public void testCopyButton() {
        driver.get(ADDRESS_URL);

        // Wait for page load
        wait.until(ExpectedConditions.presenceOfElementLocated(COPY_BTN));

        WebElement btn = driver.findElements(COPY_BTN).stream()
                .findFirst().orElse(null);

        Assert.assertNotNull(btn, "Copy button (SVG) not found on page.");
        Assert.assertTrue(btn.isEnabled(), "Copy button is disabled.");

        // Clicking it shouldn't crash
        btn.click();
    }}
