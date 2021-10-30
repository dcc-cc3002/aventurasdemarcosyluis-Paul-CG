package AventurasdeMarcosyLuis.Items;

import AventurasdeMarcosyLuis.Characters.Playable;

/**
 * Implements the attacks and defense of all AventurasdeMarcosyLuis.AventurasdeMarcosyLuis.AventurasdeMarcosyLuis.Items.Items.Characters.AventurasdeMarcosyLuis.AventurasdeMarcosyLuis.AventurasdeMarcosyLuis.Items.Items.Characters.Heroes.Heroes (or Players).
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */

public interface Consumable {

    /**
     * An abstract method that activates the effect of an Item Object.
     *
     * @param character it receives the character that uses the item
     */
    default void activate(Playable character) {}
}
