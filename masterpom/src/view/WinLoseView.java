package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class WinLoseView extends JFrame{

	/**
	*@author      Mouafo Cindy 
 * @since       2020-05-23
	*
	*/
	private String winOrLose;

	/**
	 * Generate the HelpView
	 */
	public WinLoseView(String winOrLose){
		this.winOrLose = winOrLose;
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
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setBounds(300, 300, 250, 100);

        // App parameters
        this.setTitle("END OF THE GAME ! ");
    }

    /**
     * Creates the view layout
     */
    private void createLayout() {    	
    	JTextArea help = new JTextArea();
    	help.setEditable(false);
    	if(winOrLose.equals("win"))
	    	help.setText("YOU WIN THE GAME ");
    	else
    		help.setText("YOU FAILED THE GAME 😌 ; TRY AGAIN !");
    	
        this.add(help);
    }
}
