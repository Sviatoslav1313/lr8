package ua.lviv.touragency.menu;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

// Тестує меню: обробку вводу, виконання команд та вихід із циклу.
public class ConsoleMenuTest {

    @Test
    void testMenuExecutesCommandAndExits() {
        String userInput = "1\n0\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Scanner scanner = new Scanner(System.in);
        ConsoleMenu menu = new ConsoleMenu(scanner);

        AtomicBoolean executed = new AtomicBoolean(false);

        menu.addCommand(1, new Command() {
            @Override
            public String getName() { return "Test"; }

            @Override
            public boolean execute() {
                executed.set(true);
                return false;
            }
        });

        menu.addCommand(0, new ExitCommand());

        menu.start();

        assertTrue(executed.get());
    }
}
