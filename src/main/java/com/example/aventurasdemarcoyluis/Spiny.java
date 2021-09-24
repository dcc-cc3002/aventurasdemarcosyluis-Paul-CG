package com.example.aventurasdemarcoyluis;

import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Creates a Spiny enemy
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public class Spiny extends AbstractEnemies implements Wicked {
    public Spiny(int LVL, int ATK, int DEF, int HPMax, int FPMax){
        super(LVL, ATK, DEF, HPMax, FPMax);
    }

    /**
     * Simple attack on a player.
     * @param player the target of the attack.
     */
    public void attack(Heroic player) {
        player.defendFromSpiny(this);
    }

    /**
     *  Receives a Jump from Marcos, no damage is done and reflects damage back 5% of the player's HP.
     * @param player is the original attacker.
     */
    public void defendFromMarcosJump(Playable player) {
        int dmg = (int) -Math.floor(0.5* player.getHPMax());
        player.addHP(dmg);
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
     *  Receives a Jump from Luis, no damage is done and reflects damage back 5% of the player's HP.
     * @param player is the original attacker.
     */
    public void defendFromLuisJump(Playable player) {
        int dmg = (int) -Math.floor(0.5* player.getHPMax());
        player.addHP(dmg);
    }

    /**
     *  Receives a Hammer from Marcos, damage is calculated normally.
     * @param player is the original attacker.
     */
    public void defendFromLuisHammer(Playable player) {
        int dmg;
        int rnd = ThreadLocalRandom.current().nextInt(1, 5);
        if (rnd == 1) dmg = 0;
        else dmg = this.damage(player.getKHammer(),player, this);
        this.addHP(dmg);
    }
}
