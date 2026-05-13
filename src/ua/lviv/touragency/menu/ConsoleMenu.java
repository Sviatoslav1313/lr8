package ua.lviv.touragency.menu;

import java.util.*;

public class ConsoleMenu {

    private final Map<Integer, Command> commands = new LinkedHashMap<>();
    private final Scanner scanner;

    public ConsoleMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addCommand(int number, Command command) {
        commands.put(number, command);
    }

    public void start() {
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = readChoice();

            Command cmd = commands.get(choice);
            if (cmd != null) {
                exit = cmd.execute();
            }
        }
    }

    private void printMenu() {
        System.out.println("\n===== МЕНЮ ТУРИСТИЧНОЇ АГЕНЦІЇ =====");
        commands.forEach((k, v) -> System.out.println(k + " - " + v.getName()));
        System.out.print("Ваш вибір: ");
    }

    private int readChoice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) { }
        }
    }
}
