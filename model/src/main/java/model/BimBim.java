package model;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * 
 * @author MIRLEINE BOUANGA
 * @see Entity
 *
 */
public class BimBim extends Entity{
	
	public BimBim(int x, int y) {
		super(x, y);
	}

	public void update()
	{
		
	}
	
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getBimBimImg(), x, y, null);
	}
	
	public Image getBimBimImg()
	{
		ImageIcon ic = new ImageIcon("Image_jeu/Monstres/Pouple.png");
		return ic.getImage();	
	}


}
