package ua.lviv.touragency.core;

import org.junit.jupiter.api.Test;
import ua.lviv.touragency.model.*;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Тестує завантаження турів із файлу.
// Перевіряє правильність парсингу даних і додавання турів у менеджер.
public class TourManagerTest {

    @Test
    void testLoadFromFile() throws Exception {
        Path temp = Files.createTempFile("tours", ".txt");
        temp.toFile().deleteOnExit();

        try (FileWriter fw = new FileWriter(temp.toFile())) {
            fw.write("REST;T1;Spain;7;700;PLANE;ALL_INCLUSIVE;Rest tour\n");
            fw.write("EXCURSION;T2;Italy;5;500;BUS;BREAKFAST_ONLY;Exc tour\n");
        }

        TourManager manager = new TourManager();
        int count = manager.loadFromFile(temp.toString());

        assertEquals(2, count);
        List<Tour> list = manager.getAllTours();
        assertEquals("T1", list.get(0).getId());
    }
}
