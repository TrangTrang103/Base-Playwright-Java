package com.automation.playwright.base;

import com.automation.playwright.browser.BrowserManager;
import com.automation.playwright.pages.InventoryPage;
import com.automation.playwright.pages.LoginPage;
import com.automation.playwright.report.HtmlReportListener;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public abstract class UITest extends PlaywrightTest {

    /**
     * Opens a new context and page for the test.
     *
     * @param method the test method about to run, used as the trace title.
     */
    @BeforeMethod(alwaysRun = true)
    public void openPage(Method method) {
        BrowserManager.startTest(getClass().getSimpleName() + "." + method.getName());
    }

    /**
     * Takes a screenshot if the test failed, then closes the context, keeping
     * the trace and video of a failed test.
     *
     * @param result the result of the test that just ran.
     */
    @AfterMethod(alwaysRun = true)
    public void closePage(ITestResult result) {
        if (!BrowserManager.hasPage()) {
            return;
        }
        boolean failed = result.getStatus() == ITestResult.FAILURE;
        // Class_method_time, so data-provider rows and reruns never overwrite each other
        String fileName = getClass().getSimpleName() + "_" + result.getMethod().getMethodName() + "_" + System.currentTimeMillis();
        if (failed) {
            attachScreenshot(result, fileName);
        }
        BrowserManager.Artifacts artifacts = BrowserManager.finishTest(fileName, failed);
        if (artifacts.trace() != null) {
            result.setAttribute(HtmlReportListener.TRACE, artifacts.trace());
        }
        if (artifacts.video() != null) {
            result.setAttribute(HtmlReportListener.VIDEO, artifacts.video());
        }
    }

    /**
     * @return Page the page of the running test.
     */
    protected Page page() {
        return BrowserManager.page();
    }
    /**
     * @return LoginPage the login page, opened.
     */
    protected LoginPage openLoginPage() {
        return new LoginPage(page()).openPage();
    }

    protected InventoryPage inventoryPage(String user){
        return openLoginPage().loginAs(user);
    }

    private void attachScreenshot(ITestResult result, String fileName) {
        try {
            byte[] png = page().screenshot(new Page.ScreenshotOptions().setFullPage(true));
            result.setAttribute(HtmlReportListener.SCREENSHOT, Base64.getEncoder().encodeToString(png));
            Path file = BrowserManager.ARTIFACT_DIR.resolve(fileName + "-screenshot.png");
            Files.createDirectories(file.getParent());
            Files.write(file, png);
        } catch (PlaywrightException | IOException e) {
            System.err.println("Could not take a screenshot of " + result.getName() + ": " + e.getMessage());
        }
    }
}
