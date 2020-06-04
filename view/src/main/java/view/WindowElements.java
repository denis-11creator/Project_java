package view;

import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Entity;
import model.Player;
/**
 * 
 * @author DUVAL FOTSO
 * 
 *
 */

public class WindowElements extends JPanel implements ActionListener{

	Timer mainTimer;
	Entity entity;
	ArrayList<Entity> entities = new ArrayList<Entity>();
	public WindowElements(ArrayList<Entity> entities)
	{
		this.entities = entities;
		setFocusable(true);
		mainTimer = new Timer (10, this);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < entities.size(); i++)
		{
			Entity tempPlayer = entities.get(i);
			tempPlayer.draw(g2d);
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	} 
	
	
}

