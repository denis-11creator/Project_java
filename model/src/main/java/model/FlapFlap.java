package model;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class FlapFlap extends Entity {
/**
 * @author MIRLEINE BOUANGA
 * @param x
 * @param y
 */
	public FlapFlap(int x, int y) {
		super(x, y);
	}

	public void update()
	{
		 
	}
	
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getFlapFlapImg(), x, y, null);
	}
	
	public Image getFlapFlapImg()
	{
		ImageIcon ic = new ImageIcon("Image_jeu/Monstres/Chauve-souris.png");
		return ic.getImage();	
	}

	

}
