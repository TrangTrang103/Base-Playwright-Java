package com.automation.playwright.Data;

import org.testng.annotations.DataProvider;

public class TestData {

    private static final String STANDARD_USER = "standard_user";
    private static final String LOCKED_OUT_USER = "standard_user";

    @DataProvider(name = "rejectLogins")
    public static Object[][] rejectLogins(){
        return new Object[][]{

        }
    }
}
