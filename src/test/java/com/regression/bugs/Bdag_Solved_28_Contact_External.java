package com.regression.bugs;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bdag_Solved_28_Contact_External extends BaseTest {

    private static final By SUPPORT_LINK = By.xpath("//a[contains(@href, 'support')]");

    @Test(description = "SOLVED: Support link correctly points to external blockdag.network domain")
    public void testContactLinkDomain() {
        driver.get(BASE_URL);

        String href = driver.findElement(SUPPORT_LINK).getAttribute("href");

        // Verify it goes to the main domain, not a broken internal page
        Assert.assertTrue(href.contains("blockdag.network"), "Support link does not point to main network site");
    }
}
