package model;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * @param x,y
 * @author MIRLEINE BOUANGA
 *
 */
public class EmptyWall extends Entity {

	
	
	public EmptyWall(int x, int y) {
		super(x, y);
	}

	public void update()
	{
	
	}
	
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getEWImg(), x, y, null);
	}
	
	public Image getEWImg()
	{
		ImageIcon ic = new ImageIcon("Image_jeu/Mur/Mur_cassé.png");
		return ic.getImage();	
	}

}
