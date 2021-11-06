package AventurasdeMarcosyLuis.Characters.Heroes;

import AventurasdeMarcosyLuis.Characters.Playable;

/**
 * Implements the attacks and defense of all Heroes (or Players).
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public interface Heroic<T> extends Playable {

    /**
     * Allows defending from an attack from Goomba
     * @param enemy is the original attacker.
     */
    default void defendFromGoomba(Playable enemy){}

    /**
     * Allows defending from an attack from Spiny
     * @param enemy is the original attacker.
     */
    default void defendFromSpiny(Playable enemy){}

    /**
     * Defines that all Heroes must have a jump attack
     */
    default void jump(T t){}

    /**
     * Defines that all Heroes must have a hammer attack
     */
    default void hammer(T t){}

}
