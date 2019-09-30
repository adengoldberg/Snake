/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

// imports necessary libraries for Java swing

import java.awt.*;
import javax.swing.*;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
    public void run() {
        // NOTE : recall that the 'final' keyword notes immutability even for local variables.

        // Top-level frame in which game components live
        // Be sure to change "TOP LEVEL FRAME" to the name of your game
        final JFrame frame = new JFrame("SNAKE");
        frame.setLocation(300, 100);

        // Status panel
        final JPanel status_panel = new JPanel();
        frame.add(status_panel, BorderLayout.SOUTH);
        final JLabel status = new JLabel("press an arrow to start");
        status_panel.add(status);
        
        // Scoreboard
        final JPanel scoreboard = new JPanel();
        frame.add(scoreboard, BorderLayout.NORTH);
        final JLabel score = new JLabel("SCORE: 0");
        scoreboard.add(score);
        final JLabel highScore = new JLabel("HIGH SCORE: 0");
        scoreboard.add(highScore);
        
        JOptionPane.showMessageDialog(frame, "Use the arrow keys to "
        		+ "conrol the snake." + '\n' 
        		+ "The goal of the game is to eat as "
        		+ "many apples (red boxes) as you can before hitting a "
        		+ "wall or running into yourself!");

        // Main playing area
        final GameCourt court = new GameCourt(status, score, highScore);
        frame.add(court, BorderLayout.CENTER);


        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start game
        court.reset();
    }

    /**
     * Main method run to start and run the game. Initializes the GUI elements specified in Game and
     * runs it. IMPORTANT: Do NOT delete! You MUST include this in your final submission.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}