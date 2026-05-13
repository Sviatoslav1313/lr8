package ua.lviv.touragency.menu;

import ua.lviv.touragency.core.TourManager;

import java.util.Scanner;

public class LoadToursCommand implements Command {

    private final TourManager manager;

    public LoadToursCommand(TourManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "Завантажити тури з файлу";
    }

    @Override
    public boolean execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть ім'я файлу (наприклад tours.txt): ");
        String filename = sc.nextLine();

        try {
            int n = manager.loadFromFile(filename);
            System.out.println("Завантажено турів: " + n);
        } catch (Exception e) {
            System.out.println("Помилка читання файлу!");
        }

        return false;
    }
}
