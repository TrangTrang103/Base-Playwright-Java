package com.automation.playwright.pages;

import com.automation.playwright.config.Config;
import com.automation.playwright.utils.Steps;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    
    private Locator userName = page.getByTestId("username");
    private Locator password = page.getByTestId("password");
    private Locator loginButton = page.getByTestId("login-button");

    private Locator error = page.getByTestId("error");
    public LoginPage(Page page) {
        super(page);
    }

//    public LoginPage() {
//
//    }

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

    public InventoryPage loginAs(String user){
        submit(user, Config.get().password());
        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.title().or(error).first().waitFor();
        if (error.isVisible()){
            throw new IllegalStateException("Login as \"" + user + "\" failed: " + error.innerText());

        }
       inventoryPage.waitUntilLoaded();
        return inventoryPage;

    }
    public LoginPage openPage(){
        Steps.log("Open the login page");
        page.navigate("/");
        return this;
    }
    public Locator error(){
        Steps.log("Msg error");
        return error;
    }
    public Locator loginButton(){
        Steps.log("Login Button");
        return loginButton;
    }
}
