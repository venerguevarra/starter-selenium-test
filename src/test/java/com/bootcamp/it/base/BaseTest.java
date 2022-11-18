package com.bootcamp.it.base;

import java.time.Duration;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bootcamp.it.util.OSUtil;

public abstract class BaseTest {
    protected WebDriver webDriver;

    public BaseTest() {
        System.setProperty("webdriver.chrome.driver", OSUtil.getOS().getPath());
        webDriver = new ChromeDriver();
    }

    protected WebDriver webDriver() {
        return webDriver;
    }

    protected WebDriverWait webDriverWait() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5L));
        return webDriverWait;
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
