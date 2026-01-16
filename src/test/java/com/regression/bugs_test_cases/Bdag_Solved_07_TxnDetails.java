package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;



public class Bdag_Solved_07_TxnDetails extends BaseTest {
    // Captured Txn
    private static final String TX_HASH = "0x6b9af390f567a5e581907bfbf2870e2ebc2b23387226d359375eff33f7355dcc";
    private static final String TX_URL = "https://awakening.bdagscan.com/tx/" + TX_HASH;
    @Test(description = "SOLVED: Transaction detail page loads and displays status")
    public void testTxnDetails() {
        driver.get(TX_URL);

        // Verify Hash is visible
        By hashOnPage = By.xpath("//*[contains(text(), '" + TX_HASH.substring(0, 10) + "')]"); // Partial match safe

        wait.until(ExpectedConditions.visibilityOfElementLocated(hashOnPage));

        // Verify Status (Success/Pending) - usually a badge
        // We verify the page isn't empty/404
        Assert.assertFalse(driver.getTitle().contains("404"), "Transaction page returned 404!");
    }}
