package ua.lviv.touragency.service;

import ua.lviv.touragency.model.Tour;

import java.util.Comparator;
import java.util.List;

public class SortService {

    public List<Tour> sortByPrice(List<Tour> list) {
        list.sort(Comparator.comparingDouble(Tour::getPrice));
        return list;
    }

    public List<Tour> sortByDuration(List<Tour> list) {
        list.sort(Comparator.comparingInt(Tour::getDurationDays));
        return list;
    }
}
