package contract;


import java.io.File;

/**
 * LevelRemoveHelper
 *
 * Proceeds level save routine
 * Able to iterate on internal representation of a map and serialize it to XML
 *
 * @author      Zangue Olivarex
 * @since       2020-05-28
 */
public class LevelRemove {
    private static String pathToDataStore = "./res/levels";
    private String levelId = null;

    /**
     * Class constructor
     *
     * @param  levelId  Level identifier
     */
    public LevelRemove(String levelId) {
        this.levelId = levelId;

        File file = new File(this.getLevelPathInDataStore());
        file.delete();
    }

    /**
     * Gets level storage path
     *
     * @return  Level path, with file extension
     */
    private String getLevelPathInDataStore() {
        return this.pathToDataStore + "/" + this.levelId + ".xml";
    }
}
