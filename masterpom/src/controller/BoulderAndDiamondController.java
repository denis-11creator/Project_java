package controller;

import contract.AudioLoad;
import model.Ground;
import model.DisplayableElementModel;
import model.Level;

/**
 * ElementPositionUpdateHelper
 *
 * Updates position of all elements displayed on the map, according to their
 * next potential position. Each object has a weight, which is used to compare
 * their power to destroy in the food chain. Sorry for that Darwinism.
 *
 * @author Denis Destin
 * @since 2020-05-22
 */
public class BoulderAndDiamondController implements Runnable {
	private Level level;
    private AudioLoad audioLoad;
	private Thread elementMovingThread;

	/**
	 * Class constructor
	 *
	 * @param level  Level model
	 */
	public BoulderAndDiamondController(Level level, AudioLoad audioLoad) {
		this.level = level;
        this.audioLoad = audioLoad;

        // Start thread
		this.elementMovingThread = new Thread(this);
		this.elementMovingThread.start();
	}

	/**
	 * Watches for elements to be moved
	 */
	public void run() {
		while (this.level.isGameRunning()) {
			if(!this.level.getGamePaused()){
				this.manageFallingObject();
			}
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Scan the ground to detect the boulders & the diamonds, then make them
	 * fall if necessary
     * Note: scan of the ground upside down: we want things to fall slowly !
	 */
	private void manageFallingObject() {
		for (int x = this.level.getSizeWidth() - 1; x >= 0; x--) {
			for (int y = this.level.getSizeHeight() - 1; y >= 0; y--) {
				// Gets the spriteName of actual DisplayableElementModel object scanned
				DisplayableElementModel elementModel = this.level.getGroundLevelModel()[x][y];

				if(elementModel == null) {
					elementModel = new Ground();
				}

				String spriteName = elementModel.getSpriteName();
				
				// If it is a boulder or a diamond...
				if (spriteName == "boulder" || spriteName == "diamond") {
					this.manageFall(x, y);
				} else if(spriteName == "expandingwall"){
					if(this.expandWall(x,y).equals("left")){
						x -= 1;
					}
				}
			}
		}
	}

	/**
	 * Expand the wall at left & right
     *
	 * @param  x  Horizontal position
	 * @param  y  Vertical position
	 */
	private String expandWall(int x, int y) {
		DisplayableElementModel elementLeft  = this.level.getGroundLevelModel()[x - 1][y];
        DisplayableElementModel elementRight = this.level.getGroundLevelModel()[x + 1][y];
        String spriteNameLeft  = elementLeft.getSpriteName();
		String spriteNameRight = elementRight.getSpriteName();
		
		String way = "";
		if(spriteNameLeft == "black"){
			this.level.expandThisWallToLeft(x,y);
			way = "left";
		}
		if(spriteNameRight == "black"){
			this.level.expandThisWallToRight(x,y);
			way = "right";
		}
		return way;
	}

	/**
	 * Manages the fall of elements
	 *
	 * @param  x  Horizontal position
	 * @param  y  Vertical position
	 */
	private void manageFall(int x, int y) {
		// Get informed about Rockford surroundings
        DisplayableElementModel elementBelow = this.level.getGroundLevelModel()[x][y + 1];
        DisplayableElementModel elementLeft  = this.level.getGroundLevelModel()[x - 1][y];
        DisplayableElementModel elementRight = this.level.getGroundLevelModel()[x + 1][y];

        String spriteNameBelow = elementBelow.getSpriteName();
		String spriteNameLeft  = elementLeft.getSpriteName();
		String spriteNameRight = elementRight.getSpriteName();

		// Then, process in case of the surrounding
		if (spriteNameBelow == "black") {
			this.level.makeThisDisplayableElementFall(x, y);
		} else if (spriteNameBelow == "boulder") {
			// Boulders have to roll if they hit another boulder
			if (this.level.getGroundLevelModel()[x - 1][y + 1].getSpriteName() == "black") {
				this.level.makeThisBoulderSlideLeft(x, y);
			} else if (this.level.getGroundLevelModel()[x + 1][y + 1].getSpriteName() == "black") {
				this.level.makeThisBoulderSlideRight(x, y);
			}
		} else if (spriteNameBelow == "rockford" && this.level.getGroundLevelModel()[x][y].isFalling()) {
			this.level.exploseGround(x, y + 1);

            this.audioLoad.playSound("die");

			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.level.setGameRunning(false);
		} else if (spriteNameBelow == "magicwall") {
			if (this.level.getGroundLevelModel()[x][y].getSpriteName() == "boulder" 
					&& (this.level.getGroundLevelModel()[x][y+2].getSpriteName() == "dirt" ||
							this.level.getGroundLevelModel()[x][y+2].getSpriteName() == "black")) {
				if(this.level.getGroundLevelModel()[x][y].isConvertible()) {
					this.level.transformThisBoulderIntoADiamond(x, y);
				} else {
					this.level.deleteThisBoulder(x, y);
				}
			}
		} else if (elementBelow.isDestructible() && spriteNameBelow != "dirt" && this.level.getGroundLevelModel()[x][y].isFalling()) {
				this.level.exploseThisBrickWall(x, y);
		} else if (spriteNameLeft == "rockford" && this.level.getRockford().isRunningRight() && this.level.getGroundLevelModel()[x + 1][y].getSpriteName() == "black") {
			this.level.moveThisBoulderToRight(x, y);
		} else if (spriteNameRight == "rockford" && this.level.getRockford().isRunningLeft() && this.level.getGroundLevelModel()[x - 1][y].getSpriteName() == "black") {
			this.level.moveThisBoulderToLeft(x, y);
		} else {
			this.level.getGroundLevelModel()[x][y].setFalling(false);
		}
	}
}
