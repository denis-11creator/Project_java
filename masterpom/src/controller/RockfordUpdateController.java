package controller;

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
public class RockfordUpdateController implements Runnable {
	private Level level;
	private Thread elementMovingThread;
	private int rockfordPositionX;
	private int rockfordPositionY;
	private boolean rockfordHasMoved;

	/**
	 * Class constructor
	 *
	 * @param level  Level model
	 */
	public RockfordUpdateController(Level level) {
		this.level = level;
		this.elementMovingThread = new Thread(this);
		this.elementMovingThread.start();
		this.rockfordHasMoved = false;
	}

	/**
	 * Watches for elements to be moved
	 */
	public void run() {
		while (this.level.isGameRunning()) {
			if(!this.level.getGamePaused()){
				if (this.rockfordHasMoved) {
					this.level.setPositionOfRockford(rockfordPositionX, rockfordPositionY);
					this.rockfordHasMoved = false;
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Moves Rockford
	 *
	 * @param  rockfordPositionX  Next horizontal position on the grid
	 * @param  rockfordPositionY  Next vertical position on the grid
	 */
	public void moveRockford(int rockfordPositionX, int rockfordPositionY) {
		this.rockfordPositionX = rockfordPositionX;
		this.rockfordPositionY = rockfordPositionY;
		this.rockfordHasMoved = true;
	}
}
