package view;

import java.awt.BorderLayout;

import javax.swing.*;

import contract.LevelSelector;
import controller.NavigationBetweenViewController;
import view.MenuImage;
import view.MenuLevelSelector;


/**
 * MenuView
 *
 * Menu view
 *
 *@author      Mouafo Cindy 
 * @since       2020-05-23
 */
public class MenuView extends JFrame {
	private NavigationBetweenViewController navigationBetweenViewController;
    private MenuImage menuImage;
    private MenuLevelSelector menuLevelSelector;
	private JPanel actionPanel;
    private JPanel targetPanel;

    /**
     * Class constructor
     */
	public MenuView(NavigationBetweenViewController navigationBetweenViewController) {
		this.navigationBetweenViewController = navigationBetweenViewController;
		this.initializeView();
		this.createLayout();
	}

    /**
     * Initializes the view
     */
    private void initializeView() {
        this.setVisible(true);
        this.setResizable(false);

        // UI parameters
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(350, 100, 200, 100);
        this.setSize(1000, 700);

        // App parameters
        this.setTitle("Boulder Dash | Menu");
    }

    /**
     * Creates the view layout
     */
    private void createLayout() {
        LevelSelector levelSelector = new LevelSelector(false);
        this.menuLevelSelector = levelSelector.createLevelList();

        this.targetPanel = new JPanel();

        this.menuImage = new MenuImage();
    	this.actionPanel = new JPanel();
    	
        // Add some buttons on the actionPanel
        this.createButton("game", "Game");
        this.createButton("quit", "Quit");

        this.add(this.menuImage, BorderLayout.CENTER);
        this.add(targetPanel, BorderLayout.SOUTH);

        this.targetPanel.add(this.menuLevelSelector, BorderLayout.NORTH);
        this.targetPanel.add(this.actionPanel, BorderLayout.SOUTH);
    }

    /**
     * Creates the given button
     *
     * @param   name  Button name
     * @return  Created button
     */
	public JButton createButton(String id, String name) {
		JButton button = new JButton(name);
		button.addActionListener(this.navigationBetweenViewController);
        button.setActionCommand(id);

		this.actionPanel.add(button);

		return button;
	}

    /**
     * Gets the selected level identifier!
     *
     * @return  Level identifier
     */
    public String getLevelIdentifier() {
        return this.menuLevelSelector.getChoiceValue();
    }
}
