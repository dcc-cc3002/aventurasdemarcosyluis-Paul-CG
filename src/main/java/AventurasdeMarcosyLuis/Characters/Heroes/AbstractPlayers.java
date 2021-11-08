package AventurasdeMarcosyLuis.Characters.Heroes;

import AventurasdeMarcosyLuis.Characters.AbstractCharacter;
import AventurasdeMarcosyLuis.Characters.Heroes.Heroic;

/**
 * Players Extends Character, it represents the main characters of the game.
 * This class implements all the methods to use Items, which corresponds only
 * to the main characters.
 *
 * @author Paul Chauveau Gerber
 * @version 1.2
 * @since 2021-10-12
 */
public abstract class AbstractPlayers extends AbstractCharacter implements Heroic {
    private double KJump;
    private double KHammer;


    /**
     * Constructor of the class, it defines two types of K (hammer and jump)
     * and a factor that determines the increase in power upon leveling up.
     *
     */
    public AbstractPlayers(int LVL, int ATK, int DEF, int HPMax, int FPMax) {
        super(LVL, ATK, DEF, HPMax, FPMax);
        KHammer = 1.5;
        KJump = 1;
    }

    @Override
    public double getKHammer(){
        return KHammer;
    }

    @Override
    public double getKJump(){
        return KJump;
    }

    @Override
    public void genericJump(Object o) {    }

    @Override
    public void genericHammer(Object o) {    }
}








