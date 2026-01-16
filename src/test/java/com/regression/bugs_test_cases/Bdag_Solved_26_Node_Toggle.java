package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bdag_Solved_26_Node_Toggle extends BaseTest {

    private static final String NODE_URL = BASE_URL + "node";
    // Toggle buttons (heuristically finding them or strictly if class is stable)
    // Subagent found ".segment"
    private static final By TOGGLE_BTNS = By.cssSelector("div.segment");

    @Test(description = "SOLVED: Node Visualizer has toggle buttons for List/Map view")
    public void testNodeToggle() {
        driver.get(NODE_URL);

        wait.until(ExpectedConditions.presenceOfElementLocated(TOGGLE_BTNS));
        int toggles = driver.findElements(TOGGLE_BTNS).size();

        // Usually 2 or 3 toggles (Map, List, etc.)
        Assert.assertTrue(toggles >= 1, "View toggle buttons missing from Node page");
    }
}
