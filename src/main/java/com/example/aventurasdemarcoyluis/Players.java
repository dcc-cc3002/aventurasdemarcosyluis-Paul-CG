package com.example.aventurasdemarcoyluis;

import java.util.HashMap;

/**
 * PLayers Extends Character, it represents the main characters of the game.
 * This class implements all the methods to use Items, which corresponds only
 * to the main characters.
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public abstract class Players extends Character {
    private HashMap<Items,Integer> inventory;
    private double K_jump;
    private double K_hammer;

    /**
     * Constructor of the class, it defines two types of K (hammer and jump)
     * and a HashMap inventory which stores all the item this player has.
     * This inventory keeps count on which item the PLayer has and also, how
     * many of these items it has stored.
     *
     */
    public Players(int LVL, int ATK, int DEF, int HPMax, int FPMax) {
        super(LVL, ATK, DEF, HPMax, FPMax);
        inventory = new HashMap<Items, Integer>();
        K_hammer = 1.5;
        K_jump = 1;
    }

    /**
     * Allows a player to add an Item (param) to their inventory.
     *
     * @param item Object of the class Item
     */
    public void addItem(Items item){
        inventory.merge(item, 1, Integer::sum);
    }

    /**
     * Removes an item from the players inventory.
     * @param item Object of the class Item
     */
    public void removeItem(Items item){

    }

    /**
     * Checks if the players has an item in his inventory.
     * @param item Object of the class Item
     * @return True if inventory has the item or false if not
     */
    public boolean hasItem(Items item){
        return inventory.get(item) != null;
    }

    /**
     * Activates an item and consume ir (calling removeItem).
     * @param item Object of the class Item
     * @return True if the item was successfully used, false if not.
     */
    public boolean useItem(Items item){
        return true;
    }
}








