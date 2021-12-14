package AventurasdeMarcosyLuis.Phases;

/**
 * This is the initial Phase of the game, it loads the players and item before going to the battle.
 */
public class LoadPhase extends Phase{
    /**
     * Everything is set to false, there are no choices or actions a player can make in this phase.
     */
    public LoadPhase(){
        this.canIStart = false;
        this.canIAttack = false;
        this.canIUseItem = false;
        this.canIPass = false;
        this.canISelectEnemy = false;
        this.canISelectItem = false;
        this.isEnemyTurn = false;
        this.invalidTarget = false;
    }

    @Override
    public String toString(){
        return "Load Phase";
    }

    @Override
    public void toNextPhase(){
        controller.loadGame();
        System.out.println("Loading....");
        changePhase(new BattleStartPhase());
        System.out.println("The battleground is ready, brace yourself!");
    }
}
