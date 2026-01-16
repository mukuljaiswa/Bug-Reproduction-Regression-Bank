package com.regression.bugs;

import org.openqa.selenium.WebDriver;


import org.testng.Assert;


import org.testng.annotations.Test;


public class Bdag_Solved_17_PageTitle extends BaseTest {
    @Test(description = "SOLVED: Page Title is correct and contains SEO Keywords")
    public void testPageTitle() {
        driver.get(BASE_URL);

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // Expectation: "BlockDAG" should be present
        Assert.assertTrue(title.contains("BlockDAG"), "Title missing BlockDAG brand");
        Assert.assertTrue(title.length() > 5, "Title is too short/empty");
    }}
