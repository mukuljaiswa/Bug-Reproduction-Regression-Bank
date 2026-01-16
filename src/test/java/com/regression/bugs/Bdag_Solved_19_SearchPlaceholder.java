package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.testng.Assert;


import org.testng.annotations.Test;

public class Bdag_Solved_19_SearchPlaceholder extends BaseTest {
    @Test(description = "SOLVED: Search bar placeholder helps user understand what to search")
    public void testPlaceholderText() {
        driver.get(BASE_URL);

        WebElement input = driver.findElement(By.cssSelector("input[placeholder]"));
        String ph = input.getAttribute("placeholder");

        // Verify key terms
        Assert.assertTrue(ph.contains("Address"), "Placeholder missing 'Address'");
        Assert.assertTrue(ph.contains("Hash") || ph.contains("Block"), "Placeholder missing Hash/Block hints");
    }}
