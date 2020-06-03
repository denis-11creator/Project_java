package view;

import javax.swing.*;

import view.LevelEditor;

import java.awt.event.ActionEvent;


/**
 * MenuLevelSelector
 *
 * Specifies the menu level selector
 *
 * @author      Mouafo Cindy 
 * @since       2020-05-23
 */
public class MenuLevelSelector extends JComboBox {
    private String choiceValue;
    private LevelEditor levelEditor = null;

    /**
     * Class constructor
     */
    public MenuLevelSelector(String[] items) {
        super(items);
    }

    public MenuLevelSelector(String[] items, LevelEditor levelEditor) {
        this(items);
        this.levelEditor = levelEditor;
    }

    /**
     * Called when an action is performed
     *
     * @param  e  Action event
     */
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBoxSource = (JComboBox) e.getSource();
        this.choiceValue = (String) comboBoxSource.getSelectedItem();

        if(this.levelEditor != null) {
            this.levelEditor.menuLevelSelectorChanged(this);
        }
    }

    /**
     * Gets the choice value
     *
     * @return  Choice value
     */
    public String getChoiceValue() {
        return this.choiceValue;
    }

    /**
     * Selects a given value
     *
     * @param  value  Value to be selected
     */
    public void setSelectedValue(String value) {
        for (int i = 0; i < this.getItemCount(); i++) {
            if (this.getItemAt(i).toString().equals(value)) {
                this.setSelectedIndex(i);
                break;
            }
        }
    }

    /**
     * Sets the choice value
     *
     * @param  choiceValue  Choice value
     */
    public void setChoiceValue(String choiceValue) {
        this.choiceValue = choiceValue;
    }
}
