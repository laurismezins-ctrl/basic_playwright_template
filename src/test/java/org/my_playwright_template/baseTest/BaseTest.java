package org.my_playwright_template.baseTest;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.my_playwright_template.agents.FailureAgent;
import org.my_playwright_template.driver.PlaywrightDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    protected PlaywrightDriver driver;
    protected BrowserContext context;
    protected Page page;

    @BeforeEach
    void setUp() {
        driver = PlaywrightDriver.getInstance();
        context = driver.createContext();
        page = context.newPage();
    }


    @AfterMethod
    public void analyzeFailure(ITestResult result) {

        if (!result.isSuccess()) {

            FailureAgent agent = new FailureAgent();

            String analysis = agent.analyze(
                    result.getThrowable().getMessage(),
                    "Test: " + result.getName()
            );

            System.out.println("=== AI FAILURE ANALYSIS ===");
            System.out.println(analysis);
        }
    }

    @AfterEach
    void tearDown() {
        if (context != null) {
            context.close();
        }
        if (driver != null) {
            driver.close();
        }
    }


}