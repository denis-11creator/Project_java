package model;

import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener;

/**
 * 
 * @author MIRLEINE BOUANGA
 *
 */
public class DetectionTouches implements KeyListener{

private boolean ZKey ;
private boolean QKey ; 
private boolean SKey ; 
private boolean DKey ; 
private boolean WKey ; 
private boolean XKey ; 
private boolean EscapeKey ;
 


	public DetectionTouches(){
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("a key has been pressed ...");
		
		if(e.getKeyCode() == KeyEvent.VK_Z){
			ZKey=true;
			System.out.println("z"+ZKey);
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
		System.out.println("a key has been released ...");
		
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
	
	public boolean isUPKey() {
		return ZKey;
	}
	
	public boolean isQKey() {
		return QKey;
	}
	
	public boolean isSKey() {
		return SKey;
	}
	
	public boolean isDKey() {
		return DKey;
	}
	
	public boolean isWKey() {
		return WKey;
	}
	
	public boolean isXKey() {
		return XKey;
	}
	
	public boolean isEscapeKey() {
		return EscapeKey;
	}
	
}

