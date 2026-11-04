package com.automation.playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.security.PublicKey;

public class ShopPage extends BasePage{


    protected ShopPage(Page page) {
        super(page);
    }

    private Locator title = page.getByTestId("title");



    /**
     * @return Locator the page title, e.g. "Products".
     */
    public Locator title() {
        return title;
    }

}
