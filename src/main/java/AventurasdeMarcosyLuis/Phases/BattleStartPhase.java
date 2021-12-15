package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTransitionException;

/**
 * This phase creates enemies at the beginning of each Battle
 */
public class BattleStartPhase extends Phase{
    /**
     * The constructor only allows a transition to the WaitChoicePhase
     */
    public BattleStartPhase() {
        this.toLoad = false;
        this.toBattleStart = false;
        this.toWaitChoice = true;
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
        return "Battle Start Phase";
    }

    @Override
    public void toNextPhase() throws InvalidTransitionException {
        if(toWaitChoice &&
                !(toLoad && toBattleStart && toWaitAttack && toWaitItem && toAttack && toItem && toEnemyAttack && toEndTurn && toEndBattle && toEndGame)){
            int numberOfEnemies = 1;
            switch (controller.getNumberOfBattles()) {
                case 1, 2 -> numberOfEnemies = 3;
                case 3, 4 -> numberOfEnemies = 5;
                case 5 -> numberOfEnemies = 6;
            }
            controller.setTurn(0);
            controller.initializeEnemies(numberOfEnemies);
            controller.formCurrentCharactersListBattle();
            System.out.println("------------------------------------------------------------");
            System.out.println("------------------A New Battle has begun!!------------------");
            System.out.println("------------------------------------------------------------");
            System.out.println("New enemies have arrived!!!");
            changePhase(new WaitChoicePhase());
        } else {throw new InvalidTransitionException("This transition is not allowed.");

        }
    }
}
