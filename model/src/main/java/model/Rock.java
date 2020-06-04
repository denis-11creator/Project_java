package model;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Rock extends Entity{
      /**
       * @author DUVAL FOTSO 
       * @param x
       * @param y
       */
	
	public Rock(int x, int y) {
		super(x, y);
	}

	public void update()
	{
		 
	}
	
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getRockImg(), x, y, null);
	}
	/**
	 * Shows the rock image on the window
	 * @return
	 */
	public Image getRockImg()
	{
		ImageIcon ic = new ImageIcon("Image_jeu/Rocher/Rocher.png");
		return ic.getImage();	
	}


	public void collision(){
		
	}
	
}
