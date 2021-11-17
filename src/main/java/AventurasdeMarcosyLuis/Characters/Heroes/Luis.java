package AventurasdeMarcosyLuis.Characters.Heroes;

import AventurasdeMarcosyLuis.Characters.Enemies.AttackableByLuis;
import AventurasdeMarcosyLuis.Characters.Enemies.Wicked;
import AventurasdeMarcosyLuis.Characters.Playable;
import Visitor.Visitor;

/**
 * Creates a Luis Character, extended from Players
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-23
 */
public class Luis extends AbstractPlayers implements AttackableByBoo {
    /**
     * Constructor of Luis
     * @param LVL level
     * @param ATK attack
     * @param DEF defense
     * @param HPMax Max HP
     * @param FPMax Max FP
     */
    public Luis(int LVL, int ATK, int DEF, int HPMax, int FPMax){
        super(LVL, ATK, DEF, HPMax, FPMax);
    }

    @Override
    public void jump(Wicked enemy){
        this.jump((AttackableByLuis) enemy);
    }

    /**
     * Players most basic attack, it costs 1 FP. This private version is only for Luis.
     *
     * @param enemy the target of the Jump attack.
     */
    private void jump(AttackableByLuis enemy) {
        this.addFP(-1);
        enemy.defendFromLuisJump(this);
    }

    @Override
    public void hammer(Wicked enemy){
        this.hammer((AttackableByLuis) enemy);
    }

    /**
     * Players secondary attack, more powerful, but it has a miss ratio of 25% and costs 2 FP.
     *
     * @param enemy the target of the Hammer attack.
     */
    private void hammer(AttackableByLuis enemy){
        this.addFP(-2);
        enemy.defendFromLuisHammer(this);
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

    /**
     * Response to an incoming attack from Boo.
     *
     * @param enemy that is attacking the player
     */
    public void defendFromBoo(Playable enemy){
        int dmg = this.damage(enemy.getK(),enemy, this);
        this.addHP(dmg);
    }

    public void accept(Visitor visitor){
        visitor.visitLuis(this);
    }

}
