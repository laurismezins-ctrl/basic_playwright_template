package org.my_playwright_template.pages.ministryOfTestsPages;

import com.microsoft.playwright.Page;
import org.my_playwright_template.config.Config;
import org.my_playwright_template.pages.BasePage;

public class MOTLandingPage extends BasePage {

    private final Page page;
    private String inputTextFieldId = "search_query";
    private String searchButtonCss = "button[aria-label='search']";

    public MOTLandingPage(Page page) {
        super(page);
        this.page = page;
    }

    public void openMOTLandingPage() {
        page.navigate(Config.getBaseUrlMOT());
    }
    public void inputInSearch(String searchString) {
        writeText(byId(inputTextFieldId), searchString);
    }

    public void pressSearchButton() {
        click(byCss(searchButtonCss));
    }

}
