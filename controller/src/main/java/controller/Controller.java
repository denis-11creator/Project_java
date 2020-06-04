package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
/**
 * The Class Controller.
 * @author ARISTIDE KOLOKO
 * 
 */
public class Controller implements KeyListener{

public boolean ZKey = false;
public boolean QKey = false; 
public boolean SKey = false; 
public boolean DKey = false; 
public boolean WKey = false; 
public boolean XKey = false; 
public boolean EscapeKey = false;

	public Controller(){
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_Z){
			ZKey=true;
			System.out.println("z");
		}
		if(e.getKeyCode() == KeyEvent.VK_Q){
			QKey=true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			SKey=true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			DKey=true;
		}
		if(e.getKeyCode() == KeyEvent.VK_W){
			WKey=true;
		}
		if(e.getKeyCode() == KeyEvent.VK_X){
			XKey=true;
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			EscapeKey=true;
		}
		}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_Z){
			ZKey=false;
		}
		if(e.getKeyCode() == KeyEvent.VK_Q){
			QKey=false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			SKey=false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			DKey=false;
		}
		if(e.getKeyCode() == KeyEvent.VK_W){
			WKey=false;
		}
		if(e.getKeyCode() == KeyEvent.VK_X){
			XKey=false;
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			EscapeKey=false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

