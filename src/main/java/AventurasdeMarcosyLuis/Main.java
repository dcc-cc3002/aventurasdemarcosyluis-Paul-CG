package AventurasdeMarcosyLuis;

import AventurasdeMarcosyLuis.Controllers.GameController;

/**
 * Main class that runs the game
 */
public class Main {
    /**
     * Well known main class
     * @param args just in case
     */
    public static void main (String [] args){
        // Controller of the game
        GameController controller = new GameController();

        // We iterate over tryNextPhase() to play the game. Once the game is ready, we leave the loop.
        while(!controller.getEndOfGame()){
            controller.tryNextPhase();
        }
    }
}
