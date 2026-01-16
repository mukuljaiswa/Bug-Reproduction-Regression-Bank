package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;



public class Bdag_Solved_16_FooterDapps extends BaseTest {
    // Subagent found "BlockDAG dApps" in footer
    private static final By DAPPS_LINK = By.xpath("//*[contains(text(), 'dApps')]");
    @Test(description = "SOLVED: Footer contains link to BlockDAG dApps ecosystem")
    public void testFooterDapps() {
        driver.get(BASE_URL);

        wait.until(ExpectedConditions.presenceOfElementLocated(DAPPS_LINK));
        WebElement link = driver.findElement(DAPPS_LINK);
        // Verify href exists
        String href = link.getAttribute("href");
        Assert.assertNotNull(href, "dApps link is missing href attribute");
        Assert.assertFalse(href.isEmpty(), "dApps link is empty");
    }}
