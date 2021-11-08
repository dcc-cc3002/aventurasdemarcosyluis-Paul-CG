package AventurasdeMarcosyLuis.Factories;

import AventurasdeMarcosyLuis.Characters.Enemies.Boo;
import AventurasdeMarcosyLuis.Characters.Enemies.Goomba;
import AventurasdeMarcosyLuis.Characters.Enemies.Spiny;
import AventurasdeMarcosyLuis.Characters.Playable;

/**
 * This Class creates enemies random with preset attributes. It is used in the controller to
 * populate the battles.
 */
public class WickedFactory {

    private int LVL;
    private int ATK;
    private int DEF;
    private int HPMax;
    private final int FPMax;

    /**
     * This is the constructor of the Factory. It receives the base parameters to create enemies, which can
     * be modified using the set methods.
     * @param LVL level of the enemies
     * @param ATK attack of the enemies
     * @param DEF defense of the enemies
     * @param HPMax Max HP of the enemies
     */
    public WickedFactory(int LVL, int ATK, int DEF, int HPMax){
        this.LVL = LVL;
        this.ATK = ATK;
        this.DEF = DEF;
        this.HPMax = HPMax;
        this.FPMax = 0;
    }

    /**
     * This set method changes the preset value of ATK to create enemies. It is used to manage the
     * difficulty of a given stage.
     * @param ATK attack
     */
    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    /**
     * This set method changes the preset value of DEF to create enemies. It is used to manage the
     * difficulty of a given stage.
     * @param DEF defense
     */
    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    /**
     * This set method changes the preset value of HPMax to create enemies. It is used to manage the
     * difficulty of a given stage.
     * @param HPMax Max HP
     */
    public void setHPMax(int HPMax) {
        this.HPMax = HPMax;
    }

    /**
     * This set method changes the preset value of LVL to create enemies. It is used to manage the
     * difficulty of a given stage.
     * @param LVL level
     */
    public void setLVL(int LVL) {
        this.LVL = LVL;
    }

    /**
     * Create, created a random enemy.
     * @return a random enemy
     */
    public Playable create() {
        double randomNumber = Math.random();
        if (randomNumber < 0.6) {
            return new Goomba(LVL, ATK, DEF, HPMax, FPMax);
        } else if (randomNumber < 0.99) {
            return new Spiny(LVL, ATK, DEF, HPMax, FPMax);
        } else {
            return new Boo(LVL, ATK, DEF, HPMax, FPMax);
        }
    }
}
