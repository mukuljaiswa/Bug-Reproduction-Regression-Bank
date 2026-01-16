package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;



public class Bdag_Solved_06_TxnTabsSwitch extends BaseTest {
    // Using the class found in exploration: .style_tableTabItem__W8PUY
    // It had 2 items. Index 0 = Blocks, Index 1 = Txns
    private static final By TXN_TAB = By.xpath("(//*[@class='style_tableTabItem__W8PUY'])[2]");

    // Verify content changed. We look for 'Hash' or 'Timestamp' headers which might
    // be common,
    // but 'Txn Hash' vs 'Block Height' is the key differentiator.
    // Let's assume the table header row updates.
    @Test(description = "SOLVED: Dashboard tabs switch correctly from Blocks to Transactions")
    public void testTabSwitching() {
        driver.get(BASE_URL);

        // Wait for tab to appear
        WebElement txTab = wait.until(ExpectedConditions.elementToBeClickable(TXN_TAB));
        txTab.click();

        // Assert: Some visual change or class change 'active'
        // Simpler: Check if URL changed? No, it's SPA.
        // Check if "LATEST TRANSACTIONS" or similar text appears
        // The subagent found "LATEST BLOCKS", so likely "LATEST TXNS" or similar is the
        // toggled view header

        // We blindly search for "LATEST TXNS" or "TRANSACTION" in body text
        // Use a generous wait for DOM update
        wait.until(d -> d.getPageSource().contains("Txn Hash") || d.getPageSource().contains("Transactions"));

        Assert.assertTrue(driver.getPageSource().contains("Txn Hash"),
                "Table verification failed: 'Txn Hash' column not found.");
    }}
