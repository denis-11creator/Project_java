package contract;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import view.LevelEditor;
import view.MenuLevelSelector;


/**
 * LevelSelectorHelper
 *
 * Level selector helper
 *
 *@author      Zangue Olivarex
 * @since       2020-05-28
 */
public class LevelSelector {
    private static String levelStorage = "./res/levels";
    private boolean hasEmptyElement = false;
    private LevelEditor levelEditor = null;

    /**
     * Class constructor
     */
    public LevelSelector(boolean hasEmptyElement) {
        this.hasEmptyElement = hasEmptyElement;
    }

    public LevelSelector(boolean hasEmptyElement, LevelEditor levelEditor) {
        this(hasEmptyElement);

        this.levelEditor = levelEditor;
    }

    /**
     * Creates the level list
     *
     * @return  Level list selector
     */
    public MenuLevelSelector createLevelList() {
        String[] availableLevels = this.listAvailableLevels();

        // Proceed available levels listing
        MenuLevelSelector menuLevelList = new MenuLevelSelector(availableLevels, this.levelEditor);

        if(availableLevels.length > 0) {
            menuLevelList.setChoiceValue(availableLevels[0]);
            menuLevelList.setSelectedIndex(0);
        };

        menuLevelList.addActionListener(menuLevelList);

        return menuLevelList;
    }

    /**
     * Lists available levels and store them in instance context
     *
     * @return  Available levels
     */
    private String[] listAvailableLevels() {
        List<String> stockList = new ArrayList<String>();

        File directory = new File(levelStorage);
        File[] fileList = directory.listFiles();
        String fileName, fileNameExtValue;
        int fileNameExtIndex;

        // Add empty element?
        if(this.hasEmptyElement) {
            stockList.add("");
        }

        for (File file : fileList){
            fileName = file.getName();
            fileNameExtIndex = fileName.lastIndexOf('.');

            if (fileNameExtIndex > 0) {
                fileNameExtValue = fileName.substring(fileNameExtIndex, fileName.length());

                if(fileNameExtValue.equals(".xml")) {
                    fileName = fileName.substring(0, fileNameExtIndex);
                    stockList.add(fileName);
                }
            }
        }

        // Convert to String[] (required)
        String[] itemsArr = new String[stockList.size()];
        itemsArr = stockList.toArray(itemsArr);

        return itemsArr;
    }
}
