package AventurasdeMarcosyLuis.Characters.Heroes;

import AventurasdeMarcosyLuis.Characters.Playable;
import AventurasdeMarcosyLuis.Characters.Enemies.Wicked;
import Visitor.Visitor;

/**
 * Creates a Marcos Character, extended from Players
 *
 * @author Paul Chauveau Gerber
 * @version 1.2
 * @since 2021-11-07
 */
public class Marcos extends AbstractPlayers {
    /**
     * Constructor of Marcos
     * @param LVL level
     * @param ATK attack
     * @param DEF defense
     * @param HPMax Max Hp
     * @param FPMax Max FP
     */
    public Marcos(int LVL, int ATK, int DEF, int HPMax, int FPMax){
        super(LVL, ATK, DEF, HPMax, FPMax);
    }

    /**
     * Players most basic attack, it costs 1 FP.
     *
     * @param enemy the target of the Jump attack.
     */
    @Override
    public void jump(Wicked enemy){
        this.addFP(-1);
        enemy.defendFromMarcosJump(this);
    }

    /**
     * Players secondary attack, more powerful, but it has a miss ratio of 25% and costs 2 FP.
     *
     * @param enemy the target of the Hammer attack.
     */
    @Override
    public void hammer(Wicked enemy){
        this.addFP(-2);
        enemy.defendFromMarcosHammer(this);
    }

    /**
     * Response to an incoming attack from Goomba.
     *
     * @param enemy is the original attacker.
     */
    public void defendFromGoomba(Playable enemy){
        int dmg = this.damage(enemy.getK(),enemy, this);
        this.addHP(dmg);
    }

    /**
     *  Response to an incoming attack from Spiny.
     *
     * @param enemy that is attacking the player
     */
    public void defendFromSpiny(Playable enemy){
        int dmg = this.damage(enemy.getK(),enemy, this);
        this.addHP(dmg);
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
