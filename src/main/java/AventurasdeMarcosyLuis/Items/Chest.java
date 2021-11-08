package AventurasdeMarcosyLuis.Items;

import AventurasdeMarcosyLuis.Characters.Playable;

import java.util.HashMap;

/**
 * Class Chest that stores all the Items that the Players share.
 *
 *  @author Paul Chauveau Gerber
 *  @version 1.0
 *  @since 2021-10-12
 */
public class Chest {
    private final HashMap<Consumable,Integer> inventory;

    /**
     * Construct of the class Chest, it initializes the HashMap
     */
    public Chest(){
        inventory = new HashMap<>();
    }

    /**
     * Returns the full inventory.
     * @return inventory
     */
    public HashMap<Consumable, Integer> getItems(){
        return inventory;
    }

    /**
     * Adds one unit of an Item (param) to the Chest.
     * @param item Object of the class Item
     */
    public void addItem(Consumable item){
        inventory.merge(item, 1, Integer::sum);
    }

    /**
     * Checks if the Chest has an item in his inventory.
     * @param item Object of the class Item
     * @return True if inventory has the item or false if not
     */
    public boolean hasItem(Consumable item){
        return inventory.get(item) != null;
    }

    /**
     * Removes one unit of an item from the Chest.
     * @param item Object of the class Item
     */
    public void removeItem(Consumable item){
        if (this.hasItem(item)){
            if (inventory.get(item) > 1) inventory.merge(item, -1, Integer::sum);
            else inventory.remove(item);
        }
    }

    /**
     * Activates an item and consumes it (calling removeItem).
     * @param player Player that uses the item
     * @param item Object of the class Item
     */
    public void useItem(Playable player, Consumable item){
        if (this.hasItem(item)) {
            item.activate(player);
            this.removeItem(item);
        }
    }

    /**
     * This method returns the quantity of items the chest has left of a certain type
     * @param item item to check
     * @return int representing the number of items left
     */
    public int howManyItems(Consumable item){
        if (inventory.get(item) == null) return 0;
        return inventory.get(item);
    }
}
