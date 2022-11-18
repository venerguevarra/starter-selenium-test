package com.bootcamp.it.demo2.tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YahooSearchEngineIT {
    private WebDriver webDriver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
    }

    @Test
    public void shouldRenderGoogleHomePage() {
        webDriver.get("https://www.yahoo.ca");

        assertTrue(webDriver.getTitle().startsWith("Yahoo"));
    }

    @After
    public void closeBrowser() {
        webDriver.quit();
    }
}
