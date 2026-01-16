package com.regression.bugs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final String BASE_URL = "https://awakening.bdagscan.com/";

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(System.getenv("HEADLESS"))) {
            options.addArguments("--headless=new");
        }

        // options.addArguments("--headless=new"); // Keep disabled for visual debugging
        // as requested; use HEADLESS=true env var for Docker/CI
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown() {
        try {
            // User requested wait between tasks
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
