package com.automation.playwright.base;

import com.automation.playwright.browser.BrowserManager;
import com.automation.playwright.pages.InventoryPage;
import com.automation.playwright.pages.LoginPage;
import com.microsoft.playwright.Page;

public abstract class UITest extends PlaywrightTest {

    /**
     * @return Page the page of the running test.
     */
    protected Page page() {
        return BrowserManager.page();
    }
    /**
     * @return LoginPage the login page, opened.
     */
    protected LoginPage openLoginPage() {
        return new LoginPage(page()).openPage();
    }

    protected InventoryPage inventoryPage(String user){
        return openLoginPage().loginAs(user);
    }

}
