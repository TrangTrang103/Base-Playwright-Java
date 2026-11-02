package com.automation.playwright.base;

import com.automation.playwright.browser.BrowserManager;
import org.testng.annotations.AfterSuite;

public abstract class PlaywrightTest {

    @AfterSuite(alwaysRun = true)
    public void closePlaywright(){
        BrowserManager.closeAll();
    }
}
