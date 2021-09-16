package com.example.aventurasdemarcoyluis;

/**
 * Creates an abstract Enemy, it fixes the K value for all enemies
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public abstract class Enemies extends Character{
    private double K;

    /**
     * Creates a new Enemy
     *
     */
    public Enemies(int LVL, int ATK, int DEF, int HPMax, int FPMax){
        super(LVL, ATK, DEF, HPMax, FPMax);
        K = 0.75;
    }


}
