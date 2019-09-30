/** CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

import java.awt.*;

public class Grid {
	
	private GridSquare[][] arr;
	private int w;
	private int h;
	
	public Grid(int w, int h) {
		arr = new GridSquare[15][15];
		this.w = w;
		this.h = h;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if ((i - j) % 2 == 0) {
					arr[i][j] = new GridSquare(Color.getHSBColor((float) 0.65, (float) 1, (float) 0.7));
				} else {
					arr[i][j] = new GridSquare(Color.getHSBColor((float) 0.65, (float) 1, (float) 0.5));
				}
			}
		}
		arr[7][12].setColor(Color.getHSBColor((float) 0,(float) 1,(float) .9));
		arr[7][12].setApple(true);
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				arr[i][j].draw(g, j * w / 15, i * h / 15, w / 15, h / 15);
			}
		}
	}
	
	/**
	 * getter for array
	 */
	
	public GridSquare[][] getArray() {
		return arr;
	}
	
}
