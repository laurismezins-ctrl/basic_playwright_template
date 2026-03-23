package org.my_playwright_template.agents;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class ClaudeClient {

    private final String apiKey = System.getenv("CLAUDE_API_KEY");
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public String ask(String prompt) {
        try {
            String body = mapper.writeValueAsString(Map.of(
                    "model", "claude-3-sonnet-20240229",
                    "max_tokens", 1000,
                    "messages", new Object[] {
                            Map.of("role", "user", "content", prompt)
                    }
            ));

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.anthropic.com/v1/messages"))
                    .header("Content-Type", "application/json")
                    .header("x-api-key", apiKey)
                    .header("anthropic-version", "2023-06-01")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return mapper.readTree(response.body())
                    .get("content").get(0).get("text").asText();

        } catch (Exception e) {
            throw new RuntimeException("Claude API call failed", e);
        }
    }
}