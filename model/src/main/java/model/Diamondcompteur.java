package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Diamondcompteur extends Entity{
/**
 * Count the number of Diamods collected
 * @author MIRLEINE BOUANGA
 */
	private int DC;
	public Diamondcompteur(int DC,int x, int y) {
		super(x, y);
		this.DC=DC;
	}
	/**
	 * @return void
	 */
	public void draw(Graphics2D g2d)
	{
		g2d.setFont(new Font("default", Font.BOLD, 16));  
		g2d.setColor(Color.white);
		g2d.drawString("" + DC, x, y);
	}
	
}
 