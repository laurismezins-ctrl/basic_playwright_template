package org.my_playwright_template.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public final String fileName = "testProperties";
    public static Properties properties = new Properties();
    private static Config config;

    public Config() throws IOException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        properties = new Properties();

        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property not found: " + fileName);
        }
    }
    public static Config getInstance() {
        if (config == null) {
            try {
                config = new Config();
            } catch (IOException e) {
                throw new RuntimeException("Failed to load properties file", e);
            }
        }
        return config;
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public static String getBaseUrl() {
        return get("base.url");
    }
    public static String getBaseUrlMOT() {
        return get("ministryoftesting.url");
    }

}
