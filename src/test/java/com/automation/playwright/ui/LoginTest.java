package com.automation.playwright.ui;

import com.automation.playwright.Data.TestData;
import com.automation.playwright.base.UITest;
import com.automation.playwright.pages.ui.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


@Test(groups = "login")
public class LoginTest extends UITest {

   Page page;
   @Test(dataProvider = "rejectedLogin", dataProviderClass = TestData.class)
   public void loginIsRejected(String caseName,String username, String password, String expected){
      LoginPage loginPage = new LoginPage();
      loginPage.openPage();
      loginPage.submit(username,password);
     /LoginPage login = openLoginPage().submit(username,password);
      assertThat(login.openPage())
   }
}
