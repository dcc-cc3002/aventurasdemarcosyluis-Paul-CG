package AventurasdeMarcosyLuis.Phases;

/**
 * This phase end the current battle and starts the next one, or finishes the game
 */
public class EndBattlePhase extends Phase{

    @Override
    public String toString(){
        return "End Battle Phase";
    }

    @Override
    public void toNextPhase() {
        if (controller.didILose()) {
            System.out.println("Marcos and Luis have fainted.");
            changePhase(new EndGamePhase(false));
        } else if (controller.didIWin()){
            System.out.println("You won this Battle! Well done! :D");
            controller.endBattle();
            controller.nextBattle();
            if (controller.getNumberOfBattles() > 5) {
                changePhase(new EndGamePhase(true));
            } else {
                changePhase(new BattleStartPhase());
            }
        }

    }
}
