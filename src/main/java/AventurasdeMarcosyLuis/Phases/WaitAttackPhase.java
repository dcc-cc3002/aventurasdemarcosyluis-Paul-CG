package AventurasdeMarcosyLuis.Phases;

import java.util.Objects;
import java.util.Scanner;

/**
 * This phase allows the player to pick between the attack types of the Heroes.
 */
public class WaitAttackPhase extends Phase{
    /**
     * The constructor only uses a Scanner to take the users input
     */
    public WaitAttackPhase(){
        reader = new Scanner(System.in);
    }

    @Override
    public String toString(){
        return "Wait Attack Phase";
    }

    @Override
    public void toNextPhase(){
        String choice = "0";
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
                System.out.println("Please choose a valid option.");
            }
        }
    }
}
