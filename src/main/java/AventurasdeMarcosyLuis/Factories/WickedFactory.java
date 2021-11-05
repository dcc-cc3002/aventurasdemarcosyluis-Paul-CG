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
    private int FPMax;

    /**
     * This is the constructor of the Factory. It receives the base parameters to create enemies, which can
     * be modified using the set methods.
     * @param LVL
     * @param ATK
     * @param DEF
     * @param HPMax
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
     * @param ATK
     */
    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    /**
     * This set method changes the preset value of DEF to create enemies. It is used to manage the
     * difficulty of a given stage.
     * @param DEF
     */
    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    /**
     * This set method changes the preset value of HPMax to create enemies. It is used to manage the
     * difficulty of a given stage.
     * @param HPMax
     */
    public void setHPMax(int HPMax) {
        this.HPMax = HPMax;
    }

    /**
     * This set method changes the preset value of LVL to create enemies. It is used to manage the
     * difficulty of a given stage.
     * @param LVL
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
        if (randomNumber < 0.4) {
            return new Goomba(LVL, ATK, DEF, HPMax, FPMax);
        } else if (randomNumber < 0.7) {
            return new Spiny(LVL, ATK, DEF, HPMax, FPMax);
        } else {
            return new Boo(LVL, ATK, DEF, HPMax, FPMax);
        }
    }
}
