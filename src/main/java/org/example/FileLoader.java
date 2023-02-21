package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileLoader {

    public static Properties loadFile(String path) throws IOException {

        InputStream configFile = null;
        Properties properties = null;

        try {
            configFile = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
            properties = new Properties();
            properties.load(configFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            configFile.close();
        }
        return properties;
    }
}
