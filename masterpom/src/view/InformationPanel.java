package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Level;


/**
 * InformationPanel
 *
 * Information panel element.
 *
 * @author      Mouafo Cindy 
 * @since       2020-05-23
 */
public class InformationPanel extends JPanel implements Observer {
	private Level level;
	private JTextArea text;

    /**
     * Class constructor
     */
	public InformationPanel(Level level) {
		this.level = level;
		this.text = new JTextArea();
		this.text.setEditable(false);
		this.level.getGameInformationModel().addObserver(this);

		this.text.setText(
                "Score : " + level.getGameInformationModel().getScore() +
				"\nRemaining diamonds : " + level.getGameInformationModel().getRemainingsDiamonds()
        );

		this.add(this.text);
	}

    /**
     * Updates the panel
     *
     * @param  o    Observable item
     * @param  arg  Object item
     */
	@Override
	public void update(Observable o, Object arg) {
		this.text.setText(
                "Score : " + this.level.getGameInformationModel().getScore() +
				"\nRemaining diamonds : " + this.level.getGameInformationModel().getRemainingsDiamonds()
        );
	}
}
