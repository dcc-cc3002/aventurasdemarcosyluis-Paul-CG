package AventurasdeMarcosyLuis.Characters.Enemies;

import AventurasdeMarcosyLuis.Characters.Playable;

/**
 * This interface is meant to signal which enemies can be attacked by Luis
 */
public interface AttackableByLuis extends Wicked {
    /**
     * Allows defending from the jump attack of Luis
     * @param player player that is attacking
     */
    default void defendFromLuisJump(Playable player){}

    /**
     * Allows defending against a hammer attack from Luis
     * @param player player that is attacking
     */
    default void defendFromLuisHammer(Playable player){}
}
