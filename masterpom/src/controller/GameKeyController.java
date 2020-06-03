package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import contract.AudioLoad;
import controller.BoulderAndDiamondController;
import controller.RockfordUpdateController;
import model.DisplayableElementModel;
import model.Level;


/**
 * GameKeyController
 *
 * Manages the key events controller.
 *@author Denis Destin
 * @since 2020-05-22
 */
public class GameKeyController implements KeyListener {
	private Level level;
	private RockfordUpdateController updatePosRockford;
    /**
     * Class constructor
     *
     * @param  level  Level model
     */
	public GameKeyController(Level level, AudioLoad audioLoad) {
		this.level = level;
		new BoulderAndDiamondController(level, audioLoad);
		this.updatePosRockford = new RockfordUpdateController(level);
	}

    /**
     * Handles the 'key pressed' event
     *
     * @param  e  Key event
     */
	public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            // Direction: UP
            case KeyEvent.VK_UP:
                DisplayableElementModel upElement = level.getGroundLevelModel()[level.getRockfordPositionX()][level.getRockfordPositionY() - 1];

                if (upElement.getPriority() < level.getRockford().getPriority()) {
                    this.updatePosRockford.moveRockford(level.getRockfordPositionX(), level.getRockfordPositionY() - 1);
                    this.level.getRockford().startRunningUp();
                }

                break;

            // Direction: DOWN
            case KeyEvent.VK_DOWN:
                DisplayableElementModel downElement = level.getGroundLevelModel()[level.getRockfordPositionX()][level.getRockfordPositionY() + 1];

                if (downElement.getPriority() < level.getRockford().getPriority()) {
                    this.updatePosRockford.moveRockford(level.getRockfordPositionX(), level.getRockfordPositionY() + 1);
                    this.level.getRockford().startRunningDown();
                }

                break;

            // Direction: LEFT
            case KeyEvent.VK_LEFT:
                DisplayableElementModel leftElement = level.getGroundLevelModel()[level.getRockfordPositionX() - 1][level.getRockfordPositionY()];

                if (leftElement.getPriority() < level.getRockford().getPriority()) {
                    this.updatePosRockford.moveRockford(level.getRockfordPositionX() - 1, level.getRockfordPositionY());
                    this.level.getRockford().startRunningLeft();
                }

                break;

            // Direction: RIGHT
            case KeyEvent.VK_RIGHT:
                DisplayableElementModel rightElement = level.getGroundLevelModel()[level.getRockfordPositionX() + 1][level.getRockfordPositionY()];

                if (rightElement.getPriority() < level.getRockford().getPriority()) {
                    this.updatePosRockford.moveRockford(level.getRockfordPositionX() + 1, level.getRockfordPositionY());
                    this.level.getRockford().startRunningRight();
                }

                break;
        }
	}

    /**
     * Handles the 'key released' event
     *
     * @param  e  Key event
     */
	@Override
	public void keyReleased(KeyEvent e) {
		this.level.getRockford().startStaying();
	}

    /**
     * Handles the 'key typed' event
     *
     * @param  e  Key event
     */
	@Override
	public void keyTyped(KeyEvent e) {
        // Do nothing.
	}
}
