package org.my_playwright_template.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.my_playwright_template.config.Config;

public class PlaywrightDriver {

    private static PlaywrightDriver instance;
    private final Playwright playwright;
    private final Browser browser;
    Config config = Config.getInstance();

    public PlaywrightDriver() {
        boolean headless = Config.getBoolean("headless");

        this.playwright = Playwright.create();
        BrowserType browserType = getBrowserType();

        this.browser = browserType.launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(headless)
        );
    }

    private BrowserType getBrowserType() {
        BrowserType browserType = switch (config.get("browser")) {
            case "firefox" -> playwright.firefox();
            default -> playwright.chromium();
        };
        return browserType;
    }

    public static PlaywrightDriver getInstance() {
        if (instance == null) {
            instance = new PlaywrightDriver();
        }
        return instance;
    }

    public BrowserContext createContext() {
        return browser.newContext(
                new Browser.NewContextOptions()
                        .setBaseURL(config.get("base.url")));
    }

    public void close() {
        browser.close();
        playwright.close();
    }
}