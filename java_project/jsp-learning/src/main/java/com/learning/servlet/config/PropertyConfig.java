package com.learning.servlet.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConfig {

    private static final String CONFIG_PROPERTIES = "config.properties";
    private static final Properties properties;

    static {
        properties = new Properties();
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream(CONFIG_PROPERTIES)) {
            if (input == null) {
                // This indicates the file was not found on the classpath
                System.err.println("Sorry, unable to find " + CONFIG_PROPERTIES);
                throw new RuntimeException("Could not find " + CONFIG_PROPERTIES + " on classpath.");
            }

            properties.load(input);
        } catch (IOException ex) {
            System.out.println("error loading the config properties: " + ex.getMessage());
            throw new RuntimeException("Error loading " + CONFIG_PROPERTIES, ex);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
