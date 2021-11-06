package AventurasdeMarcosyLuis.Characters.Enemies;

import AventurasdeMarcosyLuis.Characters.Playable;

/**
 * Implements the attacks and defense of all Villains (or Enemies).
 *
 * @author Paul Chauveau Gerber
 * @version 1.1
 * @since 2021-10-10
 */
public interface Wicked<T> {

    /**
     * This methods defends from a jump attack from Marcos
     *
     * @param player is the original attacker.
     */
    default void defendFromMarcosJump(Playable player){}

    /**
     * This method defends from a hammer attack from Marcos
     * @param player
     */
    default void defendFromMarcosHammer(Playable player){}

    /**
     * This method declares the attack method for all wicked characters
     * @param t
     */
    default void attack(T t){}

}
