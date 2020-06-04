package model;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;


public class UnbreakableWall extends Entity{
	/**
	 * @author      Zangue Olivarex
	 * @since       2020-05-27
	 * @param x		position
	 * @param y		position
	 * print the wall's image
	 */
	public UnbreakableWall(int x, int y) {
		super(x, y);
	}

	public void update()
	{
		 
	}
	
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getUWImg(), x, y, null);
	}
	
	public Image getUWImg()
	{
		ImageIcon ic = new ImageIcon("Image_jeu/Mur/mur_incassable.png");
		return ic.getImage();	
	}
	
	public void collision(){
		
	}
}
