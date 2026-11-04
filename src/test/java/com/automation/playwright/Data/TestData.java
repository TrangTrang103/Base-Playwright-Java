package com.automation.playwright.Data;

import org.testng.annotations.DataProvider;

public class TestData {

    public static final String STANDARD_USER = "standard_user";
    public static final String LOCKED_OUT_USER = "standard_user";


    //msg thong bao tren giao dien
    private static final String NO_MATCH = "Epic sadface: Username and password do not match any user in this service";
    private static final String BLANK = "Epic sadface: Username is required";
    private static final String USER_BLANK = "Epic sadface: Username is required";
    private static final String PASSWORD_BLANK = "Epic sadface: Password is required";
    @DataProvider(name = "rejectLogins")
    public static Object[][] rejectLogins(){
        return new Object[][]{
                {"wrong password", STANDARD_USER, "123456", NO_MATCH, },
                {"wrong user", "leuleu", "secret_sauce", NO_MATCH},
                {"password, user is blank","","",BLANK},
                {"User is Blank", "", "secret_sauce", USER_BLANK },
                {"Password is Blank", "STANDARD_USER", "", PASSWORD_BLANK }
        };
    }
}
