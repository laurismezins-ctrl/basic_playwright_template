package MinistryOfTestsTests;

import org.junit.jupiter.api.Test;
import org.my_playwright_template.ai.TestGenerationAgent;
import org.my_playwright_template.baseTest.BaseTest;
import org.my_playwright_template.config.Config;

import java.util.List;

public class MOTBasicTestAIUse extends BaseTest {

    @Test
    public void aiGeneratedSteps() {
        String scenario = "open the mot page url : %s \n" +
        "input search query :  %s\n" +
        "submit the query search\n" +
        " I am navigated to new page with a disclaimer \"Must be logged in to use global search\"";
        TestGenerationAgent agent = new TestGenerationAgent();

        List<String> steps = agent.generateSteps(
        String.format(scenario, Config.getBaseUrlMOT(),"test")

        );

        steps.forEach(System.out::println);
    }

}
