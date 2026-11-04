package com.automation.playwright.ui;

import com.automation.playwright.Data.TestData;
import com.automation.playwright.base.UITest;
import com.automation.playwright.pages.InventoryPage;
import com.automation.playwright.pages.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


@Test(groups = "login")
public class LoginTest extends UITest {


   @Test(groups = "smoke")
   public void loginSuccess(){
      InventoryPage inventoryPage = openLoginPage().loginAs(TestData.STANDARD_USER);
      assertThat(inventoryPage.page()).hasURL(".*/inventory\\.html");
      assertThat(inventoryPage.title()).hasText("Product");
      assertThat(inventoryPage.items()).hasCount(6);
   }

   /* Case Nagative Login */
   @Test(dataProvider = "rejectLogins", dataProviderClass = TestData.class, description ="Case Nagative Login")
   public void loginIsRejected(String caseName,String username, String password, String expected){

//      loginPage.openPage();
//      loginPage.submit(username,password);
     LoginPage login = openLoginPage().submit(username,password);
      assertThat(login.error()).hasText(expected);
      assertThat(login.error()).isVisible();
   }
}
