package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bdag_Solved_25_Node_MapLoad extends BaseTest {

    private static final String NODE_URL = BASE_URL + "node";
    // Canvas element usually represents the globe/map
    private static final By MAP_CANVAS = By.tagName("canvas");

    @Test(description = "SOLVED: Node Visualizer loads the 3D Map (Canvas)")
    public void testNodeMapLoads() {
        driver.get(NODE_URL);

        wait.until(ExpectedConditions.presenceOfElementLocated(MAP_CANVAS));
        Assert.assertTrue(driver.findElement(MAP_CANVAS).isDisplayed(), "Node Map Canvas not visible");
    }
}
