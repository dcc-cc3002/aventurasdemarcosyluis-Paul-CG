package com.example.aventurasdemarcoyluis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BasicTests {

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
    }

    @Test
    public void constructorTest(){
        assertEquals(2, testMarcos.getLVL());
        assertEquals(10, testMarcos.getATK());
        assertEquals(8, testMarcos.getDEF());
        assertEquals(50, testMarcos.getHPMax());
        assertEquals(10, testMarcos.getFPMax());

        assertEquals(2, testLuis.getLVL());
        assertEquals(10, testLuis.getATK());
        assertEquals(8, testLuis.getDEF());
        assertEquals(50, testLuis.getHPMax());
        assertEquals(10, testLuis.getFPMax());

        assertEquals(2, testSpiny.getLVL());
        assertEquals(10, testSpiny.getATK());
        assertEquals(8, testSpiny.getDEF());
        assertEquals(50, testSpiny.getHPMax());
        assertEquals(10, testSpiny.getFPMax());

        assertEquals(2, testGoomba.getLVL());
        assertEquals(10, testGoomba.getATK());
        assertEquals(8, testGoomba.getDEF());
        assertEquals(50, testGoomba.getHPMax());
        assertEquals(10, testGoomba.getFPMax());

        assertEquals(2, testBoo.getLVL());
        assertEquals(10, testBoo.getATK());
        assertEquals(8, testBoo.getDEF());
        assertEquals(50, testBoo.getHPMax());
        assertEquals(10, testBoo.getFPMax());

        Marcos expectedMarcos = new Marcos(2, 10, 8, 50, 10);
        Luis expectedLuis = new Luis(2, 10, 8, 50, 10);
        Spiny expectedSpiny = new Spiny(2, 10, 8, 50, 10);
        Goomba expectedGoomba = new Goomba(2, 10, 8, 50, 10);
        Boo expectedBoo = new Boo(2, 10, 8, 50, 10);

        assertEquals(testMarcos, expectedMarcos);
        assertEquals(testLuis, expectedLuis);
        assertEquals(testSpiny, expectedSpiny);
        assertEquals(testGoomba, expectedGoomba);
        assertEquals(testBoo, expectedBoo);

    }


    @Test
    public void setTest(){
        testMarcos.setLVL(10);
        testMarcos.setATK(50);
        testMarcos.setDEF(40);
        testMarcos.setHPMax(100);
        testMarcos.setFPMax(100);
        testMarcos.setHP(1);
        testMarcos.setFP(1);

        assertEquals(10, testMarcos.getLVL());
        assertEquals(50, testMarcos.getATK());
        assertEquals(40, testMarcos.getDEF());
        assertEquals(100, testMarcos.getHPMax());
        assertEquals(100, testMarcos.getFPMax());
        assertEquals(1, testMarcos.getHP());
        assertEquals(1, testMarcos.getFP());
    }

    @Test
    public void hpTest(){
        testMarcos.setHP(1);
        assertEquals(1,testMarcos.getHP());

        testMarcos.addHP(-100);
        assertEquals(0,testMarcos.getHP());
        testMarcos.setHP(100);
        assertEquals(testMarcos.getHPMax(),testMarcos.getHP());
        testMarcos.addHP(100);
        assertEquals(testMarcos.getHPMax(),testMarcos.getHP());
    }

    @Test
    public void fpTest(){
        testMarcos.setFP(1);
        assertEquals(1,testMarcos.getFP());

        testMarcos.addFP(-100);
        assertEquals(0,testMarcos.getFP());
        testMarcos.setFP(100);
        assertEquals(testMarcos.getFPMax(),testMarcos.getFP());
        testMarcos.addFP(100);
        assertEquals(testMarcos.getFPMax(),testMarcos.getFP());
    }

    @Test
    public void koTest(){
        testLuis.setHP(0);
        assertFalse(testMarcos.isKO());
        assertTrue(testLuis.isKO());
    }

    @Test
    public void getKsTest(){
        assertEquals(0.75,testMarcos.getK());
        assertEquals(1,testMarcos.getKJump());
        assertEquals(1.5,testMarcos.getKHammer());
    }

    @Test
    public void lvlUpTest(){

        double factorLvlUp = 1.15;
        int LVL = testMarcos.getLVL();
        int HPMax = testMarcos.getHPMax();
        int FPMax = testMarcos.getFPMax();
        int ATK = testMarcos.getATK();
        int DEF = testMarcos.getDEF();

        testMarcos.lvlUp();

        assertEquals(LVL+1, testMarcos.getLVL());
        assertEquals((int) (HPMax*factorLvlUp), testMarcos.getHPMax());
        assertEquals((int) (FPMax*factorLvlUp), testMarcos.getFPMax());
        assertEquals((int) (ATK*factorLvlUp), testMarcos.getATK());
        assertEquals((int) (DEF*factorLvlUp), testMarcos.getDEF());
    }

}
