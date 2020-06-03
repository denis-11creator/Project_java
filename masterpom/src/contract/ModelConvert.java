package contract;

import entity.UnknownModelException;
import model.Rock;
import model.Diamond;
import model.Ground;
import model.DisplayableElementModel;
import model.EmptyModel;
import model.LeftWall;
import model.RightWall;
import model.Rockford;
import model.Wall;


/**
 * ModelConvertHelper
 *
 * Provides model conversion services.
 *
 * @author      Zangue Olivarex
 * @since       2020-05-28
 */
public class ModelConvert {
    /**
     * Class constructor
     */
    public ModelConvert() {
        // Nothing done.
    }

    /**
     * Gets the model associated to the string
     *
     * @param   spriteName  Sprite name
     * @return  Model associated to given sprite name
     */
    public DisplayableElementModel toModel(String spriteName, boolean isConvertible) throws UnknownModelException {
        DisplayableElementModel element;

        // Instanciates the sprite element matching the given sprite name
        switch (spriteName) {
            case "black":
            case "Black":
                element = new EmptyModel();
                break;

            case "boulder":
            case "Boulder":
                element = new Rock(isConvertible);
                break;


            case "diamond":
            case "Diamond":
                element = new Diamond();
                break;

            case "dirt":
            case "Dirt":
                element = new Ground();
                break;

            case "magicwall":
            case "Magic Wall":
                element = new RightWall();
                break;

            case "rockford":
            case "Rockford":
                element = new Rockford();
                break;

            case "steelwall":
            case "Steel Wall":
                element = new Wall();
                break;

            case "expandingwall":
            case "Expanding Wall":
                element = new LeftWall();
                break;

            default:
                throw new UnknownModelException("Unknown model element > " + spriteName);
        }

        return element;
    }

    /**
     * Gets the string associated to the model
     *
     * @return  Model string name
     */
    public String toString(DisplayableElementModel model) {
        return model.getSpriteName();
    }
}
