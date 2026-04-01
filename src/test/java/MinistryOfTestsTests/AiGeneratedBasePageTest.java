package org.my_playwright_template.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.my_playwright_template.ai.TestGenerationAgent;
import org.my_playwright_template.config.Config;
import org.my_playwright_template.pages.BasePage;
import org.my_playwright_template.ai.*;

import java.util.List;

public class AiGeneratedBasePageTest {

    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;
    BasePage basePage;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeEach
    void setup() {
        context = browser.newContext();
        page = context.newPage();
        basePage = new BasePage(page);
    }

    @AfterEach
    void teardown() {
        context.close();
    }

    @AfterAll
    static void closeBrowser() {
        browser.close();
        playwright.close();
    }

    @Test
    void aiGeneratedBasePageTest() {

        TestGenerationAgent agent = new TestGenerationAgent();

        // AI prompt: it should produce JSON steps for BasePage methods
        String aiJson = agent.generateRaw(
                String.format("Open %s, fill form fields, click submit, verify success", Config.getBaseUrlMOT())
        );

        System.out.println("AI RESPONSE:\n" + aiJson);

        List<TestStep> steps = StepParser.parse(aiJson);

        StepExecutor executor = new StepExecutor(basePage);

        for (TestStep step : steps) {
            System.out.println("Executing: " + step.action + " -> " + step.target);
            executor.execute(step);
        }
    }
}