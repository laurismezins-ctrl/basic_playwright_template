package org.my_playwright_template.agents;

public class FailureAgent {

    private final ClaudeClient client = new ClaudeClient();

    public String analyze(String error, String context) {

        String prompt = """
        Analyze this Playwright test failure.

        Error:
        %s

        Context:
        %s

        Provide:
        1. Root cause
        2. Fix suggestion
        """.formatted(error, context);

        return client.ask(prompt);
    }
}