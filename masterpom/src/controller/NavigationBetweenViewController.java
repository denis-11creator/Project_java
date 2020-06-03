package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import contract.AudioLoad;
import controller.GameController;
import controller.LevelEditorController;
import model.Level;
import view.MenuView;

/**
 * Controller to navigate between the different views
 * 

 * @author Denis Destin
 * @since 2020-05-22
 */
public class NavigationBetweenViewController implements ActionListener {
	private LevelEditorController levelEditorController;
	private MenuView menuView;
	private AudioLoad audioLoad;
	private Level levelModelForGame, levelModelForEditor;
	private GameController gameController;
	private String pickedLevelIdentifier;

    /**
     * Class constructor
     */
	public NavigationBetweenViewController() {
		this.audioLoad = new AudioLoad();

        // Play game music
        this.getAudioLoadHelper().startMusic("Boulder Dash 1984 Intro music eargasm");

		// Creation of the first view
		this.menuView = new MenuView(this);
	}

    /**
     * Action performed event handler
     *
     * @param  event  Action event
     */
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
            case "quit":
                System.exit(0);
                break;

            case "editor":
                // New blank model for editor
                this.levelModelForEditor = new Level(audioLoad);
                this.levelEditorController = new LevelEditorController(this.levelModelForEditor, this);

                this.levelEditorController.getLevelEditorView().setVisible(true);
                this.levelEditorController.getLevelEditorView().getLevelEditorGroundView().grabFocus();

                if (gameController != null) {
                    this.gameController.getGameView().setVisible(false);
                }

                break;

            case "game":
                // Reinit the levelModelForGame...
                pickedLevelIdentifier = this.menuView.getLevelIdentifier();

                this.levelModelForGame = new Level(pickedLevelIdentifier, audioLoad);
                this.gameController = new GameController(levelModelForGame, audioLoad, this);

                if (levelEditorController != null) {
                    this.levelEditorController.getLevelEditorView().setVisible(false);
                }

                this.gameController.getGameView().setVisible(true);
                this.gameController.getGameView().getGameFieldView().grabFocus();

			    break;
		}

		this.menuView.setVisible(false);
	}

    /**
     * Get the audio load helper
     *
     * @return  Audio load helper
     */
    public AudioLoad getAudioLoadHelper() {
        return this.audioLoad;
    }

    /**
     * Get the first view
     *
     * @return  First view
     */
    public MenuView getMenuView() {
        return this.menuView;
    }

	/**
	 * Set the first view
	 * 
	 * @param  menuView
	 */
	public MenuView setMenuView() {
		this.menuView = new MenuView(this);
		return menuView;
	}

	/**
	 * Get the pickedLevel
     *
	 * @return  pickedLevelIdentifier  Picked level identifier
	 */
	public String getPickedLevelIdentifier() {
		return pickedLevelIdentifier;
	}

	/**
	 * Set the pickedLevelIdentifier
     *
	 * @param  pickedLevelIdentifier  Picked level identifier
	 */
	public void setPickedLevelIdentifier(String pickedLevelIdentifier) {
		this.pickedLevelIdentifier = pickedLevelIdentifier;
	}
	
	
}
