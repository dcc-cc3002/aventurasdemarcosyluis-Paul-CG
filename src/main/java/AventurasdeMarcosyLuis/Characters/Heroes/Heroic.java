package AventurasdeMarcosyLuis.Characters.Heroes;

import AventurasdeMarcosyLuis.Characters.Enemies.Wicked;
import AventurasdeMarcosyLuis.Characters.Playable;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTargetException;

/**
 * Implements the attacks and defense of all Heroes (or Players).
 *
 * @author Paul Chauveau Gerber
 * @version 1.3
 * @since 2021-11-07
 */
public interface Heroic extends Playable {

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
     * @param enemy objective of the attack
     */
    void jump(Wicked enemy) throws InvalidTargetException;

    /**
     * Defines that all Heroes must have a hammer attack
     * @param enemy objective of the attack
     */
    void hammer(Wicked enemy) throws InvalidTargetException;

}
