package ua.lviv.touragency;

import ua.lviv.touragency.core.TourManager;
import ua.lviv.touragency.menu.*;
import ua.lviv.touragency.util.AppLogger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Ініціалізація логування
        AppLogger.setup();
        AppLogger.get().info("Application started.");

        Scanner scanner = new Scanner(System.in);
        TourManager manager = new TourManager();

        ConsoleMenu menu = new ConsoleMenu(scanner);

        menu.addCommand(1, new LoadToursCommand(manager));
        menu.addCommand(2, new ShowToursCommand(manager));
        menu.addCommand(3, new FilterToursCommand(manager));
        menu.addCommand(4, new SortToursCommand(manager));
        menu.addCommand(5, new HelpCommand());
        menu.addCommand(0, new ExitCommand());

        menu.start();

        AppLogger.get().info("Application stopped.");
    }
}