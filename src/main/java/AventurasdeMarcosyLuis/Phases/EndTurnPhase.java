package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTransitionException;

/**
 * This Phase end the turn updating all needed variables
 */
public class EndTurnPhase extends Phase{

    /**
     * The constructor allows transitions to WaitChoice and EndBattle phases.
     */
    public EndTurnPhase(){
        this.toLoad = false;
        this.toBattleStart = false;
        this.toWaitChoice = true;
        this.toWaitAttack = false;
        this.toWaitItem = false;
        this.toAttack = false;
        this.toItem = false;
        this.toEnemyAttack = false;
        this.toEndTurn = false;
        this.toEndBattle = true;
        this.toEndGame = false;
    }

    @Override
    public String toString(){
        return "End Turn Phase";
    }

    @Override
    public void toNextPhase() throws InvalidTransitionException {

        if(toEndBattle && toWaitChoice &&
                !(toLoad && toBattleStart && toWaitAttack && toWaitItem && toAttack && toItem && toEnemyAttack && toEndTurn && toEndGame)){

            controller.removeDead();
            controller.formCurrentCharactersListTurn();
            if (controller.didILose() || controller.didIWin()) {
                changePhase(new EndBattlePhase());
            } else {
                controller.nextTurn();
                changePhase(new WaitChoicePhase());
            }
        } else {
            throw new InvalidTransitionException("This transition is not allowed.");
        }

    }
}
