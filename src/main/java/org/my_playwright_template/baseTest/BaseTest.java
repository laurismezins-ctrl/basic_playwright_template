package org.my_playwright_template.baseTest;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.my_playwright_template.driver.PlaywrightDriver;

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