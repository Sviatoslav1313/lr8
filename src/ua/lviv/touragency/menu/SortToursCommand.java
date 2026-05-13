package ua.lviv.touragency.menu;

import ua.lviv.touragency.core.TourManager;
import ua.lviv.touragency.service.SortService;

import java.util.Scanner;

public class SortToursCommand implements Command {

    private final TourManager manager;
    private final SortService sort = new SortService();

    public SortToursCommand(TourManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "Сортувати тури";
    }

    @Override
    public boolean execute() {

        Scanner sc = new Scanner(System.in);
        System.out.println("1 — за ціною");
        System.out.println("2 — за тривалістю");
        System.out.print("Ваш вибір: ");

        int ch = Integer.parseInt(sc.nextLine());

        switch (ch) {
            case 1 -> sort.sortByPrice(manager.getAllTours()).forEach(System.out::println);
            case 2 -> sort.sortByDuration(manager.getAllTours()).forEach(System.out::println);
            default -> {}
        }

        return false;
    }
}
