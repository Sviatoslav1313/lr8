package ua.lviv.touragency.menu;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

// Тестує команду Help: друк довідки і повернення false.
public class HelpCommandTest {

    @Test
    void testExecute() {
        HelpCommand cmd = new HelpCommand();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        boolean result = cmd.execute();

        System.setOut(System.out);

        assertFalse(result);
        assertTrue(out.toString().contains("Програма"));
    }
}
