package ua.lviv.touragency.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Тестує модель Tour: роботу конструктора, гетерів і toString().
public class TourTest {

    @Test
    void testTourFieldsAndToString() {
        Tour tour = new Tour(
                "T1",
                TourType.REST,
                "Spain",
                7,
                750.0,
                TransportType.PLANE,
                FoodType.ALL_INCLUSIVE,
                "Sea vacation"
        );

        assertEquals("T1", tour.getId());
        assertEquals("Spain", tour.getCountry());
        assertEquals(7, tour.getDurationDays());
        assertEquals(750.0, tour.getPrice());

        String out = tour.toString();
        assertTrue(out.contains("Spain"));
        assertTrue(out.contains("REST"));
    }
}
