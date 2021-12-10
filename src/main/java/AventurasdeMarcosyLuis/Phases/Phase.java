package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Controllers.GameController;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTransitionException;

public class Phase {

    protected GameController controller;
    public boolean canIStart;
    public boolean canIAttack;
    public boolean canIUseItem;
    public boolean canIPass;
    public boolean canISelectEnemy;
    public boolean canISelectItem;

    public void setController(GameController controller){
        this.controller = controller;
    }

    /**public void changePhase(Phase phase){
        controller.setPhase(phase);
    }

    public void startTurn() throws InvalidTransitionException {
        if (!canIStart && !controller.didIWIn()){

        }
    }**/
}
