package AventurasdeMarcosyLuis;

import AventurasdeMarcosyLuis.Controllers.GameController;

public class Main {
    public static void main (String [] args){
        GameController controller = new GameController();

        while(!controller.getEndOfGame()){
            controller.tryNextPhase();
        }
    }
}
