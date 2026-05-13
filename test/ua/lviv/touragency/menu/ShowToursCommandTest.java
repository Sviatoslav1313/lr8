package ua.lviv.touragency.menu;

import org.junit.jupiter.api.Test;
import ua.lviv.touragency.core.TourManager;
import ua.lviv.touragency.model.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

// Тестує команду відображення турів.
public class ShowToursCommandTest {

    @Test
    void testExecutePrintsTours() {
        TourManager manager = new TourManager();
        manager.clear();
        manager.addTour(new Tour("T1", TourType.REST, "Spain", 7, 700,
                TransportType.PLANE, FoodType.ALL_INCLUSIVE, "Rest"));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        ShowToursCommand cmd = new ShowToursCommand(manager);
        boolean exit = cmd.execute();

        System.setOut(System.out);

        assertFalse(exit);
        assertTrue(out.toString().contains("Spain"));
    }
}
