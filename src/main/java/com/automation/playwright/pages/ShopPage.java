package com.automation.playwright.pages;

import com.automation.playwright.utils.Steps;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.security.PublicKey;

public class ShopPage extends BasePage{


    protected ShopPage(Page page) {
        super(page);
    }

    private Locator title = page.getByTestId("title");
    private Locator logout_button = page.getByTestId("logout-sidebar-link");
    private Locator Menu = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open Menu"));

    /**
     * @return Locator the page title, e.g. "Products".
     */
    public Locator title() {
        return title;
    }

    public LoginPage openMenu(){
        Steps.log(("Open Menu -Navigation"));
        Menu.click();
        return new LoginPage(page);
    }

    public LoginPage logout(){
        Steps.log("Logout success");
        openMenu();
        logout_button.click();
        return new LoginPage(page);
    }


}
