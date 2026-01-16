package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;

public class Bdag_Solved_01_ValidSearch extends BaseTest {
    // TEST DATA: Use a known valid block or tx from exploration
    private static final String VALID_BLOCK = "56463866";

    private static final By SEARCH_INPUT = By.xpath("//input[@placeholder='Search by Address / Txn Hash / Block']");
    private static final By SEARCH_BUTTON = By
            .xpath("//input[@placeholder='Search by Address / Txn Hash / Block']/following-sibling::span");

    @Test(description = "SOLVED: Search bar now correctly navigates to Block Details for valid input")
    public void testValidBlockSearch() {
        driver.get(BASE_URL);

        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(SEARCH_INPUT));
        search.click();
        search.clear();
        search.sendKeys(VALID_BLOCK);

        // Use explicit button click as it's more reliable than Keys.ENTER
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BUTTON)).click();

        // Expectation: URL changes to /block/56463866
        wait.until(ExpectedConditions.urlContains("block/"));

        String url = driver.getCurrentUrl();
        System.out.println("Navigated to: " + url);
        Assert.assertTrue(url.contains(VALID_BLOCK), "Search did not navigate to correct block details.");
    }
}
