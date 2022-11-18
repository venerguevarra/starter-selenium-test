package com.bootcamp.it.demo5;

import org.junit.Before;
import org.junit.Test;

import com.bootcamp.it.base.BaseTest;
import com.bootcamp.it.demo5.pages.LoginPage;

public class LoginUITest extends BaseTest {
    private LoginPage loginPage;

    @Before
    public void setup() {
        loginPage = new LoginPage("http://the-internet.herokuapp.com/login", webDriver());
    }

    @Test
    public void given_valid_credentials_should_login_successfully() {
        loginPage.assertions().hasLoginControls();

        loginPage.login("tomsmith", "SuperSecretPassword!");

        loginPage.assertions().isSecureArea("http://the-internet.herokuapp.com/secure");
    }

    @Test
    public void given_valid_credentials_should_logout_successfully() {
        loginPage.assertions().hasLoginControls();

        loginPage.login("tomsmith", "SuperSecretPassword!");

        loginPage.assertions().isSecureArea("http://the-internet.herokuapp.com/secure");

        loginPage.clickLogout();

        loginPage.assertions().hasLoginControls();
    }
}
