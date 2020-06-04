package model;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class PuffPuff extends Entity{
	/**
	 * @author      Zangue Olivarex
	 * @since       2020-05-27
	 * @param x		position
	 * @param y		position
	 */
	public PuffPuff(int x, int y) {
		super(x, y);
	}

	public void update()
	{
		 
	}
	
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getPuffPuffImg(), x, y, null);
	}
	
	public Image getPuffPuffImg()
	{
		ImageIcon ic = new ImageIcon("Image_jeu/Monstres/Papillon.png");
		return ic.getImage();	
	}

	public void unleashDiamonds(){
		
	}
}
