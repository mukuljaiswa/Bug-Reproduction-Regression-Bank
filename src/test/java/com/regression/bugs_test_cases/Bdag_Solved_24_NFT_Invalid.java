package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bdag_Solved_24_NFT_Invalid extends BaseTest {

    // Invalid NFT Details URL (random hash)
    private static final String INVALID_NFT_URL = BASE_URL + "nftdetails/0x000/0x000/99999999";

    @Test(description = "SOLVED: Invalid NFT Details URL handles gracefully by showing empty state")
    public void testInvalidNft() {
        driver.get(INVALID_NFT_URL);

        // Actual behavior: Page loads but shows 0 transactions for the invalid ID
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        String pageText = driver.findElement(By.tagName("body")).getText();

        boolean isHandled = pageText.contains("TOTAL OF 0 NFT TRANSACTIONS") ||
                pageText.contains("TokenId #");

        Assert.assertTrue(isHandled, "Invalid NFT URL should show empty state or Token ID, but found neither.");
    }
}
