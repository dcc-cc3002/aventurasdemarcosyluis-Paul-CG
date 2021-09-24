package com.example.aventurasdemarcoyluis;

/**
 * Creates a Marcos Character, extended from Players
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-23
 */
public class Marcos extends AbstractPlayers implements Heroic {
    public Marcos(int LVL, int ATK, int DEF, int HPMax, int FPMax){
        super(LVL, ATK, DEF, HPMax, FPMax);
    }

    /**
     * Players most basic attack, it costs 1 FP.
     *
     * @param enemy the target of the Jump attack.
     */
    public void jump(Wicked enemy){
        this.addFP(-1);
        enemy.defendFromMarcosJump(this);
    }

    /**
     * Players secondary attack, more powerful, but it has a miss ratio of 25% and costs 2 FP.
     *
     * @param enemy the target of the Hammer attack.
     */
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

    /**
     * Response to an incoming attack from Boo, notice that Boo can't attack Marcos.
     *
     * @param enemy that is attacking the player
     */
    public void defendFromBoo(Playable enemy){
        int dmg = 0;
        this.addHP(dmg);
    }
}
