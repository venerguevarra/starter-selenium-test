package com.bootcamp.it.demo5.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bootcamp.it.base.page.Page;

public class LoginPage extends Page {
    private static final By USERNAME_TEXT = By.id("username");
    private static final By PASSWORD_TEXT = By.id("password");
    private static final By LOGIN_BUTTON = By.className("radius");
    private static final By LOGOUT_BUTTON = By.xpath("//div[@class='example']//descendant::a[@class='button secondary radius']");
    private static final By LOGIN_SUCCESS_HEADING = By.xpath("//div[@class='example']//h2");
    private static final By LOGIN_SUCCESS_MESSAGE = By.xpath("//div[@id='flash-messages']//descendant::div[@id='flash']");

    public LoginPage(String url, WebDriver webDriver) {
        super(webDriver);
        super.navigateToUrl(url);
    }

    public static class Assertions {
        private final WebDriver webDriver;
        private final WebDriverWait webDriverWait;

        public Assertions(WebDriver webDriver, WebDriverWait webDriverWait) {
            this.webDriver = webDriver;
            this.webDriverWait = webDriverWait;
        }

        public void hasLoginControls() {
            webDriver.findElement(USERNAME_TEXT);
            webDriver.findElement(PASSWORD_TEXT);
            webDriver.findElement(LOGIN_BUTTON);
        }

        public void isSecureArea(String url) {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(LOGIN_SUCCESS_MESSAGE));
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(LOGIN_SUCCESS_HEADING));

            final String successMessage = webDriver.findElement(LOGIN_SUCCESS_MESSAGE).getText();
            final String successHeading = webDriver.findElement(LOGIN_SUCCESS_HEADING).getText();
            final String currentUrl = webDriver.getCurrentUrl();

            assertEquals(url, currentUrl);
            assertTrue(successMessage.contains("You logged into a secure area!"));
            assertTrue(successHeading.equals("Secure Area"));
        }

    }

    public Assertions assertions() {
        return new Assertions(webDriver(), webDriverWait());
    }

    public void enterUsername(String username) {
        webDriver().findElement(USERNAME_TEXT).sendKeys(username);
    }

    public void enterPassword(String password) {
        webDriver().findElement(PASSWORD_TEXT).sendKeys(password);
    }

    public void clickLogin() {
        webDriverWait().until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON)).click();
    }

    public void clickLogout() {
        webDriverWait().until(ExpectedConditions.elementToBeClickable(LOGOUT_BUTTON)).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void logout() {
        clickLogout();
    }
}
