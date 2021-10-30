package AventurasdeMarcosyLuis.Characters;


/**
 * This Playable interface shares all basics methods that all AventurasdeMarcosyLuis.AventurasdeMarcosyLuis.AventurasdeMarcosyLuis.Items.Items.Characters need.
 */
public interface Playable {

    default int getLVL() {
        return 0;
    }

    /**
     * Sets the LVL of a Character
     */
    default void setLVL(int LVL) {}

    /**
     * Gets the ATK of a Character
     * @return ATK
     */
    default int getATK() {
        return 0;
    }

    /**
     * Sets the ATK of a Character
     */
    default void setATK(int ATK) {

    }

    /**
     * Gets the DEF of a Character.
     * @return DEF
     */
    default int getDEF() {
        return 0;
    }

    /**
     * Sets the DEF of a Character.
     */
    default void setDEF(int DEF) {

    }

    /**
     * Gets the HPMax of a Character.
     * @return HPMax
     */
    default int getHPMax() {
        return 0;
    }

    /**
     * Sets the HPMax of a Character.
     */
    default void setHPMax(int HPMax) { }

    /**
     * Gets the HP of a Character.
     * @return HP
     */
    default int getHP() {
        return 0;
    }

    /**
     * Sets the HP of a Character. It can't be below 0 or over HPMax.
     */
    default void setHP(int HP) {    }

    /**
     * Adds an amount (positive or negative) of HP to the actual HP of a Character.
     * The result can't be below 0 or over HPMax.
     */
    default void addHP(int HP) {    }

    /**
     * Gets the FPMax of a Character.
     * @return FPMax
     */
    default int getFPMax() {
        return 0;
    }

    /**
     * Sets the FPMax of a Character.
     */
    default void setFPMax(int FPMax) {  }

    /**
     * Gets the FP of a Character.
     * @return FP
     */
    default int getFP() {
        return 0;
    }

    /**
     * Sets the FP of a Character. It can't be below 0 or over FPMax.
     */
    default void setFP(int FP) {    }

    /**
     * Adds an amount (positive or negative) of FP to the actual FP of a Character.
     * The result can't be below 0 or over FPMax.
     */
    default void addFP(int FP) {    }

    /**
     * Retrives the value of the K variable
     */
    default double getK(){
        return 0;
    }

    /**
     * Retrives the value of the KHammer variable
     */
    default double getKHammer(){
        return 0;
    }

    /**
     * Retrives the value of the KJump variable
     */
    default double getKJump(){
        return 0;
    }

    /**
     * Checks if the current HP of a character is 0 (and, thus, if it's out of combat or not).
     * @return true if KO and false if not
     */
    default boolean isKO(){
        return false;
    }
}
