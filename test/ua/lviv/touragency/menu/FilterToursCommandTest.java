package ua.lviv.touragency.menu;

import org.junit.jupiter.api.Test;
import ua.lviv.touragency.core.TourManager;
import ua.lviv.touragency.model.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FilterToursCommandTest {

    @Test
    void testFilterByTypeFromCommand() {
        // готуємо дані
        TourManager manager = new TourManager();
        manager.clear();
        manager.addTour(new Tour("T1", TourType.REST, "Spain", 7, 700,
                TransportType.PLANE, FoodType.ALL_INCLUSIVE, "Rest tour"));
        manager.addTour(new Tour("T2", TourType.EXCURSION, "Italy", 5, 500,
                TransportType.BUS, FoodType.BREAKFAST_ONLY, "Exc tour"));

        // користувач вводить:
        // 1  -> вибір "фільтрація за типом"
        // REST -> тип туру
        String userInput = "1\nREST\n";


        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;

        try {
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));

            FilterToursCommand cmd = new FilterToursCommand(manager);
            boolean exit = cmd.execute();

            System.setOut(oldOut);

            String text = out.toString();
            // очікуємо, що виведеться тільки тур Spain (REST),
            // а про Italy (EXCURSION) нічого не буде
            assertFalse(exit);
            assertTrue(text.contains("Spain"));
            assertFalse(text.contains("Italy"));

        } finally {
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
    }
    @Test
    void testFilterByCountryFromCommand() {

        TourManager manager = new TourManager();
        manager.clear();
        manager.addTour(new Tour("T1", TourType.REST, "Spain", 7, 700,
                TransportType.PLANE, FoodType.ALL_INCLUSIVE, "Rest tour"));



        String userInput = "2\nSpain\n";

        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;

        try {
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));

            FilterToursCommand cmd = new FilterToursCommand(manager);
            boolean exit = cmd.execute();

            System.setOut(oldOut);

            String text = out.toString();

            assertFalse(exit);
            assertTrue(text.contains("Spain"));

        } finally {
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
    }

}
