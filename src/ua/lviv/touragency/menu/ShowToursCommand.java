package ua.lviv.touragency.menu;

import ua.lviv.touragency.core.TourManager;

public class ShowToursCommand implements Command {

    private final TourManager manager;

    public ShowToursCommand(TourManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "Показати всі тури";
    }

    @Override
    public boolean execute() {
        manager.getAllTours().forEach(System.out::println);
        return false;
    }
}
