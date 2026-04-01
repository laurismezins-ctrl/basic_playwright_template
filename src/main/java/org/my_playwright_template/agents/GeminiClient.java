package org.my_playwright_template.agents;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class GeminiClient {

    private final String apiKey = System.getenv("GEMINI_API_KEY");
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public String ask(String prompt) {
        try {
            String body = mapper.writeValueAsString(Map.of(
                    "contents", new Object[] {
                            Map.of(
                                    "parts", new Object[] {
                                            Map.of("text", prompt)
                                    }
                            )
                    }
            ));

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(
                            "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + apiKey
                    ))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            // Debug (important)
            System.out.println("Gemini raw response: " + response.body());

            return mapper.readTree(response.body())
                    .get("candidates").get(0)
                    .get("content").get("parts").get(0)
                    .get("text")
                    .asText();

        } catch (Exception e) {
            throw new RuntimeException("Gemini API call failed", e);
        }
    }
}