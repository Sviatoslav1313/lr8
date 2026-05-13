package ua.lviv.touragency.menu;

import ua.lviv.touragency.core.TourManager;
import ua.lviv.touragency.model.*;
import ua.lviv.touragency.service.FilterService;

import java.util.List;
import java.util.Scanner;

public class FilterToursCommand implements Command {

    private final TourManager manager;
    private final FilterService filter = new FilterService();

    public FilterToursCommand(TourManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "Фільтрувати тури";
    }

    @Override
    public boolean execute() {

        Scanner sc = new Scanner(System.in);
        System.out.println("1 — за типом");
        System.out.println("2 — за країною");
        System.out.println("3 — за максимальною ціною");
        System.out.print("Ваш вибір: ");

        int ch = Integer.parseInt(sc.nextLine());
        List<Tour> list = manager.getAllTours();

        switch (ch) {
            case 1 -> {
                System.out.print("Введіть тип (REST, EXCURSION...): ");
                TourType t = TourType.valueOf(sc.nextLine().trim().toUpperCase());
                filter.filterByType(list, t).forEach(System.out::println);
            }
            case 2 -> {
                System.out.print("Введіть країну: ");
                filter.filterByCountry(list, sc.nextLine()).forEach(System.out::println);
            }
            case 3 -> {
                System.out.print("Максимальна ціна: ");
                double max = Double.parseDouble(sc.nextLine());
                filter.filterByMaxPrice(list, max).forEach(System.out::println);
            }
            default -> {}
        }

        return false;
    }
}
