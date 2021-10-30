package AventurasdeMarcosyLuis.Characters.Wicked;

import AventurasdeMarcosyLuis.Characters.Playable;

/**
 * Implements the attacks and defense of all Villains (or Enemies).
 *
 * @author Paul Chauveau Gerber
 * @version 1.1
 * @since 2021-10-10
 */
public interface Wicked {

    /**
     * This methods allows an enemy to react to an attack. There is one for each attack and player type.
     *
     * @param player is the original attacker.
     */
    default void defendFromMarcosJump(Playable player){}

    default void defendFromMarcosHammer(Playable player){}

}
