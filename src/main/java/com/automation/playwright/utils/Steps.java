package com.automation.playwright.utils;

import org.testng.Reporter;

public final class Steps {

    private Steps() {
    }

    /**
     * @param step a short description of what the test is doing, e.g. "Log in as standard_user".
     */

    public static void log(String step){
        Reporter.log(step);
    }
}
