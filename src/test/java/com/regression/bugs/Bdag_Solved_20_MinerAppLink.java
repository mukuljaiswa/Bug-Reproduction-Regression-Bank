package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;



public class Bdag_Solved_20_MinerAppLink extends BaseTest {
    // Found in footer: "BlockDAG X1 Miner App"
    private static final By MINER_LINK = By.xpath("//*[contains(text(), 'Miner App')]");
    @Test(description = "SOLVED: Link to X1 Miner App is present and correct")
    public void testMinerLink() {
        driver.get(BASE_URL);

        wait.until(ExpectedConditions.presenceOfElementLocated(MINER_LINK));
        WebElement link = driver.findElement(MINER_LINK);

        Assert.assertTrue(link.isDisplayed(), "Miner App link hidden");
    }}
