import org.junit.Test;

/** 
 *  You can use this file (and others) to test your
 *  implementation.
 */

public class GameTest {

    @Test
    public void testSnakeHitWall() {
        Grid g = new Grid(300, 300);
        Snake s = new Snake(g);
        s.move();
        s.move();
        s.move();
        s.move();
        s.move();
        s.move();
        s.move();
        s.move();
        s.move();
        s.move();
        assertTrue(s.isAlive());
        s.move();
        assertFalse(s.isAlive());
    }

}
