import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SnakeTest {
	
	@Test
    public void hitWallTest() {
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
	
	@Test
    public void changeDirectionTest() {
        Grid g = new Grid(300, 300);
        Snake s = new Snake(g);
        s.move();
        assertEquals(Direction.RIGHT, s.getDirection());
        s.setDirection(Direction.UP);
        s.move();
        assertEquals(Direction.UP, s.getDirection());
        assertEquals(5, s.front.getX());
        assertEquals(6, s.front.getY());
        assertEquals(4, s.back.getX());
        assertEquals(7, s.back.getY());
    }
	
	@Test
    public void eatAppleTest() {
        Grid g = new Grid(300, 300);
        Snake s = new Snake(g);
        s.move();
        s.move();
        s.move();
        s.move();
        s.move();
        s.move();
        s.move();
        assertEquals(0, s.getScore());
        assertEquals(9, s.back.getX());
        s.move();
        assertEquals(1, s.getScore());
        assertEquals(9, s.back.getX());
    }
	
	@Test
    public void hitSelfTest() {
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
        s.setDirection(Direction.UP);
        s.move();
        s.setDirection(Direction.LEFT);
        s.move();
        s.setDirection(Direction.DOWN);
        assertTrue(s.isAlive());
        s.move();
        assertFalse(s.isAlive());
    }

}
