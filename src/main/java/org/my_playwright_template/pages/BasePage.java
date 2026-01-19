package org.my_playwright_template.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {

    protected final Page page;

    public String pageTitleXpath = "//title";
    public String pageTitlesXpath = "//@title";

    public BasePage(Page page) {
        this.page = page;
    }

    /*
    * bunch of generated element getters
    */

    public Locator byCss(String selector) {
        return page.locator(selector);
    }

    public Locator byXpath(String xpath) {
        return page.locator("xpath=" + xpath);
    }

    public Locator byId(String id) {
        return page.locator("#" + id);
    }

    public Locator byText(String text) {
        return page.getByText(text);
    }

    /*
     * bunch of generated element actions
     */

    public void click(Locator locator) {
        locator.waitFor();
        locator.click();
    }

    public void writeText(Locator locator, String text) {
        locator.waitFor();
        locator.fill(text);
    }

    public String getText(Locator locator) {
        locator.waitFor();
        return locator.textContent();
    }

    public boolean isVisible(Locator locator) {
        return locator.isVisible();
    }

}
