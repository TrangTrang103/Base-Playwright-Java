package com.automation.playwright.ui;

import com.automation.playwright.Data.TestData;
import com.automation.playwright.base.UITest;
import com.automation.playwright.config.Config;
import com.automation.playwright.pages.InventoryPage;
import com.automation.playwright.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


@Test(groups = "login")
public class LoginTest extends UITest {

   @Test(groups = "smoke", description = "Logout success")
   public void logoutSuccess(){
      LoginPage logoutSuccess = openLoginPage().loginAs(TestData.STANDARD_USER).logout();
      assertThat(logoutSuccess.loginButton()).isVisible();
      assertThat(logoutSuccess.page()).not().hasURL(Pattern.compile(".*/inventory\\.html"));

   }
   @Test(groups = "smoke", description = "Login success")
   public void loginSuccess(){
      InventoryPage inventoryPage = openLoginPage().loginAs(TestData.STANDARD_USER);
       assertThat(inventoryPage.page()).hasURL(Pattern.compile(".*/inventory\\.html"));
       assertThat(inventoryPage.title()).hasText("Products");
       assertThat(inventoryPage.items()).hasCount(7);
   }


   /* Case Nagative Login */
   @Test(dataProvider = "rejectLogins", dataProviderClass = TestData.class, description ="Case Nagative Login")
   public void loginIsRejected(String caseName,String username, String password, String expected){
   LoginPage login = new LoginPage(page());
   login.openPage();
   login.submit(username,password);
    // LoginPage login = openLoginPage().submit(username,password);
      assertThat(login.error()).hasText(expected);
      assertThat(login.error()).isVisible();
   }

   @Test(groups = "smoke" , description = "loginwithKeyboard")
   public void loginKeyboard(){
      LoginPage loginPage = new LoginPage(page());
      loginPage.openPage().loginWithKeyBoard(TestData.STANDARD_USER, Config.get().password());
      assertThat(loginPage.page()).hasURL(Pattern.compile(".*/inventory\\.html"));
   }

   @Test(groups = "smoke", description = "try open API = inventory.html not login ")
   public void tryOnAPINotLogin(){
     LoginPage loginPage = new LoginPage(page());
     loginPage.tryOnAPI();
     assertThat(loginPage.page()).hasURL("/");
     assertThat(loginPage.error()).isVisible();
   }
}
