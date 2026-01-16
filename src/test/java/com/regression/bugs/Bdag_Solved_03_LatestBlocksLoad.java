package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;


import java.util.List;

public class Bdag_Solved_03_LatestBlocksLoad extends BaseTest {
    // Selectors
    // We look for the container of rows. Assuming standard table or list structure.
    // Based on visual inspection, it's likely a div/table with row items.
    // We'll use a text based locator for robustness for the Header, then find
    // siblings.
    private static final By BLOCKS_HEADER = By.xpath("//*[contains(text(), 'LATEST BLOCKS')]");

    // Generic Row Locator (adjust if strictly table structure)
    // Finding elements that have 'Block' or numeric links
    private static final By BLOCK_LINKS = By.xpath("//a[contains(@href, '/block/')]");
    @Test(description = "SOLVED: Dashboard correctly populates 'Latest Blocks' list")
    public void testLatestBlocksPopulated() {
        driver.get(BASE_URL);

        wait.until(ExpectedConditions.visibilityOfElementLocated(BLOCKS_HEADER));

        // Wait for dynamic rows to load
        wait.until(ExpectedConditions.presenceOfElementLocated(BLOCK_LINKS));

        List<WebElement> blocks = driver.findElements(BLOCK_LINKS);
        System.out.println("Blocks Found: " + blocks.size());

        Assert.assertTrue(blocks.size() > 0, "No blocks loaded in the Latest Blocks table.");
    }}
