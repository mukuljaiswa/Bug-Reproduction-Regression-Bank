package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bdag_Solved_23_NFT_MintList extends BaseTest {

    private static final String NFT_URL = BASE_URL + "latestmint";
    // Header containing "TOTAL OF"
    private static final By HEADER_STATS = By.xpath("//*[contains(text(), 'TOTAL OF') and contains(text(), 'MINT')]");

    @Test(description = "SOLVED: NFT Latest Mint list loads with statistics")
    public void testNftMintList() {
        driver.get(NFT_URL);

        wait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_STATS));
        String headerText = driver.findElement(HEADER_STATS).getText();

        Assert.assertNotNull(headerText);
        Assert.assertTrue(headerText.contains("MINT"), "NFT Stats header missing");
    }
}
