package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Characters.Playable;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * In this phase the player picks a hero on which apply an item
 */
public class WaitItemPhase extends Phase{
    /**
     * The constructor only needs a Scanner object to take the users preference
     */
    public WaitItemPhase(){
        reader = new Scanner(System.in);
    }

    @Override
    public String toString(){
        return "Wait Item Phase";
    }

    @Override
    public void toNextPhase(){
        LinkedList<Playable> heroes = controller.getPlayers();
        Playable target = null;
        String choice;

        while(!controller.choiceIsHero(target)) {
            int heroIndex = 1;
            System.out.println("On which hero would you like to use an item?");
            System.out.println("");
            for(Playable hero : heroes) {
                System.out.println(heroIndex + "- " + hero.toString());
                System.out.println("--- HP: " + hero.getHP() + "/" + hero.getHPMax());
                System.out.println("--- FP: " + hero.getFP() + "/" + hero.getFPMax());
                System.out.println("");
                heroIndex += 1;
            }
            System.out.println(heroIndex + "- Back");
            System.out.println("(Pick a number)");
            choice = reader.nextLine();

            try {
                if(Integer.parseInt(choice) == heroIndex) {
                    controller.decreaseActiveCharacterIndex();
                    changePhase(new WaitChoicePhase());
                    break;
                }
                target = heroes.get(Integer.parseInt(choice)-1);
            } catch (NumberFormatException e){
                System.out.println("Please choose a valid option.");
                continue;
            }

            if (controller.choiceIsHero(target)) {
                changePhase(new ItemPhase(Integer.parseInt(choice)-1));
            } else {
                System.out.println("Please choose a valid option.");
            }
        }

    }
}
