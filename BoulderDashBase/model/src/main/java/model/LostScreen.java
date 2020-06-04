package model;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @see Entity
 * @author      Zangue Olivarex
 * @since       2020-05-27
 *
 */

public class LostScreen extends Entity  {
/**
 * 
 * @param x		dimension
 * @param y		dimension
 */
	public LostScreen(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getWSImg(), x, y, null);
	}
	 /**
	  * Show the game over image in case you loose   
	  * @return ic.getImage()
	  */
	public Image getWSImg()
	{
		ImageIcon ic = new ImageIcon("Image_jeu/WLScreen/gameOver.jpg");
		return ic.getImage();	
	}

}


