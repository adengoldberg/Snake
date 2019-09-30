/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

/**
 * This file holds an enumeration called Direction, which is used in GameObj.java to indicate the
 * direction an object should move after it collides with another object.
 * 
 * One can make a method take in or return a Direction (thus limiting the possible cases of the
 * input to the enum cases)
 */
public enum Direction {
    UP, DOWN, LEFT, RIGHT;
	
	public boolean opposite(Direction o) {
		if (this.equals(Direction.DOWN)) {
			return o.equals(Direction.UP);
 		} else if (this.equals(Direction.UP)) {
			return o.equals(Direction.DOWN);
 		} else if (this.equals(Direction.LEFT)) {
			return o.equals(Direction.RIGHT);
 		} else {
			return o.equals(Direction.LEFT);
 		}
	}
}
