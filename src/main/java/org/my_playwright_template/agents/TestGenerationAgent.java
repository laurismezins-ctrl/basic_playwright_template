package org.my_playwright_template.ai;

import org.my_playwright_template.agents.GeminiClient;

import java.util.Arrays;
import java.util.List;

public class TestGenerationAgent {

    private final GeminiClient client = new GeminiClient();

    public List<String> generateSteps(String scenario) {

        String prompt = """
                Generate Playwright test steps.
                
                Format STRICTLY as JSON array:
                [
                  {"action": "...", "target": "...", "value": "..."}
                ]
                
                Scenario:
                %s
                """.formatted(scenario);

        String response = client.ask(prompt);

        return Arrays.asList(response.split("\n"));
    }

    public String generateRaw(String scenario) {

        String prompt = """
        Generate Playwright test steps.

        Format STRICTLY as JSON array:
        [
          {"action": "...", "target": "...", "value": "..."}
        ]

        Scenario:
        %s
        """.formatted(scenario);

        return client.ask(prompt);
    }
}