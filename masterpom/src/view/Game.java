package view;

import javax.swing.*;

import controller.GameController;
import model.Level;
import view.GameGroundView;
import view.InformationPanel;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;


/**
 * Game
 *
 * Specifies the game view itself.
 *
 * @author      Mouafo Cindy 
 * @since       2020-05-23
 */
public class Game extends JFrame implements Observer {
	private GameGroundView gameGroundView;
	private JPanel actionPanel;
	private JPanel informationPanel;
	private GameController gameController;
	private Level level;

    /**
     * Class constructor
     *
     * @param  gameController  Game controller
     * @param  level      Level model
     */
	public Game(GameController gameController, Level level) {
		this.gameController = gameController;
		this.level = level;
		
        this.initializeView();
        this.createLayout();

        this.gameGroundView.grabFocus();
	}

    /**
     * Initializes the view
     */
    private void initializeView() {
        this.setVisible(false);
        this.setResizable(false);

        // UI parameters
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setBounds(400, 155, 532, 636);

        // App parameters
        this.setTitle("Boulder Dash | Game");

        Image appIcon = Toolkit.getDefaultToolkit().getImage("./sprites/app_icon.png");
        this.setIconImage(appIcon);
    }

    /**
     * Creates the view layout
     */
    private void createLayout() {
        this.gameGroundView = new GameGroundView(this.gameController, this.level);
        this.actionPanel = new JPanel();
        this.informationPanel = new InformationPanel(this.level);
        this.informationPanel.setBackground(Color.white);


        // Add some buttons on the informationPanel
        this.createButton("restart", "Restart");
        this.createButton("pause", "Pause");
        this.createButton("menu", "Menu");

        this.add(this.actionPanel, BorderLayout.SOUTH);
        this.add(this.informationPanel, BorderLayout.NORTH);
        this.add(this.gameGroundView, BorderLayout.CENTER);
    }

    /**
     * Gets the game field view
     *
     * @return  Game field view
     */
	public GameGroundView getGameFieldView() {
		return this.gameGroundView;
	}

    /**
     * Creates the given button
     *
     * @param   name  Button name
     * @return  Created button
     */
	public JButton createButton(String id, String name) {
		JButton button = new JButton(name);
		button.addActionListener(this.gameController);
		button.setActionCommand(id);

		this.actionPanel.add(button);

		return button;
	}

	/**
     * Updates the frame
     *
     * @param   obs  Observable item
     * @param   obj  Object item
     */
	@Override
	public void update(Observable obs, Object obj) {
		// Nothing done.
	}
}