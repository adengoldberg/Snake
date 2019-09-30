/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * GameCourt
 * 
 * This class holds the primary game logic for how different objects interact with one another. Take
 * time to understand how the timer interacts with the different methods and how it repaints the GUI
 * on every tick().
 */
@SuppressWarnings("serial")
public class GameCourt extends JPanel {

    // the state of the game logic
    private Snake snake; // the snake
    private Grid grid; // the grid

    public boolean playing = false; // whether the game is running 
    public boolean ready = true; // if the game is ready to start
    private JLabel status; // Current status text, i.e. "playing..."
    private JLabel score; // Current score label
    private int highScore; // Current high score
    private JLabel highScoreLabel; // Current high score label
    private Direction last;

    // Game constants
    public static final int COURT_WIDTH = 600; // must be divisible by 15
    public static final int COURT_HEIGHT = 600; // must be divisible by 15

    // Update interval for timer, in milliseconds
    public static final int INTERVAL = 132;

    public GameCourt(JLabel status, JLabel scoreLabel, JLabel highScoreLabel) {
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // The timer is an object which triggers an action periodically with the given INTERVAL. We
        // register an ActionListener with this timer, whose actionPerformed() method is called each
        // time the timer triggers. We define a helper method called tick() that actually does
        // everything that should be done in a single timestep.
        Timer timer = new Timer(INTERVAL, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start(); // MAKE SURE TO START THE TIMER!

        // Enable keyboard focus on the court area.
        // When this component has the keyboard focus, key events are handled by its key listener.
        setFocusable(true);

        // This key listener changes the direction of the snake
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
            	Direction curr = snake.getDirection();
            	if (e.getKeyCode() == KeyEvent.VK_SPACE && !playing) {
            		ready = true;
            		reset();
            	} else if (e.getKeyCode() == KeyEvent.VK_LEFT && ready) {
                    if (curr != Direction.RIGHT) {
                    	snake.setDirection(Direction.LEFT);
                    	playing = true;
                    	status.setText("playing...");
                    } else if (!playing) {
                    	playing = true;
                    	status.setText("playing...");
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && ready) {
                	if (curr != Direction.LEFT) {
                    	snake.setDirection(Direction.RIGHT);
                    	playing = true;
                    	status.setText("playing...");
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN && ready) {
                	if (curr != Direction.UP) {
                    	snake.setDirection(Direction.DOWN);
                    	playing = true;
                    	status.setText("playing...");
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_UP && ready) {
                	if (curr != Direction.DOWN) {
                    	snake.setDirection(Direction.UP);
                    	playing = true;
                    	status.setText("playing...");
                    }
                }
            }
        });
        
        this.status = status;
        this.score = scoreLabel;
        this.highScoreLabel = highScoreLabel;
    }

    /**
     * (Re-)set the game to its initial state.
     */
    public void reset() {
    	
    	grid = new Grid(COURT_WIDTH, COURT_HEIGHT);
        snake = new Snake(grid);
        last = Direction.RIGHT;
        score.setText("SCORE: 0");
        
        status.setText("press an arrow to start");
        
        // update the display
        grid.getArray()[7][4].setColor(Color.getHSBColor((float) .3,(float) 1,(float) .5));
        grid.getArray()[7][3].setColor(Color.getHSBColor((float) .3,(float) 1,(float) .5));
        grid.getArray()[7][2].setColor(Color.getHSBColor((float) .3,(float) 1,(float) .5));
        
        repaint();
        
        // Make sure that this component has the keyboard focus
        requestFocusInWindow();
    }

    /**
     * This method is called every time the timer defined in the constructor triggers.
     */
    void tick() {
        if (playing) {
            // advance the snake
        	if (snake.getDirection().opposite(last)) {
        		snake.setDirection(last);
        	}
        	last = snake.getDirection();
            snake.move();
            
            // update score
            score.setText("SCORE: " + snake.getScore());

            // check for the game end conditions
            if (!(snake.isAlive())) {
            	playing = false;
            	ready = false;
            	status.setText("YOU LOSE! Press SPACE to play again!");
            	if (snake.getScore() > highScore) {
            		highScore = snake.getScore();
            		highScoreLabel.setText("HIGH SCORE: " + highScore);
            	}
            }

            // update the display
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        grid.draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}