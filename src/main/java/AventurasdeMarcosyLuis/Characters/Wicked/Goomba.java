package AventurasdeMarcosyLuis.Characters.Wicked;

import AventurasdeMarcosyLuis.Characters.Heroes.Heroic;
import AventurasdeMarcosyLuis.Characters.Playable;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Creates a Goomba enemy. The most basic enemy of all.
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public class Goomba extends AbstractEnemies implements Wicked, AttackableByLuis {
    public Goomba(int LVL, int ATK, int DEF, int HPMax, int FPMax){
        super(LVL, ATK, DEF, HPMax, FPMax);
    }

    /**
     * Simple attack on a player.
     * @param player the target of the attack.
     */
    public void attack(Heroic player) {
        player.defendFromGoomba(this);
    }

    /**
     *  Receives a Jump from Marcos, damage is calculated normally.
     * @param player is the original attacker.
     */
    public void defendFromMarcosJump(Playable player) {
        int dmg = this.damage(player.getKJump(), player, this);
        this.addHP(dmg);
    }

    /**
     *  Receives a Hammer from Marcos, damage is calculated normally.
     * @param player is the original attacker.
     */
    public void defendFromMarcosHammer(Playable player) {
        int dmg;
        int rnd = ThreadLocalRandom.current().nextInt(1, 5);
        if (rnd == 1) dmg = 0;
        else dmg = this.damage(player.getKHammer(), player, this);
        this.addHP(dmg);
    }

    /**
     *  Receives a Jump from Luis, damage is calculated normally.
     * @param player is the original attacker.
     */
    public void defendFromLuisJump(Playable player) {
        int dmg = this.damage(player.getKJump(), player, this);
        this.addHP(dmg);
    }

    /**
     *  Receives a Hammer from Luis, damage is calculated normally.
     * @param player is the original attacker.
     */
    public void defendFromLuisHammer(Playable player) {
        int dmg;
        int rnd = ThreadLocalRandom.current().nextInt(1, 5);
        if (rnd == 1) dmg = 0;
        else dmg = this.damage(player.getKHammer(), player, this);
        this.addHP(dmg);
    }
}
