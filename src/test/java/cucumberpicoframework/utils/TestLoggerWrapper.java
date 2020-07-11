package cucumberpicoframework.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestLoggerWrapper {
    private static Logger logger;
    private static FileHandler fileHandler;
    private static boolean initialized = false;

    private TestLoggerWrapper() {
    }

    public static Logger getInstance() throws IOException {
        if (initialized) return logger;
        logger = Logger.getLogger(Config.getInstance().getProperty("logger.name"));
        FileHandler handler = fileHandlerWrapper();
        SimpleFormatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);
        logger.addHandler(handler);
        initialized = true;
        return logger;
    }

    private static FileHandler fileHandlerWrapper() {
        try {
            String logFileName = Config.getInstance().getProperty("logfile.name");
            fileHandler = new FileHandler(logFileName, true);
        } catch (Exception fileHandlerException) {
            fileHandlerException.printStackTrace();
        }
        return fileHandler;
    }
}
