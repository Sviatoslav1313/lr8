package ua.lviv.touragency.service;

import org.junit.jupiter.api.Test;
import ua.lviv.touragency.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Тестує сортування за ціною і тривалістю.
public class SortServiceTest {

    private List<Tour> sample() {
        return new ArrayList<>(List.of(
                new Tour("T1", TourType.REST, "Spain", 7, 700,
                        TransportType.PLANE, FoodType.ALL_INCLUSIVE, "A"),
                new Tour("T2", TourType.REST, "Italy", 10, 500,
                        TransportType.BUS, FoodType.BREAKFAST_ONLY, "B"),
                new Tour("T3", TourType.EXCURSION, "France", 3, 900,
                        TransportType.PLANE, FoodType.HALF_BOARD, "C")
        ));
    }

    @Test
    void testSortByPrice() {
        SortService s = new SortService();
        List<Tour> list = sample();

        s.sortByPrice(list);

        assertEquals(500, list.get(0).getPrice());
        assertEquals(700, list.get(1).getPrice());
        assertEquals(900, list.get(2).getPrice());
    }

    @Test
    void testSortByDuration() {
        SortService s = new SortService();
        List<Tour> list = sample();

        s.sortByDuration(list);

        assertEquals(3, list.get(0).getDurationDays());
        assertEquals(7, list.get(1).getDurationDays());
        assertEquals(10, list.get(2).getDurationDays());
    }
}
