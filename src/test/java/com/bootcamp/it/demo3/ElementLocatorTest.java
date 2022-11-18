package com.bootcamp.it.demo3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.bootcamp.it.base.BaseTest;

public class ElementLocatorTest extends BaseTest {

    @Test
    public void testByLinkText() {
        webDriver().get("https://ultimateqa.com/simple-html-elements-for-automation/");

        WebElement link1 = webDriver.findElement(By.linkText("Click me using this link text!"));
        WebElement link2 = webDriver.findElement(By.partialLinkText("link text!"));

        assertTrue(link1.isDisplayed());
        assertTrue(link2.isDisplayed());
    }

    @Test
    public void testByIdLocation() {
        webDriver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        WebElement buttonId = webDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.id("idExample")));
        assertTrue(buttonId.isDisplayed());

        webDriver.get("http://the-internet.herokuapp.com/login");
        WebElement usernameElement = webDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        WebElement passwordElement = webDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.id("password")));

        assertTrue(usernameElement.isDisplayed());
        assertTrue(passwordElement.isDisplayed());
    }

    @Test
    public void testByIdClassName() {
        webDriver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        WebElement buttonClass = webDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.className("buttonClass")));

        assertTrue(buttonClass.isDisplayed());
    }

    @Test
    public void testByIdName() {
        webDriver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        WebElement buttonName = webDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.name("button1")));

        assertTrue(buttonName.isDisplayed());
    }

    @Test
    public void testByTagName() {
        webDriver.get("http://the-internet.herokuapp.com/login");

        List<WebElement> inputElements = webDriver.findElements(By.tagName("input"));

        assertEquals(2, inputElements.size());
    }

    @Test
    public void testByCssSelector() {
        webDriver.get("http://the-internet.herokuapp.com/login");

        WebElement usernameInput = webDriver.findElement(By.cssSelector("#username"));
        WebElement passwordInput = webDriver.findElement(By.cssSelector("#password"));
        WebElement loginButton = webDriver.findElement(By.cssSelector(".radius"));

        assertTrue(usernameInput.isDisplayed());
        assertTrue(passwordInput.isDisplayed());
        assertTrue(loginButton.isDisplayed());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
