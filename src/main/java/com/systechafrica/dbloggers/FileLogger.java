package com.systechafrica.dbloggers;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class FileLogger {
    private static final Logger logger = Logger.getLogger(FileLogger.class.getName());

    static {
        try {
            File file = new File("log.txt");
            FileHandler fileHandler;
            if (!file.exists()) {
                fileHandler = new FileHandler("log.txt");
                fileHandler.setFormatter(new CustomFormatter());
                logger.addHandler(fileHandler);
            } else {
                fileHandler = new FileHandler("log.txt", true);
                fileHandler.setFormatter(new CustomFormatter());
                logger.addHandler(fileHandler);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
