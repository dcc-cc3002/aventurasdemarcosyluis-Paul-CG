package AventurasdeMarcosyLuis.Phases;

/**
 * This Phase end the turn updating all needed variables
 */
public class EndTurnPhase extends Phase{

    @Override
    public String toString(){
        return "End Turn Phase";
    }

    @Override
    public void toNextPhase() {
        controller.removeDead();
        controller.formCurrentCharactersListTurn();
        if (controller.didILose() || controller.didIWin()) {
            changePhase(new EndBattlePhase());
        } else {
            controller.nextTurn();
            changePhase(new WaitChoicePhase());
        }
    }
}
