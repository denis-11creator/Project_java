package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import contract.AudioLoad;
import controller.NavigationBetweenViewController;
import model.Level;
import view.Game;
import view.MenuView;


/**
 * GameController
 *
 * This system creates the view.
 * The game loop is also handled there.
 *
 *@author Denis Destin
 * @since 2020-05-22
 */
public class GameController implements ActionListener {
	private Level level;
    private AudioLoad audioLoad;
    private boolean firstClickOnPause;
	private MenuView menuView;
	private Game game;
	private NavigationBetweenViewController navigationBetweenViewController;
	
    /**
     * Class constructor
     *
     * @param  level  Level model
     * @param navigationBetweenViewController 
     */
	public GameController(Level level, AudioLoad audioLoad, NavigationBetweenViewController navigationBetweenViewController) {
        this.firstClickOnPause = true;
        
        this.navigationBetweenViewController = navigationBetweenViewController;
        
		this.level = level;
        this.audioLoad = audioLoad;
        this.game = new Game(this, level); 
        this.menuView = navigationBetweenViewController.getMenuView();

        this.getAudioLoadHelper().stopMusic();
        this.getAudioLoadHelper().playSound("new");
	}

	/**
	 * Handles the 'action performed' event
     *
	 * @param  event  Action event
	 */
	public void actionPerformed(ActionEvent event) {
        switch(event.getActionCommand()) {
            case "pause":
            	if(this.firstClickOnPause) {
            		this.level.setGamePaused(true);
            	} else if(!this.firstClickOnPause) {
            		this.level.setGamePaused(false);
            	}

            	this.firstClickOnPause = !this.firstClickOnPause;
            	this.game.getGameFieldView().grabFocus();
                break;

            case "restart":
                this.resetGame("restart");
                this.getAudioLoadHelper().playSound("new");
                this.game.getGameFieldView().grabFocus();
                break;
            
            case "menu":
            	this.menuView.setVisible(true);
                this.getAudioLoadHelper().startMusic("game");
            	this.resetGame("menu");
                break;
        }
	}

	/**
	 * Function to reset the game
	 */
    private void resetGame(String source) {
		this.game.dispose();
		
		if(source.equals("restart")){
	    	this.level = new Level(this.navigationBetweenViewController.getPickedLevelIdentifier(), audioLoad);
			this.game = new Game(this, level);
			this.game.setVisible(true);
		}
	}

	/**
     * Gets the audio load helper instance
     *
     * @return  Audio load helper instance
     */
    public AudioLoad getAudioLoadHelper() {
        return this.audioLoad;
    }

    /**
     * Return the game view
     * @return game
     */
	public Game getGameView() {
		return game;
	}

	/**
	 * Set the game
	 * @param game
	 */
	public void setGameView(Game game) {
		this.game = game;
	}
}