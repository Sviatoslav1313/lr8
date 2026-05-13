package ua.lviv.touragency.util;

import java.io.IOException;
import java.util.logging.*;

public class AppLogger {

    private static final Logger logger = Logger.getLogger("TourAgencyLog");

    public static void setup() {
        try {
            // Скидаємо стандартні налаштування
            LogManager.getLogManager().reset();

            // 1. Логування у файл log.txt
            FileHandler fileHandler = new FileHandler("log.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);

            // 2. Обробник для відправки пошти (тільки для SEVERE помилок)
            Handler emailHandler = new Handler() {
                @Override
                public void publish(LogRecord record) {
                    if (record.getLevel() == Level.SEVERE) {
                        EmailSender.sendCriticalError(record.getMessage());
                    }
                }

                @Override
                public void flush() {}
                @Override
                public void close() throws SecurityException {}
            };
            emailHandler.setLevel(Level.SEVERE);
            logger.addHandler(emailHandler);

            logger.setLevel(Level.ALL);

        } catch (IOException e) {
            System.err.println("Logger setup failed: " + e.getMessage());
        }
    }

    public static Logger get() {
        return logger;
    }
}