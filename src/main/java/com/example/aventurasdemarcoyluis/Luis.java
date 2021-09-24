package com.example.aventurasdemarcoyluis;

/**
 * Creates a Luis Character, extended from PLayers
 *
 * @author Paul Chauveau Gerber
 * @version 1.0
 * @since 2021-09-23
 */
public class Luis extends AbstractPlayers implements Heroic {
    public Luis(int LVL, int ATK, int DEF, int HPMax, int FPMax){
        super(LVL, ATK, DEF, HPMax, FPMax);
    }

    /**
     * Players most basic attack, it costs 1 FP.
     *
     * @param enemy the target of the Jump attack.
     */
    public void jump(Wicked enemy){
        this.addFP(-1);
        enemy.defendFromLuisJump(this);
    }

    /**
     * Players secondary attack, more powerful, but it has a miss ratio of 25% and costs 2 FP.
     *
     * @param enemy the target of the Hammer attack.
     */
    public void hammer(Wicked enemy){
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
}
