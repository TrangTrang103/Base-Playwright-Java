package com.automation.playwright.pages;

import com.microsoft.playwright.Page;

public abstract class BasePage {

    // The browser tab this page works on
    protected final Page page;

    protected BasePage(Page page) {
        this.page = page;
    }
    public Page page() {
        return page;
    }

//    public BasePage() {
//    }
}
