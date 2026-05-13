package ua.lviv.touragency.menu;

import org.junit.jupiter.api.Test;
import ua.lviv.touragency.core.TourManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

// Тестує команду завантаження турів.
public class LoadToursCommandTest {

    @Test
    void testExecuteLoadsFromFile() throws Exception {
        Path temp = Files.createTempFile("tours_cmd", ".txt");
        temp.toFile().deleteOnExit();

        try (FileWriter fw = new FileWriter(temp.toFile())) {
            fw.write("REST;T1;Spain;7;700;PLANE;ALL_INCLUSIVE;Rest tour\n");
        }

        String userInput = temp.toString() + "\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        TourManager manager = new TourManager();
        LoadToursCommand cmd = new LoadToursCommand(manager);

        boolean exit = cmd.execute();

        assertFalse(exit);
        assertEquals(1, manager.getAllTours().size());
    }
}
