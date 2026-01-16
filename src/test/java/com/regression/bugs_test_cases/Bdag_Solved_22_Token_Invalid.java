package com.regression.bugs;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Bdag_Solved_22_Token_Invalid extends BaseTest {

    // Invalid Contract Address
    private static final String INVALID_TOKEN_URL = BASE_URL + "contractOverview/0xInvalidTokenAddress123";

    @Test(description = "SOLVED: Invalid Token URL navigates to 404/Error page")
    public void testInvalidToken() {
        driver.get(INVALID_TOKEN_URL);

        // Expecting redirection to error page OR a "Not Found" message
        // Based on previous exploration, specific 404 redirect is common
        boolean isErrorPage = driver.getCurrentUrl().contains("errorpage") ||
                driver.getPageSource().contains("404") ||
                driver.getPageSource().contains("not found");

        Assert.assertTrue(isErrorPage, "Did not handle invalid token address gracefully.");
    }
}
