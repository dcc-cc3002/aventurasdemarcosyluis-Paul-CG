package com.example.aventurasdemarcoyluis;

/**
 * Implements the attacks and defense of all Heroes (or Players).
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public interface Heroic {

    /**
     * The most basic attack a Player can do. Always hit and has a K coefficient of 1.
     * @param enemy the target of the Jump attack.
     */
    default void jump(Wicked enemy){}

    /**
     * Another type of attack a PLayer can do. Has a chance to hit of 0,75% and has a K coefficient of 1,5.
     * @param enemy the target of the Hammer attack.
     */
    default void hammer(Wicked enemy){}

    /**
     * This method allows a character to react to an attack. There is one method for each enemy attack.
     * @param enemy is the original attacker.
     */
    default void defendFromGoomba(Playable enemy){}

    default void defendFromSpiny(Playable enemy){}

    default void defendFromBoo(Playable enemy){}

}
