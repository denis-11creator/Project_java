package view;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.DetectionTouches;
import model.Entity;



public class Window extends JFrame implements KeyListener {
	
	int key=0;
	private WindowElements we;
	/**
	 * @author DUVAL FOTSO 
	 * Window's settings
	 * @see Entity
	 *@return void
	 */
	public void Window(ArrayList<Entity> entities)
	{
		JFrame win = new JFrame();
		we = new WindowElements(entities);
		DetectionTouches l = new DetectionTouches();
	    win.setTitle("BoulderDash");
	    win.setSize(250, 250);
	    win.setResizable(false);
	    win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    win.setLocationRelativeTo(null);
	    win.add(we);
	    win.setVisible(true);
	    win.addKeyListener(this);
	    win.setFocusable(true);
	    win.setAlwaysOnTop(true);
	   
	}
	public int getkey(){
		//System.out.println(key);
		return key;
	}
	public WindowElements getWe(){
		return we;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		 key = e.getKeyCode();
		 System.out.println(key);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		key=0;
		System.out.println(key);
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




}
