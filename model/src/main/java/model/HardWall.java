package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class HardWall extends Entity{
/**
 * @author MIRLEINE BOUANGA
 * @param x
 * @param y
 */
	public HardWall(int x, int y) {
		super(x, y);
	}

	public void update()
	{
		 
	}
	
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getHWImg(), x, y, null);
	}
	/**
	 * This method enables us to see the ground which covers almost the whole window
	 * @return
	 */
	public Image getHWImg()
	{
		File file = new File("Image_jeu/Mur/Terre_non_cassé.png");
		String path=file.getAbsolutePath();
		ImageIcon ic = new ImageIcon(path);
		return ic.getImage();	
	}
	

	public void transformToEmpty(){
		
	}
	
}
