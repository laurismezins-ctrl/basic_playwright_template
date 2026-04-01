package org.my_playwright_template.ai;

import org.my_playwright_template.pages.BasePage;
import com.microsoft.playwright.Locator;

import java.util.Map;

public class StepExecutor {

    private final BasePage basePage;

    public StepExecutor(BasePage basePage) {
        this.basePage = basePage;
    }

    public void execute(TestStep step) {
        try {

            switch (step.action) {

                case "navigate":
                    basePage.page.navigate(step.target);
                    break;

                case "click":
                    basePage.smartClick(step.target);
                    break;

                case "fill":
                    basePage.writeText(basePage.byCss(step.target), step.value);
                    break;

                case "assertVisible":
                    if (!basePage.isVisible(basePage.byCss(step.target))) {
                        throw new RuntimeException("Element not visible: " + step.target);
                    }
                    break;

                case "getText":
                    String text = basePage.getText(basePage.byCss(step.target));
                    System.out.println("Text at " + step.target + " : " + text);
                    break;

                default:
                    throw new RuntimeException("Unknown action: " + step.action);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed executing step: " + step.action, e);
        }
    }
}