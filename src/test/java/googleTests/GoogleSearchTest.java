package googleTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.my_playwright_template.baseTest.BaseTest;
import org.my_playwright_template.pages.GooglePage;

public class GoogleSearchTest extends BaseTest {
    @Test
    void titleTest() {
        GooglePage googlePage = new GooglePage(page);
        googlePage.openGoogle();

        String title = googlePage.getTitle();
        System.out.println("Page title: " + title);

        Assertions.assertTrue(title.contains("Google"),
                "Title should contain 'Google'");
    }
}
