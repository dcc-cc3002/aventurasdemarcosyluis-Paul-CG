package AventurasdeMarcosyLuis.Phases;

import AventurasdeMarcosyLuis.Characters.Playable;
import AventurasdeMarcosyLuis.Items.Consumable;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * On this phase, the user chooses one of the players to apply the item he has
 */
public class ItemPhase extends Phase{
    int heroIndex;
    /**
     * The constructor uses a Scanner to take the users input, and the heroIndex from the previous phase
     */
    public ItemPhase(int heroIndex){
        reader = new Scanner(System.in);
        this.heroIndex = heroIndex;
    }

    @Override
    public String toString(){
        return "Item Phase";
    }

    @Override
    public void toNextPhase() {
        LinkedList<Consumable> items =  controller.getListItems();
        Consumable option = null;
        Playable player = controller.getPlayers().get(heroIndex);
        String choice;

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
                System.out.println("Please choose a valid option.");
                continue;
            }

            if (controller.choiceIsItem(option)) {
                controller.useItem(player, option);
                changePhase(new EndTurnPhase());
            } else {
                System.out.println("Please choose a valid option.");
            }

        }
    }
}
