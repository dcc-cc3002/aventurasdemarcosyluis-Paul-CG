package AventurasdeMarcosyLuis.Phases;

/**
 * This phase creates enemies at the beginning of each Battle
 */
public class BattleStartPhase extends Phase{

    @Override
    public String toString(){
        return "Battle Start Phase";
    }

    @Override
    public void toNextPhase(){
        int numberOfEnemies = 1;
        switch (controller.getNumberOfBattles()) {
            case 1, 2 -> numberOfEnemies = 3;
            case 3, 4 -> numberOfEnemies = 5;
            case 5 -> numberOfEnemies = 6;
        }
        controller.setTurn(0);
        controller.initializeEnemies(numberOfEnemies);
        controller.formCurrentCharactersListBattle();
        System.out.println("New enemies have arrived!!!");
        changePhase(new WaitChoicePhase());
    }
}
