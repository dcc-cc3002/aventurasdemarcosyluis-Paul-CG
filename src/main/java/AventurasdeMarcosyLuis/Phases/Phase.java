package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Controllers.GameController;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTransitionException;

import java.util.Scanner;

/**
 * This class is used as a base to create all others phases
 */
public class Phase {

    protected GameController controller;
    protected Scanner reader;
    public boolean canIStart;
    public boolean canIAttack;
    public boolean canIUseItem;
    public boolean canIPass;
    public boolean canISelectEnemy;
    public boolean canISelectItem;
    public boolean isEnemyTurn;
    public boolean invalidTarget;

    /**
     * Allows to set the controller to each phase
     * @param controller of the game
     */
    public void setController(GameController controller){
        this.controller = controller;
    }

    /**
     * Used to get the name of the phase we are at
     * @return name of the phase
     */
    public String toString(){
        return "Phase";
    }

    /**
     * Calls the controller to set the phase to a new one
     * @param phase new phase
     */
    public void changePhase(Phase phase){
        controller.setPhase(phase);
    }

    /**
     * This method guides the flow of the game. It behaves accordingly to the phase that is currently active.
     * @throws InvalidTransitionException in case of a transition that is not allowed
     */
    public void toNextPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("You can't change to that Phase.");
    }


}
