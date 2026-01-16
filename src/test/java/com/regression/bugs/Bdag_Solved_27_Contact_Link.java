package com.regression.bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bdag_Solved_27_Contact_Link extends BaseTest {

    // Search for "Support" or "Contact" link
    private static final By SUPPORT_LINK = By.xpath("//a[contains(@href, 'support')]");

    @Test(description = "SOLVED: Support/Contact link exists in navigation/footer")
    public void testContactLinkExists() {
        driver.get(BASE_URL);

        WebElement link = driver.findElement(SUPPORT_LINK);
        Assert.assertTrue(link.isDisplayed(), "Support link not found on Homepage");
    }
}
