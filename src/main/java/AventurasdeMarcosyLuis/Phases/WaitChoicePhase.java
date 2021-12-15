package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidChoiceException;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTransitionException;

import java.util.Objects;
import java.util.Scanner;

/**
 * This phase either takes an input to choose between attack, use item or follows with an enemy attack. It depends on
 * the currentCharacter
 */
public class WaitChoicePhase extends Phase{
    /**
     * The constructor initializes a Scanner object to take inputs from users. Also, it allows transitions to WaitAttack
     * WaitItem, EndTurn and EnemyAttack phases.
     */
    public WaitChoicePhase(){
        this.toLoad = false;
        this.toBattleStart = false;
        this.toWaitChoice = false;
        this.toWaitAttack = true;
        this.toWaitItem = true;
        this.toAttack = false;
        this.toItem = false;
        this.toEnemyAttack = true;
        this.toEndTurn = true;
        this.toEndBattle = false;
        this.toEndGame = false;

        reader = new Scanner(System.in);
    }

    @Override
    public String toString(){
        return "Wait Choice Phase";
    }

    @Override
    public void toNextPhase() throws InvalidTransitionException, InvalidChoiceException {
        String choice = "0";

        if(toWaitAttack && toWaitItem && toEnemyAttack && toEndTurn &&
                !(toLoad && toBattleStart && toWaitChoice && toAttack && toItem && toEndBattle && toEndGame)){
            controller.getNextCharacter();

            System.out.println("Current Characters on the Battlefield:");
            System.out.println(controller.getCurrentCharacters());

            System.out.println("------------------------------------------------------------");
            System.out.println("Battle # "+ controller.getNumberOfBattles() + " Turn # " + controller.getTurn());

            if (controller.currentCharacterIsHero()) {
                while(!Objects.equals(choice, "1") && !Objects.equals(choice, "2") && !Objects.equals(choice, "3")) {
                    System.out.println("What should " + controller.getCurrentCharacter().toString() + " do?");
                    System.out.println("1- Attack");
                    System.out.println("2- Use Item");
                    System.out.println("3- Pass");
                    System.out.println("(Pick a number)");
                    choice = reader.nextLine();

                    if (Objects.equals(choice, "1")){
                        changePhase(new WaitAttackPhase());
                    } else if (Objects.equals(choice, "2")){
                        changePhase(new WaitItemPhase());
                    } else if (Objects.equals(choice, "3")){
                        changePhase(new EndTurnPhase());
                    } else {
                        throw new InvalidChoiceException("Please choose a valid option");
                    }
                }
            } else {
                changePhase(new EnemyAttackPhase());
            }
        }else{
            throw new InvalidTransitionException("This transition is not allowed.");
        }
    }
}
