package main.java.com.dnasequencing.utils;

// usage of external libraries.

import java.io.IOException;
import java.util.logging.*;

// LoggerUtils provides a utility for logging events in the application.
public class LoggerUtils {
    private static final Logger logger = Logger.getLogger(LoggerUtils.class.getName());
    private static FileHandler fileHandler;

    // configures the logger when the class is loaded.
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

    /**
     * Returns the configured logger instance.
     * @return logger instance.
     */
    public static Logger getLogger() {
        return logger;
    }
}
