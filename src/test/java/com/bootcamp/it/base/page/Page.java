package com.bootcamp.it.base.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    private final WebDriver webDriver;

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected WebDriver webDriver() {
        return webDriver;
    }

    protected WebDriverWait webDriverWait() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5L));
        return webDriverWait;
    }

    protected void enterText(By element, String text) {
        webDriver.findElement(element).sendKeys(text);
    }

    protected void navigateToUrl(String url) {
        webDriver.get(url);
    }

}
