package com.example.aventurasdemarcoyluis;

/**
 * Creates template with shared data of all types of characters in the game.
 * It handles all the stats (set, get, add) for all characters, also ir checks
 * if a character is KO.
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public abstract class Character {
    private int LVL;
    private int ATK;
    private int DEF;
    private int HPMax;
    private int HP;
    private int FPMax;
    private int FP;


    /**
     * Constructor of the class Character
     *
     * @param LVL Level
     * @param ATK Attack
     * @param DEF Defense
     * @param HPMax Maximum HP
     * @param FPMax Maximum FP
     */
    public Character(int LVL, int ATK, int DEF, int HPMax, int FPMax){
        super();
        this.LVL = LVL;
        this.ATK = ATK;
        this.DEF = DEF;
        this.HPMax = HPMax;
        this.HP = HPMax;
        this.FPMax = FPMax;
        this.FP = FPMax;
    }

    /**
     * Gets the LVL of a Character
     * @return LVL
     */
    public int getLVL() {
        return LVL;
    }

    /**
     * Sets the LVL of a Character
     */
    public void setLVL(int LVL) {
        this.LVL = LVL;
    }

    /**
     * Gets the ATK of a Character
     * @return ATK
     */
    public int getATK() {
        return this.ATK;
    }

    /**
     * Sets the ATK of a Character
     */
    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    /**
     * Gets the DEF of a Character.
     * @return DEF
     */
    public int getDEF() {
        return DEF;
    }

    /**
     * Sets the DEF of a Character.
     */
    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    /**
     * Gets the HPMax of a Character.
     * @return HPMax
     */
    public int getHPMax() {
        return HPMax;
    }

    /**
     * Sets the HPMax of a Character.
     */
    public void setHPMax(int HPMax) {
        this.HPMax = HPMax;
    }

    /**
     * Gets the HP of a Character.
     * @return HP
     */
    public int getHP() {
        return HP;
    }

    /**
     * Sets the HP of a Character. It can't be below 0 or over HPMax.
     */
    public void setHP(int HP) {
        this.HP = HP;
        if (this.HP > this.HPMax) this.HP = this.HPMax;
        if (this.HP < 0) this.HP = 0;
    }

    /**
     * Adds an amount (positive or negative) of HP to the actual HP of a Character.
     * The result can't be below 0 or over HPMax.
     */
    public void addHP(int HP) {
        this.HP += HP;
        if (this.HP > this.HPMax) this.HP = this.HPMax;
        if (this.HP < 0) this.HP = 0;
    }

    /**
     * Gets the FPMax of a Character.
     * @return FPMax
     */
    public int getFPMax() {
        return FPMax;
    }

    /**
     * Sets the FPMax of a Character.
     */
    public void setFPMax(int FPMax) {
        this.FPMax = FPMax;
    }

    /**
     * Gets the FP of a Character.
     * @return FP
     */
    public int getFP() {
        return FP;
    }

    /**
     * Sets the FP of a Character. It can't be below 0 or over FPMax.
     */
    public void setFP(int FP) {
        this.FP = FP;
        if (this.FP > this.FPMax) this.FP = this.FPMax;
        if (this.FP < 0) this.FP = 0;
    }

    /**
     * Adds an amount (positive or negative) of FP to the actual FP of a Character.
     * The result can't be below 0 or over FPMax.
     */
    public void addFP(int FP) {
        this.FP += FP;
        if (this.FP > this.FPMax) this.FP = this.FPMax;
        if (this.FP < 0) this.FP = 0;
    }

    /**
     * Checks if the current HP of a character is 0 (and, thus, if it's out of combat or not).
     * @return true if KO and false if not
     */
    public boolean isKO(){
        return this.getHP() == 0;
    }


}
