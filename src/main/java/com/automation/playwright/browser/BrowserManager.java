package com.automation.playwright.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BrowserManager {
    public BrowserManager() {}


    private static final List<Playwright> ALL = new CopyOnWriteArrayList<>();
    private static final ThreadLocal<Playwright> PLAYWRIGHT = new ThreadLocal<>();
    private static final ThreadLocal<Browser> BROWSER = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> BROWSER_CONTEXT = new ThreadLocal<>();
    private static final ThreadLocal<Page> PAGE = new ThreadLocal<>();

    public static Playwright playwright(){
        Playwright playwright = PLAYWRIGHT.get();
        if(playwright == null){
            playwright = Playwright.create();
            playwright.selectors().setTestIdAttribute("data-test");
            PlaywrightAssertions.setDefaultAssertionTimeout(Config.get());
        }
    }




}
