package org.my_playwright_template.pages;

import com.microsoft.playwright.Page;
import org.my_playwright_template.config.Config;

public class GooglePage {
    private final Page page;

    public GooglePage(Page page) {
        this.page = page;
    }

    public void openGoogle() {
        page.navigate(Config.getBaseUrl());
    }

    public String getTitle() {
        return page.title();
    }
}