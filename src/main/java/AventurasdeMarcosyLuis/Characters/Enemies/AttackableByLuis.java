package AventurasdeMarcosyLuis.Characters.Enemies;

import AventurasdeMarcosyLuis.Characters.Playable;

/**
 * This interface is meant to signal which enemies can be attacked by Luis
 */
public interface AttackableByLuis {
    /**
     * Allows defending from the jump attack of Luis
     * @param player
     */
    default void defendFromLuisJump(Playable player){}

    /**
     * Allows defending against a hammer attack from Luis
     * @param player
     */
    default void defendFromLuisHammer(Playable player){}
}
