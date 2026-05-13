package ua.lviv.touragency.menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Тестує команду виходу.
public class ExitCommandTest {

    @Test
    void testExecuteReturnsTrue() {
        assertTrue(new ExitCommand().execute());
    }
}
