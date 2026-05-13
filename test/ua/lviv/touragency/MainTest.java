package ua.lviv.touragency;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

// Тестує main(): перевіряє, що програма стартує і завершується по команді 0.
public class MainTest {

    @Test
    void testMainStartsAndExits() {
        System.setIn(new ByteArrayInputStream("0\n".getBytes()));
        Main.main(new String[0]);
    }
}
