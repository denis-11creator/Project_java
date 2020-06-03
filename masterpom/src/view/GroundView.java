package view;

import javax.swing.*;

import model.Level;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * FieldView
 *
 * FieldView, created by controller; we notice that we don't need to make
 * level observable; Because of the sprites we have to refresh the game
 * windows very often so don't need of observers/observable mechanism
 *
 * @author      Clarette ATAGANA
 * @since       25-05-2019
 *
 *        This view is basically drawing into the Frame the level.
 *
 */
public abstract class GroundView extends JPanel implements Observer {
	protected Level level;

	/**
	 * Class constructor
	 *
	 * @param  level  Level model
	 */
	public GroundView(Level level) {
		this.level = level;
		this.level.addObserver(this);
	}

	/**
	 * Draws the map
	 *
	 * @param  width   Map width
	 * @param  height  Map height
	 * @param  g       Map graphical object
	 */
	public void drawTerrain(int width, int height, Graphics g) {
		// Draw items
		if (this.level.getMode() == "game") {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					g.drawImage(this.level.getImage(x, y), (x * 16), (y * 16), this);
				}
			}

			if(!this.level.isGameRunning()) {
				if(!this.level.getRockford().getHasExplosed()) {
					this.displayWin();
				} else {
					this.displayLose();
				}
			}
		} else {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					g.drawImage(this.level.getImage(x, y), (x * 16), (y * 16), this);
				}
			}
			if (this.level.getShowCursor()) {
	            g.drawImage(
	                    this.level.getCursorImage(),
	                    ((this.level.getCursorXPosition() + 1) * 16),
	                    ((this.level.getCursorYPosition() + 1) * 16),
	                    this
	            );
			}
		}
	}

	/**
	 * Set the view to inform the user that he won
	 */
	private void displayWin() {
        new WinLoseView("win");
	}

	/**
	 * Set the view to inform the user that he is not good at this game
	 */
	private void displayLose() {
		new WinLoseView("lose");
	}

	/**
	 * Paints the map
	 *
	 * @param  g  Map graphical object
	 */
	public void paint(Graphics g) {
		this.drawTerrain(this.level.getSizeWidth(), this.level.getSizeHeight(), g);
	}

	/**
	 * Updates the view
	 *
	 * @param  obs  Observable item
	 * @param  obj  Object item
	 */
	@Override
	public void update(Observable obs, Object obj) {
		repaint();
	}
}