// Uncomment this file when you start Path

import org.junit.Test;
import static org.junit.Assert.*;

public class PathTest {

    @Test
    public void testIterate() {
        System.out.println("Create a new Path(0, 0).");
        Path path = new Path(0, 0);
        System.out.println("Iterate the path with dx = 1, dy = 1");
        path.iterate(1, 1);
        assertEquals(0, path.getCurrX(), 0.001);
        assertEquals(0, path.getCurrY(), 0.001);
        assertEquals(1, path.getNextX(), 0.001);
        assertEquals(1, path.getNextY(), 0.001);

        System.out.println("Iterate the path with dx = 1, dy = 1");
        path.iterate(1, 1);
        assertEquals(1, path.getCurrX(), 0.001);
        assertEquals(1, path.getCurrY(), 0.001);
        assertEquals(2, path.getNextX(), 0.001);
        assertEquals(2, path.getNextY(), 0.001);

        System.out.println("Iterate the path with dx = 0.5, dy = 1");
        path.iterate(0.5, 1);
        assertEquals(2, path.getCurrX(), 0.001);
        assertEquals(2, path.getCurrY(), 0.001);
        assertEquals(2.5, path.getNextX(), 0.001);
        assertEquals(3, path.getNextY(), 0.001);
    }
}