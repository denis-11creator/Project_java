package contract;

import controller.Controller;
import controller.Event;
import model.*;
import view.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author      Zangue Olivarex
 * @since       2020-05-28
 * Main loop of the game
 * 
 */

public class GameLoop {
	
	private char[][] c_map; //complete map
	private char[][] v_map; //map seen by the player
	Window Win = new Window();
	private Event ev = new Event();
	int l;
	private static int DC = 0;
	
	public GameLoop(){
	}
	
	static AddEntity AE = new AddEntity();
	/**
	 *
	 * creation and execution of the game
	 *  Chose the level to be played 
	 */
	public void createGame(){ 
		this.initializeMap(3);
		
		
		

		
		
		Win.Window(AE.getEntity());
		
		while (true){ //the loop
			if(ev.getGameLost()){//if the game is lost, the GO screen appears!
				System.out.println("GAME OVER");
				AE.addEntity(new LostScreen(0,0));
				Win.getWe().repaint();
				break;
			}
			if(DC>=5 && ev.getDoorReach()){//if the game is won, the GG screen appears!
				System.out.println("WIN");
				AE.addEntity(new WinScreen(0,0));
				Win.getWe().repaint();
				break;
			}
			this.update();
			
			try {
				TimeUnit.MILLISECONDS.sleep(10);//a timer to slow down the loop
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	
	}
	
	public void endGame(){}
	
	public void display(){}
	
	public void initializeMap(int level){
		Mapping map = new Mapping();
		c_map=map.loadMap(level); // loading a new map
		
	}
	public void testMap(){ // for all character in the map, we assign an entity
		AE.clear();
		
		for(int i=0; i<15; i++){
			for(int j=0; j<15; j++){
				if(v_map[i][j]=='x'){
					AE.addEntity(new HardWall(i*16, j*16));
				}
				if(v_map[i][j]=='m'){
					AE.addEntity(new UnbreakableWall(i*16, j*16));
				}
				if(v_map[i][j]=='y' || v_map[i][j]=='z'){
					AE.addEntity(new EmptyWall(i*16, j*16));
				}
				if(v_map[i][j]=='f'){
					AE.addEntity(new FlapFlap(i*16, j*16));
				}
				if(v_map[i][j]=='d'){
					AE.addEntity(new Diamond(i*16, j*16));
				}
				if(v_map[i][j]=='b'){
					AE.addEntity(new BimBim(i*16, j*16));
				}
				if(v_map[i][j]=='r'){
					AE.addEntity(new Rock(i*16, j*16));
				}
				if(v_map[i][j]=='e'){
					AE.addEntity(new Door(i*16, j*16));
				}
				if(v_map[i][j]=='p'){
					AE.addEntity(new Player(i*16, j*16));
				}
				if(v_map[i][j]=='u'){
					AE.addEntity(new PuffPuff(i*16, j*16));
				}
				
				
				
				
			}
		}
		AE.addEntity(new Diamondcompteur(DC,0,16));
	}

	public void update(){
		l=Win.getkey(); //we get the keystroke
		CharacterView cv = new CharacterView(c_map);
		v_map=cv.getCView(); //we get the player's view, depending on the players Position
		this.testMap(); //
		c_map = ev.movement(l, c_map);//movement depending on the keystrokes
		if (ev.getGotDiamond()){//if you catch a diamond, it appears in the count.
			DC++;
		}
		

		Win.getWe().repaint();// repaint everything to it's new pos 

		
	}

	
}
