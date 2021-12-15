package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTransitionException;

/**
 * This is the initial Phase of the game, it loads the players and item before going to the battle.
 */
public class LoadPhase extends Phase{
    /**
     * Everything is set to false, there are no choices or actions a player can make in this phase.
     */
    public LoadPhase() {
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
        this.toEndGame = false;
    }

    @Override
    public String toString(){
        return "Load Phase";
    }

    @Override
    public void toNextPhase() throws InvalidTransitionException {
        if(toBattleStart &&
                !(toLoad && toWaitChoice && toWaitAttack && toWaitItem && toAttack && toItem && toEnemyAttack && toEndTurn && toEndBattle && toEndGame)){
            controller.loadGame();
            System.out.println("Loading....");
            changePhase(new BattleStartPhase());
            System.out.println("The battleground is ready, brace yourself!");
        }else{
            throw new InvalidTransitionException("This transition is not allowed.");
        }
    }
}
