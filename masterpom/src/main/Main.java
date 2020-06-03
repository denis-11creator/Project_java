package main;

import javax.swing.*;

import controller.NavigationBetweenViewController;


/**
 * Game
 *
 * Spawns the game.
 *
 * @author      Annan Gassu
 * @since       2020-05-30
 */
public class Main {
    /**
     * Class constructor
     *
     * @param  args  Command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NavigationBetweenViewController();
            }
        });
    }
}
