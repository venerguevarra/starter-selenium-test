package com.bootcamp.it.demo4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.bootcamp.it.base.BaseTest;

public class ContextMenu2Test extends BaseTest {
    @Test
    public void context_menu_test() {
        webDriver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(webDriver());
        WebElement hotSpotElement = webDriver.findElement(By.id("hot-spot"));
        actions.moveByOffset(hotSpotElement.getLocation().getX() + 1, hotSpotElement.getLocation().getY() + 1).contextClick(hotSpotElement).perform();
        // actions.moveToElement(hotSpotElement, 10, 25).contextClick().build().perform();

        String alertText = webDriver.switchTo().alert().getText();
        assertEquals("You selected a context menu", alertText);
    }

}
