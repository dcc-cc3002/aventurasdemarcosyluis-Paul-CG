package com.example.aventurasdemarcoyluis;

/**
 * Implements the attacks and defense of all Villains (or Enemies).
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public interface Wicked {

    /**
     * This method allows a character to attack another character.
     *
     * @param player the target of the attack.
     */
    default void attack(Heroic player){}

    /**
     * This methods allows an enemy to react to an attack. There is one for each attack and player type.
     *
     * @param player is the original attacker.
     */
    default void defendFromMarcosJump(Playable player){}

    default void defendFromMarcosHammer(Playable player){}

    default void defendFromLuisJump(Playable player){}

    default void defendFromLuisHammer(Playable player){}
}
