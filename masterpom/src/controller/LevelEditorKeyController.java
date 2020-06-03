package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Level;
import view.LevelEditor;


/**
 * LevelEditorKeyController
 *
 * Manages the key events controller.
 *@author Denis Destin
 * @since 2020-05-22
 */
public class LevelEditorKeyController implements KeyListener {
    private Level level;
    private LevelEditor levelEditor;
	private boolean capLocks;

    /**
     * Class constructor
     *
     * @param  level       Level model
     * @param  levelEditor  Level editor view
     */
    public LevelEditorKeyController(Level level, LevelEditor levelEditor) {
        this.level = level;
        this.capLocks = false;
        this.levelEditor = levelEditor;
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
                this.level.decrementCursorYPosition();
                break;

            // Direction: DOWN
            case KeyEvent.VK_DOWN:
                this.level.incrementCursorYPosition();
                break;

            // Direction: LEFT
            case KeyEvent.VK_LEFT:
                this.level.decrementCursorXPosition();
                break;

            // Direction: RIGHT
            case KeyEvent.VK_RIGHT:
                this.level.incrementCursorXPosition();
                break;

            // Key: SPACE
            case KeyEvent.VK_SPACE:
                this.level.triggerBlockChange(this.levelEditor.getPickedBlockValue());
                break;
            
            case 16:
                this.capLocks = !capLocks;
                break;
        }

        // Hold block change (quick edit)
        if(capLocks) {
        	this.level.triggerBlockChange(this.levelEditor.getPickedBlockValue());
        }
    }

    /**
     * Handles the 'key released' event
     *
     * @param  e  Key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        // Do nothing.
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
