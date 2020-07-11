package cucumberpicoframework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {
    private static boolean initialised = false;
    private static Properties properties = new Properties();

    private Config() {}

    public static Properties getInstance() throws IOException {
        if (initialised) return properties;
        try {
            Path javaDir = Paths.get(System.getProperty("user.dir"));
            String configFile = String.format("%s/src/test/resources/%s", javaDir, "testconfig.properties");
            FileInputStream fs = new FileInputStream(configFile);
            initialised = true;
            properties.load(fs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
