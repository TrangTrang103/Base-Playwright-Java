package com.automation.playwright.base;

import com.automation.playwright.browser.BrowserManager;
import com.automation.playwright.pages.ui.LoginPage;
import com.microsoft.playwright.Page;

import java.security.PublicKey;

import static com.automation.playwright.browser.BrowserManager.page;

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

}
