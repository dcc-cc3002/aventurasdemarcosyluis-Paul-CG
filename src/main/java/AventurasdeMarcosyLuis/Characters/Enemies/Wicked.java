package AventurasdeMarcosyLuis.Characters.Enemies;

import AventurasdeMarcosyLuis.Characters.Heroes.Heroic;
import AventurasdeMarcosyLuis.Characters.Playable;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTargetException;

/**
 * Implements the attacks and defense of all Villains (or Enemies).
 *
 * @author Paul Chauveau Gerber
 * @version 1.3
 * @since 2021-11-07
 */
public interface Wicked extends Playable {

    /**
     * This method defends from a jump attack from Marcos
     *
     * @param player is the original attacker.
     */
    default void defendFromMarcosJump(Playable player){}

    /**
     * This method defends from a hammer attack from Marcos
     * @param player enemy defending from Marcos
     */
    default void defendFromMarcosHammer(Playable player){}

    /**
     * This method declares the attack method for all wicked characters
     * @param o objective of the attack
     */
    void attack(Heroic o) throws InvalidTargetException;

}
