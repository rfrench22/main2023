package team100.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EdgeCounterTest {
    @Test
    public void testToy() {
        assertEquals(1, 1);
    }

    @Test
    public void testCounter() {
        EdgeCounter c = new EdgeCounter(0.25, 0.75);
        assertEquals(0, c.update(0));
        assertEquals(0, c.update(0.1));
        assertEquals(0, c.update(0.5));
        assertEquals(0, c.update(0.9));
        assertEquals(1, c.update(0.1));
        assertEquals(1, c.update(0.5));
        assertEquals(1, c.update(0.1));
        assertEquals(0, c.update(0.9));
    }
}
