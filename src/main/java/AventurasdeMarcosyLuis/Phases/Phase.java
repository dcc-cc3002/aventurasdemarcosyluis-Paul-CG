package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Controllers.GameController;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidChoiceException;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTransitionException;

import java.util.Scanner;

/**
 * This class is used as a base to create all others phases
 */
public class Phase {

    protected GameController controller;
    protected Scanner reader;
    public boolean toLoad;
    public boolean toBattleStart;
    public boolean toWaitChoice;
    public boolean toWaitAttack;
    public boolean toWaitItem;
    public boolean toAttack;
    public boolean toItem;
    public boolean toEnemyAttack;
    public boolean toEndTurn;
    public boolean toEndBattle;
    public boolean toEndGame;

    /**
     * The constructor initializes with all transitions as false, to improve security against code injection
     */
    public Phase() {
        this.toLoad = false;
        this.toBattleStart = false;
        this.toWaitChoice = false;
        this.toWaitAttack = false;
        this.toWaitItem = false;
        this.toAttack = false;
        this.toItem = false;
        this.toEnemyAttack = false;
        this.toEndTurn = false;
        this.toEndBattle = false;
        this.toEndGame = false;
    }

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
    public void toNextPhase() throws InvalidTransitionException, InvalidChoiceException {
        throw new InvalidTransitionException("This transition is not allowed.");
    }


}
