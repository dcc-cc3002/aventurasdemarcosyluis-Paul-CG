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
public abstract class AbstractPlayers extends AbstractCharacter {
    private HashMap<Consumable,Integer> inventory;
    private double KJump;
    private double KHammer;
    private double lvlUpFactor;

    /**
     * Constructor of the class, it defines two types of K (hammer and jump)
     * and a HashMap inventory which stores all the item this player has.
     * This inventory keeps count on which item the Player has and also, how
     * many of these items it has stored.
     *
     */
    public AbstractPlayers(int LVL, int ATK, int DEF, int HPMax, int FPMax) {
        super(LVL, ATK, DEF, HPMax, FPMax);
        inventory = new HashMap<Consumable, Integer>();
        KHammer = 1.5;
        KJump = 1;
        lvlUpFactor = 1.15;
    }

    /**
     * Allows a player to add one unit of an Item (param) to their inventory.
     *
     * @param item Object of the class Item
     */
    public void addItem(Consumable item){
        inventory.merge(item, 1, Integer::sum);
    }

    /**
     * Removes one unit of an item from the players inventory.
     * @param item Object of the class Item
     */
    public void removeItem(Consumable item){
        if (this.hasItem(item)){
            if (inventory.get(item) > 1) inventory.merge(item, -1, Integer::sum);
            else inventory.remove(item);
        }
    }

    /**
     * Checks if the players has an item in his inventory.
     * @param item Object of the class Item
     * @return True if inventory has the item or false if not
     */
    public boolean hasItem(Consumable item){
        return inventory.get(item) != null;
    }

    /**
     * Activates an item and consumes it (calling removeItem).
     * @param item Object of the class Item
     */
    public void useItem(Consumable item){
        if (this.hasItem(item)) {
            item.activate(this);
            this.removeItem(item);
        }
    }

    /**
     * lvlUP increments the stats HPMax, FPMax, ATK and DEF by 15%, LVL by 1. HP and FP are incremented by the same
     * amount HPMax and FPMax respectively.
     */
    public void lvlUp(){
        int HP = (int) ((lvlUpFactor-1)*this.getHPMax());
        int FP = (int) ((lvlUpFactor-1)*this.getFPMax());

        this.setLVL(this.getLVL()+1);
        this.setHPMax(this.getHPMax() + HP);
        this.setFPMax(this.getFPMax() + FP);
        this.setHP(this.getHP() + HP);
        this.setFP(this.getFP() + FP);
        this.setATK((int) (lvlUpFactor*this.getATK()));
        this.setDEF((int) (lvlUpFactor*this.getDEF()));
    }

    @Override
    public double getKHammer(){
        return KHammer;
    }

    @Override
    public double getKJump(){
        return KJump;
    }
}








