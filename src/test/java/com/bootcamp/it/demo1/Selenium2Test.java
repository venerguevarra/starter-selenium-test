package com.bootcamp.it.demo1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium2Test {
    private WebDriver webDriver;

    @BeforeClass
    public static void setupClass() {
        // Use WebDriverManager Maven package to download the correct version of
        // a driver to automate Chrome browser
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {
        // Set variable driver to an instance of ChromeDriver
        webDriver = new ChromeDriver();
    }

    @Test
    public void shouldRenderGoogleHomePage() {
        // Open the URL
        webDriver.get("https://www.google.com/");

        // Assert that the title of the page google.com
        assertEquals("Google", webDriver.getTitle());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
