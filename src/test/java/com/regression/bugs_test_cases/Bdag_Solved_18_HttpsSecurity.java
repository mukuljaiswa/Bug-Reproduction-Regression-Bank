package com.regression.bugs;

import org.openqa.selenium.WebDriver;


import org.testng.Assert;


import org.testng.annotations.Test;


public class Bdag_Solved_18_HttpsSecurity extends BaseTest {    private static final String HTTP_URL = "http://awakening.bdagscan.com/";
    @Test(description = "SOLVED: HTTP requests are automatically upgraded to HTTPS")
    public void testHttpsRedirect() {
        // We attempt to access the INSECURE http version
        driver.get(HTTP_URL);

        // Assert the browser ended up on https
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.startsWith("https://"), "Site did not force HTTPS upgrade!");
    }}
