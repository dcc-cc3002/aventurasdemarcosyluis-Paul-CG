package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidChoiceException;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTransitionException;

import java.util.Objects;
import java.util.Scanner;

/**
 * This phase allows the player to pick between the attack types of the Heroes.
 */
public class WaitAttackPhase extends Phase{
    /**
     * The constructor only uses a Scanner to take the users input. It allows transitions to WaitChoice and Attack phases.
     */
    public WaitAttackPhase(){
        this.toLoad = false;
        this.toBattleStart = false;
        this.toWaitChoice = true;
        this.toWaitAttack = false;
        this.toWaitItem = false;
        this.toAttack = true;
        this.toItem = false;
        this.toEnemyAttack = false;
        this.toEndTurn = false;
        this.toEndBattle = false;
        this.toEndGame = false;
        reader = new Scanner(System.in);
    }

    @Override
    public String toString(){
        return "Wait Attack Phase";
    }

    @Override
    public void toNextPhase() throws InvalidTransitionException, InvalidChoiceException {
        String choice = "0";

        if(toWaitChoice && toAttack &&
                !(toLoad && toBattleStart && toWaitAttack && toWaitItem && toItem && toEnemyAttack && toEndTurn && toEndBattle && toEndGame)){
            while(!Objects.equals(choice, "1") && !Objects.equals(choice, "2") && !Objects.equals(choice, "3")){
                System.out.println("Choose an attack to destroy your enemies!!");
                System.out.println("1- Jump   - 1 FP");
                System.out.println("2- Hammer - 2 FP");
                System.out.println("3- Back");
                System.out.println("(Pick a number)");
                choice = reader.nextLine();

                if (Objects.equals(choice, "1")){
                    changePhase(new AttackPhase(1));
                } else if (Objects.equals(choice, "2")){
                    changePhase(new AttackPhase(2));
                } else if (Objects.equals(choice, "3")){
                    controller.decreaseActiveCharacterIndex();
                    changePhase(new WaitChoicePhase());
                } else {
                    throw new InvalidChoiceException("Please choose a valid option");
                }
            }
        }else{
            throw new InvalidTransitionException("This transition is not allowed.");
        }

    }
}
