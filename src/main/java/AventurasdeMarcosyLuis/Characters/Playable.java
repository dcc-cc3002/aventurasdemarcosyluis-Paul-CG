package AventurasdeMarcosyLuis.Characters;

/**
 * This Playable interface shares all basics methods that all Characters need.
 */
public interface Playable {

    /**
     * Get the current level of a Character
     * @return
     */
    int getLVL();

    /**
     * Sets the LVL of a Character
     */
    void setLVL(int LVL);

    /**
     * Gets the ATK of a Character
     * @return ATK
     */
    int getATK();

    /**
     * Sets the ATK of a Character
     */
    void setATK(int ATK);

    /**
     * Gets the DEF of a Character.
     * @return DEF
     */
    int getDEF();

    /**
     * Sets the DEF of a Character.
     */
    void setDEF(int DEF);

    /**
     * Gets the HPMax of a Character.
     * @return HPMax
     */
    int getHPMax();

    /**
     * Sets the HPMax of a Character.
     */
    void setHPMax(int HPMax);

    /**
     * Gets the HP of a Character.
     * @return HP
     */
    int getHP();

    /**
     * Sets the HP of a Character. It can't be below 0 or over HPMax.
     */
    void setHP(int HP);

    /**
     * Adds an amount (positive or negative) of HP to the actual HP of a Character.
     * The result can't be below 0 or over HPMax.
     */
    void addHP(int HP);

    /**
     * Gets the FPMax of a Character.
     * @return FPMax
     */
    int getFPMax();

    /**
     * Sets the FPMax of a Character.
     */
    void setFPMax(int FPMax);

    /**
     * Gets the FP of a Character.
     * @return FP
     */
    int getFP();

    /**
     * Sets the FP of a Character. It can't be below 0 or over FPMax.
     */
    void setFP(int FP);

    /**
     * Adds an amount (positive or negative) of FP to the actual FP of a Character.
     * The result can't be below 0 or over FPMax.
     */
    void addFP(int FP);

    /**
     * Retrieves the value of the K variable
     */
    double getK();

    /**
     * Retrieves the value of the KHammer variable
     */
    double getKHammer();

    /**
     * Retrieves the value of the KJump variable
     */
    double getKJump();

    /**
     * Checks if the current HP of a character is 0 (and, thus, if it's out of combat or not).
     * @return true if KO and false if not
     */
    boolean isKO();

    /**
     * lvlUP increments the stats HPMax, FPMax, ATK and DEF by 15%, LVL by 1. HP and FP are incremented by the same
     * amount HPMax and FPMax respectively.
     */
    void lvlUp();

    /**
     * toString returns the name (or type) of a Character
     */
    String toString();
}
