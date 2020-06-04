package model;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;



public class WinScreen extends Entity  {
  /**
   * @author DUVAL FOTSO
   * @param x
   * @param y
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
	  * @return
	  */
	public Image getWSImg()
	{
		ImageIcon ic = new ImageIcon("Image_jeu/WLScreen/gameWin.jpg");
		return ic.getImage();	
	}

}


