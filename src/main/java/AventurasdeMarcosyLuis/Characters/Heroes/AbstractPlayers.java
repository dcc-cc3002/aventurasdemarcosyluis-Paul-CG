package AventurasdeMarcosyLuis.Characters.Heroes;

import AventurasdeMarcosyLuis.Characters.AbstractCharacter;
import AventurasdeMarcosyLuis.Characters.Enemies.Wicked;

/**
 * Players Extends Character, it represents the main characters of the game.
 * This class implements all the methods to use Items, which corresponds only
 * to the main characters.
 *
 * @author Paul Chauveau Gerber
 * @version 1.4
 * @since 2021-11-07
 */
public abstract class AbstractPlayers extends AbstractCharacter implements Heroic {

    /**
     * Constructor of the class, it defines two types of K (hammer and jump)
     * and a factor that determines the increase in power upon leveling up.
     *
     */
    public AbstractPlayers(int LVL, int ATK, int DEF, int HPMax, int FPMax) {
        super(LVL, ATK, DEF, HPMax, FPMax);
    }

    @Override
    public void jump(Wicked o) {    }

    @Override
    public void hammer(Wicked o) {    }
}








