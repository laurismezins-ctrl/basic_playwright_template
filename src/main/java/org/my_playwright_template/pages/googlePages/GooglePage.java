package org.my_playwright_template.pages.googlePages;

import com.microsoft.playwright.Page;
import org.my_playwright_template.config.Config;
import org.my_playwright_template.pages.BasePage;

public class GooglePage extends BasePage {
    private final Page page;
    private String inputTextFieldXpath = "//textarea[@class='gLFyf']";

    public GooglePage(Page page) {
        super(page);
        this.page = page;
    }

    public void openGoogle() {
        page.navigate(Config.getBaseUrl());
    }

    public String getTitle() {
        return page.title();
    }

    public void inputInSearch(String username) {
        writeText(byXpath(inputTextFieldXpath), username);
    }
}