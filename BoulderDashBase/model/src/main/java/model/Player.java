package model;

import java.awt.Graphics2D;
import java.awt.Image;


import javax.swing.ImageIcon;

public class Player extends Entity{

	int NbDiamTaken=0;
/**
 * @author      Zangue Olivarex
 * @since       2020-05-27
 * @param x		position
 * @param y		position
 */
	
	public Player(int x, int y) {
		super(x, y);
	}

	public void update()
	{
		
	}
	
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getPlayerImg(), x, y, null);
	}
	/**
	 * This Method print the image player on the window 
	 * @return ic.getImage()
	 */
	public Image getPlayerImg()
	{
		ImageIcon ic = new ImageIcon("Image_jeu/Personnage/Face/Face 1.png");
		return ic.getImage();	
	}

	
	public void takeDiamond() {
		
	}
	
	public void move(){
		
	}

	public void moveRock(){
		
	}
}
