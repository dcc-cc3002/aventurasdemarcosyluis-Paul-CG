package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Characters.Playable;
import AventurasdeMarcosyLuis.Items.Consumable;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidChoiceException;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTransitionException;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * On this phase, the user chooses one of the players to apply the item he has
 */
public class ItemPhase extends Phase{
    int heroIndex;
    /**
     * The constructor uses a Scanner to take the users input, and the heroIndex from the previous phase. It allows
     * transitions to WaitItem and EndTurn phases.
     */
    public ItemPhase(int heroIndex){
        this.toLoad = false;
        this.toBattleStart = false;
        this.toWaitChoice = false;
        this.toWaitAttack = false;
        this.toWaitItem = true;
        this.toAttack = false;
        this.toItem = false;
        this.toEnemyAttack = false;
        this.toEndTurn = true;
        this.toEndBattle = false;
        this.toEndGame = false;

        reader = new Scanner(System.in);
        this.heroIndex = heroIndex;
    }

    @Override
    public String toString(){
        return "Item Phase";
    }

    @Override
    public void toNextPhase() throws InvalidTransitionException, InvalidChoiceException {
        LinkedList<Consumable> items =  controller.getListItems();
        Consumable option = null;
        Playable player = controller.getPlayers().get(heroIndex);
        String choice;

        if(toEndTurn && toWaitItem &&
                !(toLoad && toBattleStart && toWaitAttack && toWaitChoice && toAttack && toItem && toEnemyAttack && toEndBattle && toEndGame)){

            while(!controller.choiceIsItem(option)){
                int itemIndex = 1;
                for (Consumable item : items){
                    System.out.println(itemIndex + "- " + item + " : " + controller.getHowManyItems(item));
                    itemIndex += 1;
                }
                System.out.println(itemIndex + "- Back");
                System.out.println("(Pick a number)");
                choice = reader.nextLine();

                try {
                    if(Integer.parseInt(choice) == itemIndex) {
                        changePhase(new WaitItemPhase());
                        break;
                    }
                    option = items.get(Integer.parseInt(choice)-1);
                } catch (NumberFormatException e){
                    throw new InvalidChoiceException("Please choose a valid option");
                }

                if (controller.choiceIsItem(option)) {
                    controller.useItem(player, option);
                    changePhase(new EndTurnPhase());
                } else {
                    throw new InvalidChoiceException("Please choose a valid option");
                }
            }
        }else{
            throw new InvalidTransitionException("This transition is not allowed.");
        }

    }
}
