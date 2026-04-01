package org.my_playwright_template.agents;

public class SelectorAgent {

    private final GeminiClient client = new GeminiClient();

    public String heal(String brokenSelector, String html) {

        String prompt = """
        A Playwright selector failed.

        Broken selector:
        %s

        HTML:
        %s

        Provide a better, stable selector.
        Prefer:
        - data-testid
        - id
        - role-based selectors
        """.formatted(brokenSelector, html);

        return client.ask(prompt).trim();
    }
}