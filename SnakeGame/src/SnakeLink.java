/** CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

public class SnakeLink {
	
	private int x;
	private int y;
	private SnakeLink next;
	
	public SnakeLink(int x, int y, SnakeLink next) {
		this.x = x;
		this.y = y;
		this.next = next;
	}
	
	/**
	 * setter for x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * setter for y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * getter for x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * getter for y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * getter for next
	 */
	public SnakeLink getNext() {
		return next;
	}
}