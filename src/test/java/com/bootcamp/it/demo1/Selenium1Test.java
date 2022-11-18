package com.bootcamp.it.demo1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import com.bootcamp.it.base.BaseTest;

public class Selenium1Test extends BaseTest {
    @Test
    public void shouldRenderGoogleHomePage() {
        webDriver.get("https://www.google.com/");
        assertEquals("Google", webDriver.getTitle());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
