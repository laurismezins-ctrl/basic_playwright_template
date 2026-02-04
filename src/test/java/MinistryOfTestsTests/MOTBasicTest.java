package MinistryOfTestsTests;

import org.junit.jupiter.api.Test;
import org.my_playwright_template.baseTest.BaseTest;
import org.my_playwright_template.pages.ministryOfTestsPages.MOTLandingPage;
import org.my_playwright_template.pages.ministryOfTestsPages.MOTSearchResultPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MOTBasicTest extends BaseTest {
    /*
    * some description here
    * */

    @Test
    void mOTBasicTest() {
//  open the mot page
        MOTLandingPage mOTLandingPage = new MOTLandingPage(page);
        mOTLandingPage.openMOTLandingPage();

//  input search query
        mOTLandingPage.inputInSearch("test");

//  submit the query search
        mOTLandingPage.pressSearchButton();

//  I am navigated to new page with a disclaimer "Must be logged in to use global search"
        MOTSearchResultPage mOTSearchResultPage = new MOTSearchResultPage(page);
        String currentDisclaimer = mOTSearchResultPage.readLoginDisclaimerBanner();
        assertTrue(currentDisclaimer.contains("Must be logged in to use global search"));
    }
}
