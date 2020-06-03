package view;

import javax.swing.*;

import controller.GameController;
import controller.GameKeyController;
import model.Level;
import view.GroundView;

import java.awt.*;


/**
 * GameFieldView
 *
 * Game field view for the game itself.
 *
 * @author      Mouafo Cindy 
 * @since       2020-05-23
 */
public class GameGroundView extends GroundView {
    private GameController gameController;

    /**
     * Class constructor
     *
     * @param  gameController  Game controller
     * @param  level      Level model
     */
    public GameGroundView(GameController gameController, Level level) {
        super(level);

        this.gameController = gameController;

        this.addKeyListener(new GameKeyController(this.level, this.gameController.getAudioLoadHelper()));

        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setFocusable(true);
    }
}
