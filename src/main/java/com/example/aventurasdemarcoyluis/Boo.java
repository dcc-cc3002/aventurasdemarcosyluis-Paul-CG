package com.example.aventurasdemarcoyluis;

/**
 * Creates template with shared data of all types of characters in the game
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-14
 */
public class Boo extends AbstractEnemies implements Wicked {
    public Boo(int LVL, int ATK, int DEF, int HPMax, int FPMax){
        super(LVL, ATK, DEF, HPMax, FPMax);
    }

    /**
     * Simple attack on a player.
     * @param player the target of the attack.
     */
    public void attack(AttackableByBoo player) {
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

}
