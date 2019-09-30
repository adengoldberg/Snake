/** CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Snake {
	
	SnakeLink front;
	SnakeLink back;
	private Direction direction;
	private Grid grid;
	private boolean alive;
	private int trailX;
	private int trailY;
	private Set<Coordinate> occupied;
	private int score;
	
	public Snake(Grid g) {
		front = new SnakeLink(4, 7, null);;
		SnakeLink middle = new SnakeLink(3, 7, front);
		back = new SnakeLink(2, 7, middle);
		direction = Direction.RIGHT;
		grid = g;
		alive = true;
		trailX = 1;
		trailY = 7;
		occupied = new HashSet<Coordinate>();
		occupied.add(new Coordinate(2, 7));
		occupied.add(new Coordinate(3, 7));
		occupied.add(new Coordinate(4, 7));
		score = 0;
	}
	
	public void move() {
		SnakeLink curr = back;
		while (curr != null) {
			if (curr == back) {
				trailX = curr.getX();
				trailY = curr.getY();
				curr.setX(curr.getNext().getX());
				curr.setY(curr.getNext().getY());
			} else if (curr != front) {
				curr.setX(curr.getNext().getX());
				curr.setY(curr.getNext().getY());
			} else {
				if (direction == Direction.LEFT) {
					curr.setX(curr.getX() - 1);
				}
				if (direction == Direction.RIGHT) {
					curr.setX(curr.getX() + 1);
				}
				if (direction == Direction.UP) {
					curr.setY(curr.getY() - 1);
				}
				if (direction == Direction.DOWN) {
					curr.setY(curr.getY() + 1);
				}
				if (curr.getX() < 0 || curr.getX() > 14 || 
						curr.getY() < 0 || curr.getY() > 14 || 
						occupied.contains(new Coordinate(curr.getX(), curr.getY()))) {
					alive = false;	
				} else if (grid.getArray()[curr.getY()][curr.getX()].getApple()) {
					
					SnakeLink n = new SnakeLink(trailX, trailY, back);
					back = n;
					grid.getArray()[curr.getY()]
							[curr.getX()].setColor(Color.getHSBColor((float) .3,(float) 1,(float) .5)); //green
					occupied.add(new Coordinate(curr.getX(), curr.getY()));
					grid.getArray()[curr.getY()]
							[curr.getX()].setApple(false);
					Coordinate a = new Coordinate((int) (15 * Math.random()), 
							(int) (15 * Math.random()));
					while (occupied.contains(a)) {
						a.setX((int) (15 * Math.random()));
						a.setY((int) (15 * Math.random()));
					}
					grid.getArray()[a.getY()][a.getX()].setColor(Color.getHSBColor((float) 0,(float) 1,(float) .9)); //red
					grid.getArray()[a.getY()][a.getX()].setApple(true);
					score = score + 1;
				} else {
					grid.getArray()[curr.getY()]
							[curr.getX()].setColor(Color.getHSBColor((float) .3,(float) 1,(float) .5)); //green
					occupied.add(new Coordinate(curr.getX(), curr.getY()));
					grid.getArray()[trailY]
							[trailX].setColor(); //default
					occupied.remove(new Coordinate(trailX, trailY));
				}
			}
			curr = curr.getNext();
		}
	}
	
	/**
	 * direction getter
	 */
	public Direction getDirection() {
		return direction;
	}
	
	/**
	 * direction setter
	 */
	public void setDirection(Direction d) {
		direction = d;
	}
	
	/**
	 * alive getter
	 */
	public boolean isAlive() {
		return alive;
	}
	
	/**
	 * score getter
	 */
	public int getScore() {
		return score;
	}

}
