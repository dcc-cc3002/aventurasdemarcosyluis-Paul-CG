package AventurasdeMarcosyLuis.Characters.Heroes;

import AventurasdeMarcosyLuis.Characters.Enemies.AttackableByLuis;
import AventurasdeMarcosyLuis.Characters.Enemies.Wicked;
import AventurasdeMarcosyLuis.Characters.Playable;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTargetException;

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
    public void jump(Wicked enemy) throws InvalidTargetException{
        try {
            this.auxiliaryJump((AttackableByLuis) enemy);
        } catch (ClassCastException e) {
            throw new InvalidTargetException("Luis is too scared to attack Boo!");
        }
    }

    /**
     * Players most basic attack, it costs 1 FP. This private version is only for Luis.
     *
     * @param enemy the target of the Jump attack.
     */
    private void auxiliaryJump(AttackableByLuis enemy) {
        enemy.defendFromLuisJump(this);
        this.addFP(-1);
    }

    @Override
    public void hammer(Wicked enemy) throws InvalidTargetException{
        try {
            this.auxiliaryHammer((AttackableByLuis) enemy);
        } catch (ClassCastException e) {
            throw new InvalidTargetException("Luis is too scared to attack Boo!");
        }
    }

    /**
     * Players secondary attack, more powerful, but it has a miss ratio of 25% and costs 2 FP.
     *
     * @param enemy the target of the Hammer attack.
     */
    private void auxiliaryHammer(AttackableByLuis enemy) {
        enemy.defendFromLuisHammer(this);
        this.addFP(-2);
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

    @Override
    public String toString() {
        return "Luis";
    }

}
