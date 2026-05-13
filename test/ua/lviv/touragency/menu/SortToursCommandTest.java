package ua.lviv.touragency.menu;

import org.junit.jupiter.api.Test;
import ua.lviv.touragency.core.TourManager;
import ua.lviv.touragency.model.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

// Тестує команду сортування турів.
public class SortToursCommandTest {

    @Test
    void testSortByPriceFromCommand() {
        TourManager manager = new TourManager();
        manager.clear();
        manager.addTour(new Tour("T1", TourType.REST, "Spain", 7, 700,
                TransportType.PLANE, FoodType.ALL_INCLUSIVE, "A"));
        manager.addTour(new Tour("T2", TourType.REST, "Italy", 5, 500,
                TransportType.BUS, FoodType.BREAKFAST_ONLY, "B"));

        String userInput = "1\n"; // вибір "сортувати за ціною"
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        SortToursCommand cmd = new SortToursCommand(manager);
        boolean exit = cmd.execute();

        System.setOut(System.out);

        assertFalse(exit);

        String text = out.toString();
        assertTrue(text.indexOf("Italy") < text.indexOf("Spain"));
    }
}
