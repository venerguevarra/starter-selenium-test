package com.bootcamp.it.demo4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.bootcamp.it.base.BaseTest;

public class FormUI1Test extends BaseTest {
    private static final By LOGIN_SUCCESS_HEADING = By.xpath("//div[@class='example']//h2");
    private static final By LOGIN_SUCCESS_MESSAGE = By.xpath("//div[@id='flash-messages']//descendant::div[@id='flash']");
    private static final By USERNAME_TEXT = By.id("username");
    private static final By PASSWORD_TEXT = By.id("password");
    private static final By SUBMIT_BUTTON = By.className("radius");

    @Test
    public void input_text_password_test() {
        webDriver.get("http://the-internet.herokuapp.com/login");

        webDriver.findElement(USERNAME_TEXT).sendKeys("tomsmith");
        webDriver.findElement(PASSWORD_TEXT).sendKeys("SuperSecretPassword!");
        webDriver.findElement(SUBMIT_BUTTON).click();

        webDriverWait().until(ExpectedConditions.presenceOfElementLocated(LOGIN_SUCCESS_MESSAGE));
        webDriverWait().until(ExpectedConditions.presenceOfElementLocated(LOGIN_SUCCESS_HEADING));

        final String successMessage = webDriver.findElement(LOGIN_SUCCESS_MESSAGE).getText();
        final String successHeading = webDriver.findElement(LOGIN_SUCCESS_HEADING).getText();

        assertTrue(successMessage.contains("You logged into a secure area!"));
        assertTrue(successHeading.equals("Secure Area"));
    }

    @Test
    public void radio_button_test() {
        webDriver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        WebElement maleRadioButton = webDriver.findElement(By.cssSelector("input[name='gender'][value='male']"));
        maleRadioButton.click();
        assertTrue(maleRadioButton.isEnabled());

        WebElement femaleRadioButton = webDriver.findElement(By.cssSelector("input[name='gender'][value='female']"));
        femaleRadioButton.click();
        assertTrue(femaleRadioButton.isEnabled());

        WebElement otherRadioButton = webDriver.findElement(By.cssSelector("input[name='gender'][value='other']"));
        otherRadioButton.click();
        assertTrue(otherRadioButton.isEnabled());
    }

    @Test
    public void check_box_test() {
        webDriver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        WebElement bikeCheckBox = webDriver.findElement(By.cssSelector("input[name='vehicle'][value='Bike']"));
        bikeCheckBox.click();
        assertTrue(bikeCheckBox.isEnabled());

        WebElement carCheckBox = webDriver.findElement(By.cssSelector("input[name='vehicle'][value='Car']"));
        carCheckBox.click();
        assertTrue(carCheckBox.isEnabled());
    }

    @Test
    public void select_test() {
        webDriver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        final By bySelect = By.xpath("//div[@class='et_pb_blurb_description']//descendant::select[1]");
        final Select selectElement = new Select(webDriver.findElement(bySelect));
        assertEquals("Volvo", selectElement.getFirstSelectedOption().getText());

        selectElement.selectByIndex(1);
        assertEquals("Saab", selectElement.getFirstSelectedOption().getText());

        selectElement.selectByVisibleText("Audi");
        assertEquals("Audi", selectElement.getFirstSelectedOption().getText());

        selectElement.selectByValue("volvo");
        assertEquals("Volvo", selectElement.getFirstSelectedOption().getText());

    }

}
