/** CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

import java.awt.*;

public class GridSquare {
	
	private Color defaultColor;
	private Color color;
	private boolean apple;
	
	public GridSquare(Color color) {
		this.color = color;
		defaultColor = color;
		apple = false;
	}
	
	public void draw(Graphics g, int x, int y, int w, int h) {
		g.setColor(color);
		g.fillRect(x, y, w, h);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, w, h);
	}
	
	/**
	 * setter for color
	 */
	public void setColor(Color c) {
		color = c;
	}
	
	/**
	 * overloaded setter for color
	 */
	public void setColor() {
		color = defaultColor;
	}
	
	/**
	 * setter for apple
	 */
	public void setApple(boolean b) {
		apple = b;
	}
	
	/**
	 * getter for apple
	 */
	public boolean getApple() {
		return apple;
	}
	
}
