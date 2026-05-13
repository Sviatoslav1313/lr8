package ua.lviv.touragency.core;

import ua.lviv.touragency.model.*;
import ua.lviv.touragency.util.AppLogger;

import java.io.*;
import java.util.*;
import java.util.logging.Level;

public class TourManager {

    private final List<Tour> tours = new ArrayList<>();

    /**
     * Повертає копію списку всіх турів.
     */
    public List<Tour> getAllTours() {
        return new ArrayList<>(tours);
    }

    /**
     * Додає тур у список (потрібно для тестів і меню).
     */
    public void addTour(Tour tour) {
        tours.add(tour);
        // Можна логувати додавання вручну, якщо потрібно
        // AppLogger.get().info("Added tour manually: " + tour.getId());
    }

    /**
     * Очищає список турів (потрібно для тестів).
     */
    public void clear() {
        tours.clear();
    }

    /**
     * Завантажує тури з файлу.
     *
     * ФОРМАТ РЯДКА:
     * TYPE;ID;COUNTRY;DAYS;PRICE;TRANSPORT;FOOD;DESCRIPTION
     */
    public int loadFromFile(String filename) throws IOException {
        tours.clear();

        // Логуємо початок процесу
        AppLogger.get().info("Start loading tours from file: " + filename);

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = br.readLine()) != null) {

                if (line.isBlank() || line.startsWith("#"))
                    continue;

                String[] p = line.split(";", -1);
                if (p.length < 8) {
                    // Логуємо попередження про некоректний рядок (не критично, лист не шлемо)
                    AppLogger.get().warning("Skipping invalid line (wrong format): " + line);
                    continue;
                }

                try {
                    Tour tour = new Tour(
                            p[1].trim(),                                      // ID
                            TourType.valueOf(p[0].trim().toUpperCase()),      // TYPE
                            p[2].trim(),                                      // COUNTRY
                            Integer.parseInt(p[3].trim()),                    // DAYS
                            Double.parseDouble(p[4].trim()),                  // PRICE
                            TransportType.valueOf(p[5].trim().toUpperCase()), // TRANSPORT
                            FoodType.valueOf(p[6].trim().toUpperCase()),      // FOOD
                            p[7].trim()                                       // DESCRIPTION
                    );

                    tours.add(tour);
                } catch (Exception e) {
                    // Логуємо помилку парсингу конкретного рядка
                    AppLogger.get().warning("Error parsing tour data in line: " + line + ". Details: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            // === КРИТИЧНА ПОМИЛКА ===
            // Рівень SEVERE активує відправку Email через наш AppLogger
            AppLogger.get().log(Level.SEVERE, "CRITICAL ERROR: File not found: " + filename, e);
            throw e; // Прокидаємо виняток далі, щоб меню повідомило користувача
        } catch (IOException e) {
            // === КРИТИЧНА ПОМИЛКА ===
            AppLogger.get().log(Level.SEVERE, "CRITICAL ERROR: IO Exception reading file: " + filename, e);
            throw e;
        }

        // Логуємо успішне завершення
        AppLogger.get().info("Successfully loaded " + tours.size() + " tours from " + filename);
        return tours.size();
    }
}