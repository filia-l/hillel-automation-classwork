package core.utils;

import core.BaseUrl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UrlBuilder {

    private UrlBuilder() {
    }

    public static <T> String buildUrl(final Class<T> page,final String partialUrl) {
        final String baseUrl = page.getAnnotation(BaseUrl.class).value();
        return String.format("%s/%s", baseUrl, partialUrl);
    }

    public static String getPropertyValue(final String key) {
        final Properties testProperties = new Properties();
        try {
            testProperties.load(new FileInputStream("src/main/resources/properties/test.properties"));
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read property file!", e);
        }
        return testProperties.getProperty(key);
    }

    public static String buildUrlUsingProperties(final String key, final String partialUrl) {
        final String propValue = getPropertyValue(key);
        return String.format("%s/%s", propValue, partialUrl);
    }
}
