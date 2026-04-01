package org.my_playwright_template.ai;

import org.my_playwright_template.agents.GeminiClient;

import java.util.Arrays;
import java.util.List;

public class TestGenerationAgent {

    private final GeminiClient client = new GeminiClient();

    public List<String> generateSteps(String scenario) {

        String prompt = """
        Generate Playwright Java test steps for:
        %s

        Keep steps short and executable.
        """.formatted(scenario);

        String response = client.ask(prompt);

        return Arrays.asList(response.split("\n"));
    }
}