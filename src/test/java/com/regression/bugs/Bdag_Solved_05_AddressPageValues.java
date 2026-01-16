package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;



public class Bdag_Solved_05_AddressPageValues extends BaseTest {
    // Uses the address captured earlier
    private static final String ADDRESS = "0x9e05A61159B516df4F0e0f81f1856C93570bD4B5";
    private static final String ADDRESS_URL = "https://awakening.bdagscan.com/address/" + ADDRESS;
    @Test(description = "SOLVED: Address details page loads with correct Hash label")
    public void testAddressPageLoad() {
        driver.get(ADDRESS_URL);

        // Verify that the page content contains the address string (indicating
        // successful load)
        // Usually shown in a header or copy field
        By addressOnPage = By.xpath("//*[contains(text(), '" + ADDRESS + "')]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(addressOnPage));
        Assert.assertTrue(driver.getPageSource().contains("Address"), "Page didn't explicitly say 'Address'");
    }}
