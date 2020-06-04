package model;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;



public class WinScreen extends Entity  {
  /**
   * @author      Zangue Olivarex
   * @since       2020-05-27
   * @param x		position
   * @param y		position
   */
	public WinScreen(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getWSImg(), x, y, null);
	}
	 /**
	  * Show the game win image
	  * @return ic.getImage()
	  */
	public Image getWSImg()
	{
		ImageIcon ic = new ImageIcon("Image_jeu/WLScreen/gameWin.jpg");
		return ic.getImage();	
	}

}


