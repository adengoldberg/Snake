/** CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

public class Coordinate {
	
	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
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
	
	@Override
	public boolean equals(Object o) {
		boolean result = false;
		if (o instanceof Coordinate) {
			Coordinate that = (Coordinate) o;
			result = (x == that.getX()) && (y == that.getY());
		}
		return result;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
}
