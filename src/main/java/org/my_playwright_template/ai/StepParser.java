package org.my_playwright_template.ai;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class StepParser {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<TestStep> parse(String json) {
        try {
            return mapper.readValue(json, new TypeReference<List<TestStep>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse AI steps: " + json, e);
        }
    }
}