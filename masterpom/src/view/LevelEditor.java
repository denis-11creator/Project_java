package view;

import javax.swing.*;

import contract.LevelSelector;
import controller.LevelEditorController;
import controller.NavigationBetweenViewController;
import model.Level;
import view.AssetsLevelEditorComponent;
import view.LevelEditorGroundView;
import view.MenuLevelSelector;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;


/**
 * LevelEditor
 *
 * Specifies the level editor view.
 *
 * @author      Mouafo Cindy 
 * @since       2020-05-23
 */
public class LevelEditor extends JFrame implements Observer {
    private LevelEditorGroundView fieldPanel;
    private JPanel selectPanel;
    private AssetsLevelEditorComponent assetsComponent;
    private JPanel actionsComponent;
    private String selectedLevel;
    private MenuLevelSelector menuLevelSelector;
    private NavigationBetweenViewController nav;

    private LevelEditorController levelEditorController;
    private Level level;

    private String pickedBlockValue;

    /**
     * Class constructor
     */
	public LevelEditor(LevelEditorController levelEditorController, Level level, NavigationBetweenViewController nav) {
        this.levelEditorController = levelEditorController;
        this.level = level;
        this.nav = nav;

        this.level.addObserver(this);

		this.initializeView();
        this.createLayout();

        this.fieldPanel.grabFocus();
	}

    /**
     * Initializes the view layout
     */
	private void initializeView() {
        this.setFocusable(true);
        this.setVisible(false);
        this.setResizable(false);

        // UI parameters
        this.setSize(984, 454);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // App parameters
        this.setTitle("Boulder Dash | Level Editor");

        Image appIcon = Toolkit.getDefaultToolkit().getImage("./sprites/app_icon.png");
        this.setIconImage(appIcon);
	}

    /**
     * Creates the view layout
     */
	private void createLayout() {
        // List of levels
        LevelSelector levelSelector = new LevelSelector(true, this);
        this.menuLevelSelector = levelSelector.createLevelList();

        // Field + select panels
		this.fieldPanel = new LevelEditorGroundView(this.level, this);
        this.selectPanel = new JPanel();

        this.assetsComponent = new AssetsLevelEditorComponent(this);
        this.actionsComponent = new JPanel();

        // Add actions
        this.actionsComponent.add(this.menuLevelSelector);
        this.actionsComponent.add(this.createButton("save", "Save"));
        this.actionsComponent.add(this.createButton("delete", "Delete"));
        this.actionsComponent.add(this.createButton("new", "New level"));
        this.actionsComponent.add(this.createButton("menu", "Menu"));
 

        // Add select panel subcomponents
        this.selectPanel.setLayout(new BoxLayout(this.selectPanel, BoxLayout.Y_AXIS));

        this.selectPanel.add(this.assetsComponent);
        this.selectPanel.add(this.actionsComponent);

        // Add top components
        this.add(this.fieldPanel, BorderLayout.CENTER);
        this.add(this.selectPanel, BorderLayout.WEST);
	}

    /**
     * Creates the given button
     *
     * @param   id    Button identifier
     * @param   name  Button name
     * @return  Created button
     */
    public JButton createButton(String id, String name) {
        JButton button = new JButton(name);
        button.addActionListener(this.levelEditorController);
        button.setActionCommand(id);

        return button;
    }

    /**
     * Gets the level editor field view
     *
     * @return  Level editor field view
     */
    public LevelEditorGroundView getLevelEditorGroundView() {
        return this.fieldPanel;
    }

    /**
     * Gets picked block value
     *
     * @return  Picked block value
     */
    public String getPickedBlockValue() {
        return this.pickedBlockValue;
    }

    /**
     * Sets picked block value
     *
     * @param  pickedBlockValue  Picked block value
     */
    public void setPickedBlockValue(String pickedBlockValue) {
        this.pickedBlockValue = pickedBlockValue;
    }

    /**
     * Updates the view
     *
     * @param  obs  Observable item
     * @param  obj  Object item
     */
    @Override
    public void update(Observable obs, Object obj) {
        // Nothing done.
    }

    /**
     * Change opened level
     *
     * @param  selectedLevelValue  Selected level value
     */
    public void openedLevelChange(String selectedLevelValue) {
        Level pickedLevelModel;

        if(selectedLevelValue != null && !selectedLevelValue.isEmpty()) {
            // Load existing model
            pickedLevelModel = new Level(selectedLevelValue, this.nav.getAudioLoadHelper(), "editor");
        } else {
            // New blank model for editor
            pickedLevelModel = new Level(this.nav.getAudioLoadHelper());
        }

        pickedLevelModel.setShowCursor(true);
        pickedLevelModel.setMode("editor");
        this.level = pickedLevelModel;

        // Hide old view
        this.levelEditorController.getLevelEditorView().dispose();

        this.levelEditorController = new LevelEditorController(this.level, this.nav);

        this.levelEditorController.getLevelEditorView().setSelectedLevel(selectedLevelValue);
        this.levelEditorController.getLevelEditorView().setVisible(true);
        this.levelEditorController.getLevelEditorView().getLevelEditorGroundView().grabFocus();

        this.levelEditorController.getLevelEditorView().menuLevelSelector.setChoiceValue(selectedLevelValue);
        this.levelEditorController.getLevelEditorView().menuLevelSelector.setSelectedValue(selectedLevelValue);
    }

    /**
     * Menu level selector change handler
     *
     * @param  changedSelector  Changed selector
     */
    public void menuLevelSelectorChanged(MenuLevelSelector changedSelector) {
        String selectedLevelValue = changedSelector.getChoiceValue().toString();

        // Value didn't change?
        if(selectedLevelValue.equals(this.getSelectedLevel())) {
            return;
        }

        this.openedLevelChange(selectedLevelValue);
    }

    /**
     * Gets selected level
     *
     * @return  Selected level
     */
    public String getSelectedLevel() {
        return this.selectedLevel;
    }

    /**
     * Sets selected level
     *
     * @param  level  Selected level
     */
    public void setSelectedLevel(String level) { 
    	this.selectedLevel = level;
    }
}