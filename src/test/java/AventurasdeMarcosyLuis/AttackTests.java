package AventurasdeMarcosyLuis;

import AventurasdeMarcosyLuis.Characters.Heroes.Luis;
import AventurasdeMarcosyLuis.Characters.Heroes.Marcos;
import AventurasdeMarcosyLuis.Characters.Enemies.Boo;
import AventurasdeMarcosyLuis.Characters.Enemies.Goomba;
import AventurasdeMarcosyLuis.Characters.Enemies.Spiny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.Math;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class AttackTests {

    private Marcos testMarcos;
    private Luis testLuis;
    private Spiny testSpiny;
    private Goomba testGoomba;
    private Boo testBoo;


    @BeforeEach
    public void setUp() {
        testMarcos = new Marcos(2, 10, 8, 50, 10);
        testLuis = new Luis(2, 10, 8, 50, 10);
        testSpiny = new Spiny(2, 10, 8, 50, 10);
        testGoomba= new Goomba(2, 10, 8, 50, 10);
        testBoo = new Boo(2, 10, 8, 50, 10);

        Random numeroRandom = new Random();
        numeroRandom.setSeed(3);
    }

    @Test
    public void jumpDamageAndFPTest(){
        int dmg = (int) -Math.ceil(testMarcos.getATK()*testMarcos.getLVL()/testGoomba.getDEF())-1;

        int fp_init = testMarcos.getFP();
        testMarcos.jump(testGoomba);
        int fp_final = testMarcos.getFP();

        assertEquals(dmg,testMarcos.damage(1,testMarcos,testGoomba));
        assertEquals(1, fp_init-fp_final);
    }

    @Test
    public void hammerDamageAndFPTest(){
        int dmg = (int) -Math.ceil(1.5*testMarcos.getATK()*testMarcos.getLVL()/testGoomba.getDEF());

        int fp_init = testMarcos.getFP();
        testMarcos.hammer(testGoomba);
        int fp_final = testMarcos.getFP();

        assertEquals(dmg,testMarcos.damage(1.5,testMarcos,testGoomba));
        assertEquals(2, fp_init-fp_final);

    }

    @Test
    public void luisAttackTest(){
        /**
         * Check that Luis Hits Goomba
         */
        testLuis.jump(testGoomba);
        assertNotEquals(testGoomba.getHPMax(),testGoomba.getHP());
        testLuis.hammer(testGoomba);
        testLuis.hammer(testGoomba);
        testLuis.hammer(testGoomba);
        testLuis.hammer(testGoomba);
        assertNotEquals(testGoomba.getHPMax(),testGoomba.getHP());

        /**
         * Check that Luis Hits Spiny with Hammer and receives damage jumping onto him
         */
        testLuis.jump(testSpiny);
        assertNotEquals(testLuis.getHPMax(),testLuis.getHP());
        testLuis.hammer(testSpiny);
        testLuis.hammer(testSpiny);
        testLuis.hammer(testSpiny);
        testLuis.hammer(testSpiny);
        assertNotEquals(testSpiny.getHPMax(),testSpiny.getHP());
    }

    @Test
    public void marcosAttackTest(){
        /**
         * Check that Marcos Hits Goomba
         */
        testMarcos.jump(testGoomba);
        assertNotEquals(testGoomba.getHPMax(),testGoomba.getHP());
        testMarcos.hammer(testGoomba);
        testMarcos.hammer(testGoomba);
        testMarcos.hammer(testGoomba);
        testMarcos.hammer(testGoomba);
        assertNotEquals(testGoomba.getHPMax(),testGoomba.getHP());

        /**
         * Check that Marcos Hits Spiny with Hammer and receives damage jumping onto him
         */
        testMarcos.jump(testSpiny);
        assertNotEquals(testMarcos.getHPMax(),testMarcos.getHP());
        testMarcos.hammer(testSpiny);
        testMarcos.hammer(testSpiny);
        testMarcos.hammer(testSpiny);
        testMarcos.hammer(testSpiny);
        assertNotEquals(testSpiny.getHPMax(),testSpiny.getHP());

        /**
         * Check that Marcos Jump damages Boo but his Hammer doesn't
         */
        testMarcos.jump(testBoo);
        assertNotEquals(testBoo.getHPMax(),testBoo.getHP());
        testBoo.setHP(testBoo.getHPMax());
        testMarcos.hammer(testBoo);
        testMarcos.hammer(testBoo);
        testMarcos.hammer(testBoo);
        testMarcos.hammer(testBoo);
        assertEquals(testBoo.getHPMax(),testBoo.getHP());
    }

    @Test
    public void enemyDamageTest(){
        int dmg = (int) -Math.ceil(0.75*testGoomba.getATK()*testGoomba.getLVL()/testMarcos.getDEF());

        int hp_init = testMarcos.getHP();
        testGoomba.attack(testMarcos);
        int hp_final = testMarcos.getHP();

        assertEquals(dmg,testGoomba.damage(0.75, testGoomba, testMarcos));
        assertEquals(-dmg, hp_init-hp_final);
    }

    @Test
    public void goombaAttackTest(){
        testGoomba.attack(testMarcos);
        assertNotEquals(testMarcos.getHPMax(),testMarcos.getHP());

        testGoomba.attack(testLuis);
        assertNotEquals(testLuis.getHPMax(),testLuis.getHP());

    }

    @Test
    public void spinyAttackTest(){
        testSpiny.attack(testMarcos);
        assertNotEquals(testMarcos.getHPMax(),testMarcos.getHP());

        testSpiny.attack(testLuis);
        assertNotEquals(testLuis.getHPMax(),testLuis.getHP());

    }

    @Test
    public void booAttackTest(){
        /**
         * Check that Boo can't attack Marcos (commented)
         */
        /** testBoo.attack(testMarcos); */

        testBoo.attack(testLuis);
        assertNotEquals(testLuis.getHPMax(),testLuis.getHP());

    }

    @Test
    public void koCantAttackTest(){
        testMarcos.setHP(0);
        testMarcos.jump(testGoomba);
        assertEquals(testGoomba.getHP(),testGoomba.getHPMax());
    }

}

