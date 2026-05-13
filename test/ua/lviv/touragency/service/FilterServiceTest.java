package ua.lviv.touragency.service;

import org.junit.jupiter.api.Test;
import ua.lviv.touragency.model.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Тестує фільтрацію за типом, країною та максимальною ціною.
public class FilterServiceTest {

    private List<Tour> sample() {
        return List.of(
                new Tour("T1", TourType.REST, "Spain", 7, 700,
                        TransportType.PLANE, FoodType.ALL_INCLUSIVE, "Rest tour"),
                new Tour("T2", TourType.EXCURSION, "Italy", 5, 500,
                        TransportType.BUS, FoodType.BREAKFAST_ONLY, "Exc tour"),
                new Tour("T3", TourType.REST, "Italy", 10, 900,
                        TransportType.PLANE, FoodType.FULL_BOARD, "Rest 2")
        );
    }

    @Test
    void testFilterByType() {
        FilterService s = new FilterService();
        List<Tour> r = s.filterByType(sample(), TourType.REST);

        assertEquals(2, r.size());
        assertTrue(r.stream().allMatch(t -> t.getType() == TourType.REST));
    }

    @Test
    void testFilterByCountry() {
        FilterService s = new FilterService();
        List<Tour> r = s.filterByCountry(sample(), "Italy");

        assertEquals(2, r.size());
        assertTrue(r.stream().allMatch(t -> t.getCountry().equalsIgnoreCase("Italy")));
    }

    @Test
    void testFilterByMaxPrice() {
        FilterService s = new FilterService();
        List<Tour> r = s.filterByMaxPrice(sample(), 700);

        assertEquals(2, r.size());
        assertTrue(r.stream().allMatch(t -> t.getPrice() <= 700));
    }
}
