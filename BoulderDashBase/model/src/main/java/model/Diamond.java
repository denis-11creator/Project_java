package model;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Diamond extends Entity{
/**
 * @author      Zangue Olivarex
 * @since       2020-05-27
 * @param x        diamond
 * @param y        diamond
 */
	public Diamond(int x, int y) {
		super(x, y);
	}

	public void update()
	{
		 
	}
	
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getDiamondImg(), x, y, null);
	}
	/**
	 * Print the Diamond's image on the game's window
	 * @return ic.getImage
	 */
	public Image getDiamondImg()
	{
		ImageIcon ic = new ImageIcon("Image_jeu/Diamand/Diamand.png");
		return ic.getImage();	
	}
}
