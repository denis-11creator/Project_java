package model;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Door extends Entity{
	
	/**
	 * @author MIRLEINE BOUANGA
	 * @param x
	 * @param y
	 * @see Entity
	 * 
	 */
	public Door(int x, int y) {
		super(x, y);
	}

	public void update()
	{
		
	} 
	
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getDoorImg(), x, y, null);
	}
	/**
	 * Shows the image of the door in the game's window
	 * @return image
	 */
	public Image getDoorImg()
	{
		ImageIcon ic = new ImageIcon("Image_jeu/Porte/Porte.png");
		return ic.getImage();	
	}

	
	public void checkWin(){
		
	}
}
