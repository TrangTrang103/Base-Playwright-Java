package com.automation.playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InventoryPage extends ShopPage {
//    public Page page;
    private static final String URL_HomePage = "/inventory.html";
    private final Locator items = page.getByTestId("Inventory-item");

//    public InventoryTest(LoginPage loginPage) {
//        this.loginPage = loginPage;
//    }


    public InventoryPage(Page page) {
        super(page);
    }


    /**
     * Waits until the product cards are shown.
     */
    public void waitUntilLoaded(){
     assertThat(title()).hasText("Products");
     assertThat(items.first()).isVisible();
    }
    public Locator items(){
        return items;
    }
}
