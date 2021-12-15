package AventurasdeMarcosyLuis.Characters.Enemies;

import AventurasdeMarcosyLuis.Characters.Heroes.AttackableByBoo;
import AventurasdeMarcosyLuis.Characters.Heroes.Heroic;
import AventurasdeMarcosyLuis.Characters.Playable;
import AventurasdeMarcosyLuis.Phases.Exceptions.InvalidTargetException;

/**
 * Creates template with shared data of all types of characters in the game
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public class Boo extends AbstractEnemies {
    /**
     * Constructor of Boo
     * @param LVL level
     * @param ATK attack
     * @param DEF defense
     * @param HPMax Max HP
     * @param FPMax Max FP
     */
    public Boo(int LVL, int ATK, int DEF, int HPMax, int FPMax){
        super(LVL, ATK, DEF, HPMax, FPMax);
    }

    @Override
    public void attack(Heroic player) throws InvalidTargetException {
        try {
            this.auxiliaryAttack((AttackableByBoo) player);
        } catch (ClassCastException e) {
            throw new InvalidTargetException("Boo can only attack Luis!");
        }
    }

    /**
     * Simple attack on a player. This private version is to cast locally to AttackableByBoo.
     * @param player the target of the attack.
     */
    private void auxiliaryAttack(AttackableByBoo player) {
        player.defendFromBoo(this);
    }


    /**
     *  Receives a Jump from Marcos, damage is calculated normally.
     * @param player is the original attacker.
     */
    public void defendFromMarcosJump(Playable player) {
        int dmg = this.damage(player.getKJump(),player, this);
        this.addHP(dmg);
    }

    /**
     *  Receives a Hammer from Marcos, no damage is dealt.
     * @param player is the original attacker.
     */
    public void defendFromMarcosHammer(Playable player) {
        int dmg = 0;
        this.addHP(dmg);
    }

    @Override
    public String toString() {
        return "Boo";
    }

}
