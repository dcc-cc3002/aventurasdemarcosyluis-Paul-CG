package AventurasdeMarcosyLuis.Characters.Heroes;

import AventurasdeMarcosyLuis.Characters.Playable;

/**
 * This interface is meant to signal which player is attackable by Boo
 */

public interface AttackableByBoo {

    /**
     * Allows defending from an attack from Boo
     * @param enemy original attacker
     */
    default void defendFromBoo(Playable enemy){}
}
