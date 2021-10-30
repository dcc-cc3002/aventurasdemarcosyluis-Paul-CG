package AventurasdeMarcosyLuis.Characters.Heroes;

import AventurasdeMarcosyLuis.Characters.Playable;

/**
 * Implements the attacks and defense of all AventurasdeMarcosyLuis.AventurasdeMarcosyLuis.AventurasdeMarcosyLuis.Items.Items.Characters.AventurasdeMarcosyLuis.AventurasdeMarcosyLuis.AventurasdeMarcosyLuis.Items.Items.Characters.Heroes.Heroes (or Players).
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public interface Heroic {

    /**
     * This method allows a character to react to an attack. There is one method for each enemy attack.
     * @param enemy is the original attacker.
     */
    default void defendFromGoomba(Playable enemy){}

    default void defendFromSpiny(Playable enemy){}

}
