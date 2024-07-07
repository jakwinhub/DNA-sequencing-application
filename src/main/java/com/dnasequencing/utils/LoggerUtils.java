package main.java.com.dnasequencing.utils;

import java.io.IOException;
import java.util.logging.*;

public class LoggerUtils {
    private static final Logger logger = Logger.getLogger(LoggerUtils.class.getName());
    private static FileHandler fileHandler;

    static {
        try {
            // Configure the logger with a handler and formatter
            fileHandler = new FileHandler("DNAAnalyzer.log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);

            // Remove the console handler to avoid duplicate logging
            Logger rootLogger = Logger.getLogger("");
            Handler[] handlers = rootLogger.getHandlers();
            if (handlers[0] instanceof ConsoleHandler) {
                rootLogger.removeHandler(handlers[0]);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize logger handler.", e);
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
