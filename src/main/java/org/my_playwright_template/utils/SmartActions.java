package org.my_playwright_template.utils;

import com.microsoft.playwright.Page;
import org.my_playwright_template.agents.SelectorAgent;

public class SmartActions {

    public static void click(Page page, String selector) {
        try {
            page.click(selector);
        } catch (Exception e) {
            System.out.println("Selector failed: " + selector);

            String html = page.content();

            SelectorAgent agent = new SelectorAgent();
            String healed = agent.heal(selector, html);

            System.out.println("AI healed selector: " + healed);

            page.click(healed);
        }
    }
}