package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTransitionException;

/**
 * This phase end the current battle and starts the next one, or finishes the game
 */
public class EndBattlePhase extends Phase{

    /**
     * The constructor only allows transitions to BattleStart and EndGame phases.
     */
    public EndBattlePhase(){
        this.toLoad = false;
        this.toBattleStart = true;
        this.toWaitChoice = false;
        this.toWaitAttack = false;
        this.toWaitItem = false;
        this.toAttack = false;
        this.toItem = false;
        this.toEnemyAttack = false;
        this.toEndTurn = false;
        this.toEndBattle = false;
        this.toEndGame = true;
    }

    @Override
    public String toString(){
        return "End Battle Phase";
    }

    @Override
    public void toNextPhase() throws InvalidTransitionException {

        // We check for the conditions to complete the transition
        if(toEndGame && toBattleStart &&
                !(toLoad && toEndTurn && toWaitAttack && toWaitItem && toAttack && toItem && toEnemyAttack && toWaitChoice && toEndBattle)){

            // If the heroes lost the last battle, we transition to the EndGame phase
            if (controller.didILose()) {
                System.out.println("Marcos and Luis have fainted.");
                changePhase(new EndGamePhase(false));
            } else if (controller.didIWin()){ // If they won, we check if it is the last battle and move to the correct phase
                System.out.println("You won this Battle! Well done! :D");
                controller.endBattle();
                controller.nextBattle();
                if (controller.getNumberOfBattles() > 5) {
                    changePhase(new EndGamePhase(true));
                } else {
                    changePhase(new BattleStartPhase());
                }
            }
        } else {
            throw new InvalidTransitionException("This transition is not allowed.");
        }
    }
}
