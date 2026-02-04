package org.my_playwright_template.pages.ministryOfTestsPages;

import com.microsoft.playwright.Page;
import org.my_playwright_template.pages.BasePage;

public class MOTSearchResultPage extends BasePage {

    private final Page page;

    private String readLoginDisclaimerBannerCss = "div.fw-3.fw-bolder";


    public MOTSearchResultPage(Page page) {
        super(page);
        this.page = page;
    }

    public String readLoginDisclaimerBanner() {
        return getText(byCss(readLoginDisclaimerBannerCss));
    }

}
