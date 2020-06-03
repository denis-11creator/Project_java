package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import contract.LevelRemove;
import contract.LevelSave;
import controller.NavigationBetweenViewController;
import entity.LevelConstraintNotRespectedException;
import model.Level;
import view.LevelEditor;

/**
 * LevelEditorController
 *
 * Manages the level editor controller.
 *
 * @author Denis Destin
 * @since 2020-05-22
 */
public class LevelEditorController implements ActionListener {
    private Level level;
	private LevelEditor levelEditor;
	private NavigationBetweenViewController nav;

    /**
     * Class constructor'
     *
     * @param  level  Level model
     */
    public LevelEditorController(Level level, NavigationBetweenViewController nav) {
        this.level = level;
        this.level.setShowCursor(true);

        this.nav = nav;
        this.nav.getAudioLoadHelper().stopMusic();
        
        this.levelEditor = new LevelEditor(this, level, nav);

        // Pre-bind event watcher (hack to fix a Java issue)
        this.level.decrementCursorXPosition();
    }

    /**
     * Handles the 'action performed' event
     *
     * @param  event  Action event
     */
    public void actionPerformed(ActionEvent event) {
        switch(event.getActionCommand()) {
            case "menu":
            	this.levelEditor.setVisible(false);
            	this.nav.setMenuView();           	
                this.nav.getAudioLoadHelper().startMusic("game");

                break;

            case "save":
                // Check constraints
                try {
                    this.level.checkConstraints();

                    // Save action (direct save)
                    String levelId = this.levelEditor.getSelectedLevel();
                    LevelSave levelSave;

                    if(levelId == null || levelId.isEmpty()) {
                        // Create a new level
                        levelSave = new LevelSave(level.getGroundLevelModel());
                    } else {
                        // Overwrite existing level
                        levelSave = new LevelSave(levelId, level.getGroundLevelModel());
                    }

                    JFrame frameDialog = new JFrame("Info");
                    JOptionPane.showMessageDialog(frameDialog, "Level saved");

                    this.levelEditor.openedLevelChange(levelSave.getLevelId());
                } catch(LevelConstraintNotRespectedException e) {
                    JFrame frameDialog = new JFrame("Error");
                    JOptionPane.showMessageDialog(frameDialog, e.getMessage());
                }

                break;

            case "delete":
                String levelId = this.levelEditor.getSelectedLevel();
                JFrame frameDialog = new JFrame("Info");

                if(levelId == null || levelId.isEmpty()) {
                    JOptionPane.showMessageDialog(frameDialog, "Level not yet saved, no need to delete it!");
                } else {
                    new LevelRemove(levelId);
                    JOptionPane.showMessageDialog(frameDialog, "Level deleted!");

                    this.levelEditor.openedLevelChange(null);
                }
                break;
                

            case "new":
                this.levelEditor.openedLevelChange(null);
                break;
        }

        this.getLevelEditorView().getLevelEditorGroundView().grabFocus();
    }

    /**
     * Gets the level editor view
     *
     * @return  Level editor view
     */
	public LevelEditor getLevelEditorView() {
		return levelEditor;
	}

    /**
     * Gets level model
     *
     * @return  Level model
     */
    public Level getLevelModel() {
        return this.level;
    }

    /**
     * Sets the level editor view
     *
     * @param  levelEditor  Level editor view
     */
	public void setLevelEditorView(LevelEditor levelEditor) {
		this.levelEditor = levelEditor;
	}
    
    
}