package AventurasdeMarcosyLuis.Characters;

import java.util.Objects;
import java.lang.Math;

/**
 * Creates template with shared data of all types of characters in the game.
 * It handles all the stats (set, get, add) for all characters, also ir checks
 * if a character is KO.
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public abstract class AbstractCharacter implements Playable{
    private int LVL;
    private int ATK;
    private int DEF;
    private int HPMax;
    private int HP;
    private int FPMax;
    private int FP;
    private double K;
    private double lvlUpFactor;


    /**
     * Constructor of the class Character
     *
     * @param LVL Level
     * @param ATK Attack
     * @param DEF Defense
     * @param HPMax Maximum HP
     * @param FPMax Maximum FP
     */
    public AbstractCharacter(int LVL, int ATK, int DEF, int HPMax, int FPMax){
        super();
        this.LVL = LVL;
        this.ATK = ATK;
        this.DEF = DEF;
        this.HPMax = HPMax;
        this.HP = HPMax;
        this.FPMax = FPMax;
        this.FP = FPMax;
        this.K = 0.75;
        lvlUpFactor = 1.15;
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
     * Retrives the value of the K variable
     */
    public double getK(){
        return K;
    }


    /**
     * Checks if the current HP of a character is 0 (and, thus, if it's out of combat or not).
     * @return true if KO and false if not
     */
    public boolean isKO(){
        return this.getHP() == 0;
    }

    /**
     * Calculates the damage dealt by a character, if the attacker is KO, this damage is 0.
     * @param K constant relative to a character and attack type
     * @param attacker character that performs this action
     * @param defender character that receives this action
     */
    public int damage(double K, Playable attacker, Playable defender){
        int dmg = 0;
        if (!attacker.isKO()) dmg = (int) Math.floor(K*attacker.getATK()*attacker.getLVL()/defender.getDEF());
        return -dmg;
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

    /**
     * Automatic implementation of equals to test the construction of objects.
     *
     * @param o object to compare to
     * @return true if both objects are the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCharacter that = (AbstractCharacter) o;
        return LVL == that.LVL && ATK == that.ATK && DEF == that.DEF && HPMax == that.HPMax && HP == that.HP && FPMax == that.FPMax && FP == that.FP && K == that.K;
    }

    /**
     * Automatic implementation of hashCode to find a unique object.
     *
     * @return returns an int that identifies the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(LVL, ATK, DEF, HPMax, HP, FPMax, FP, K);
    }

}
