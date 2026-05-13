package ua.lviv.touragency.service;

import ua.lviv.touragency.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class FilterService {

    public List<Tour> filterByType(List<Tour> list, TourType type) {
        return list.stream()
                .filter(t -> t.getType() == type)
                .collect(Collectors.toList());
    }

    public List<Tour> filterByMaxPrice(List<Tour> list, double maxPrice) {
        return list.stream()
                .filter(t -> t.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public List<Tour> filterByCountry(List<Tour> list, String country) {
        return list.stream()
                .filter(t -> t.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
    }
}
