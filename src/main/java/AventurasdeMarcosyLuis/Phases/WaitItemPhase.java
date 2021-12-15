package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Characters.Playable;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidChoiceException;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTransitionException;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * In this phase the player picks a hero on which apply an item
 */
public class WaitItemPhase extends Phase{
    /**
     * The constructor only needs a Scanner object to take the user preference. Also, it allows transitions to WaitChoice
     * and Item phases.
     */
    public WaitItemPhase(){
        this.toLoad = false;
        this.toBattleStart = false;
        this.toWaitChoice = true;
        this.toWaitAttack = false;
        this.toWaitItem = false;
        this.toAttack = false;
        this.toItem = true;
        this.toEnemyAttack = false;
        this.toEndTurn = false;
        this.toEndBattle = false;
        this.toEndGame = false;

        reader = new Scanner(System.in);
    }

    @Override
    public String toString(){
        return "Wait Item Phase";
    }

    @Override
    public void toNextPhase() throws InvalidTransitionException, InvalidChoiceException {
        LinkedList<Playable> heroes = controller.getPlayers();
        Playable target = null;
        String choice;
        // We check for the conditions to complete the transition
        if(toWaitChoice && toItem &&
                !(toLoad && toBattleStart && toWaitAttack && toWaitItem && toAttack && toEnemyAttack && toEndTurn && toEndBattle && toEndGame)){

            // We choose a hero as a target and move to the Item Phase (or back)
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
                    throw new InvalidChoiceException("Please choose a valid option");
                }

                if (controller.choiceIsHero(target)) {
                    changePhase(new ItemPhase(Integer.parseInt(choice)-1));
                } else {
                    throw new InvalidChoiceException("Please choose a valid option");
                }
            }
        }else{
            throw new InvalidTransitionException("This transition is not allowed.");
        }
    }
}
