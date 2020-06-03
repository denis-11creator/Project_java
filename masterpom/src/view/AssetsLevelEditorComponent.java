package view;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

import view.LevelEditor;


/**
 * AssetsLevelEditorComponent
 *
 * Information panel element.
 *
 * @author      Mouafo Cindy 
 * @since       2020-05-23
 */
public class AssetsLevelEditorComponent extends JPanel implements ActionListener {
    private LevelEditor levelEditor;

    /**
     * Available choices
     */
    static List<String> choiceList = Arrays.asList(
            "Boulder", "Diamond", "Dirt", "Brick Wall", "Expanding Wall", "Magic Wall", "Steel Wall", "Rockford"
    );

    /**
     * Class constructor
     *
     * @param  levelEditor  Controller for level editor
     */
    public AssetsLevelEditorComponent(LevelEditor levelEditor) {
        super(new BorderLayout());

    	this.levelEditor = levelEditor;
        ButtonGroup buttonGroup = new ButtonGroup();
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));

        String curListChoice;

        for(int i = 0; i < choiceList.size(); i++) {
            curListChoice = choiceList.get(i);

            // Create radio buttons from list
            JRadioButton curButton = new JRadioButton(curListChoice);
            //boulderButton.setMnemonic(KeyEvent.VK_A);
            curButton.setActionCommand(curListChoice);

            // Group the radio buttons
            buttonGroup.add(curButton);

            // Register a listener for the radio buttons
            curButton.addActionListener(this);

            // Put the radio buttons in a column in a panel
            radioPanel.add(curButton);
        }

        this.add(radioPanel, BorderLayout.LINE_START);
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    /**
     * Listens for action events
     *
     * @param  e  Action event
     */
    public void actionPerformed(ActionEvent e) {
        JRadioButton sourceButton = (JRadioButton) e.getSource();
        String sourceText = sourceButton.getText();

        this.levelEditor.setPickedBlockValue(sourceText);
        this.levelEditor.getLevelEditorGroundView().grabFocus();
    }
}