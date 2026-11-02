package com.automation.playwright.pages.ui;

import com.automation.playwright.utils.Steps;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;
    private Locator userName = page.getByTestId("username");
    private Locator password = page.getByTestId("password");
    private Locator loginButton = page.getByTestId("login-button");

    public LoginPage(Page page) {
        this.page = page;
    }

    public LoginPage() {
    }

    public Page getPage() {
        return page;
    }

    public LoginPage submit(String user, String secret){
        Steps.log("Log in with username: \" " + user + "\" and password \"" + "*".repeat(secret.length()) + "\"");
        userName.fill(user);
        password.fill(secret);
        loginButton.click();
        return this;
    }

    public LoginPage openPage(){
        Steps.log("Open the login page");
        page.navigate("/");
        return this;
    }
}
