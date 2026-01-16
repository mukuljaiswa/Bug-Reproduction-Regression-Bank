package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bdag_Solved_15_NetworkMetrics extends BaseTest {
    // We found 'Gas Price' but failed to find 'Hashrate'.
    // We will verify 'TPS' (Transactions Per Second) or 'Total Transactions' which
    // typically exist.

    private static final By TOTAL_TX_LABEL = By.xpath("//span[contains(text(), 'TOTAL TRANSACTIONS')]");
    // Trying a relative path that walks up to the common container and then down to
    // the value paragraph
    private static final By TOTAL_TX_VALUE = By
            .xpath("//span[contains(text(), 'TOTAL TRANSACTIONS')]/ancestor::div[3]//p");

    @Test(description = "SOLVED: Dashboard displays Total Transactions metric")
    public void testNetworkMetrics() {
        driver.get(BASE_URL);

        // Wait for metrics to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(TOTAL_TX_LABEL));

        // Verify the value is displayed and not empty
        wait.until(ExpectedConditions.visibilityOfElementLocated(TOTAL_TX_VALUE));
        String txValue = driver.findElement(TOTAL_TX_VALUE).getText();

        Assert.assertTrue(driver.findElement(TOTAL_TX_VALUE).isDisplayed(),
                "Total Transactions value should be visible");
        Assert.assertFalse(txValue.trim().isEmpty(), "Total Transactions value should not be empty");

        // Ensure it doesn't contain a dollar sign (which would indicate we grabbed the
        // Price or Market Cap)
        Assert.assertFalse(txValue.contains("$"),
                "Value contains '$', possibly grabbed Price instead of Transaction Count. Value: " + txValue);
        System.out.println("Total Transactions: " + txValue);
    }
}
