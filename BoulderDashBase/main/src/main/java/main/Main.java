package main;

import java.sql.SQLException;

import contract.GameLoop;



public abstract class Main {
/**
 * @author      Annan Gassu
 * @since       2020-05-30
 * @param args
 */
	
    public static void main(final String[] args) {
 	GameLoop GL = new GameLoop();
 	GL.createGame();
    }

}