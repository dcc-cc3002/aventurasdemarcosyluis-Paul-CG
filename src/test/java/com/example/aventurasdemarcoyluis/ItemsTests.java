package com.example.aventurasdemarcoyluis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ItemsTests {

    private Marcos testMarcos;

    private Star testStar;
    private RedMushroom testRedMushroom;
    private HoneySyrup testHoneySyrup;

    @BeforeEach
    public void setUp() {
        testMarcos = new Marcos(2, 10, 8, 50, 10);

        testStar = new Star();
        testRedMushroom = new RedMushroom();
        testHoneySyrup = new HoneySyrup();
    }

    @Test
    public void hasItemTest(){
        assertFalse(testMarcos.hasItem(testStar));
        assertFalse(testMarcos.hasItem(testRedMushroom));
        assertFalse(testMarcos.hasItem(testHoneySyrup));
    }

    @Test
    public void addItemTest(){
        testMarcos.addItem(testStar);
        testMarcos.addItem(testRedMushroom);
        testMarcos.addItem(testHoneySyrup);
        assertTrue(testMarcos.hasItem(testStar));
        assertTrue(testMarcos.hasItem(testRedMushroom));
        assertTrue(testMarcos.hasItem(testHoneySyrup));
    }

    @Test
    public void addmanyItemsTest(){
        testMarcos.addItem(testStar);
        testMarcos.addItem(testStar);
        testMarcos.useItem(testStar);
        assertTrue(testMarcos.hasItem(testStar));
        testMarcos.useItem(testStar);
        assertFalse(testMarcos.hasItem(testStar));
    }


    @Test
    public void removeItemTest(){
        testMarcos.addItem(testStar);
        assertTrue(testMarcos.hasItem(testStar));
        testMarcos.removeItem(testStar);
        assertFalse(testMarcos.hasItem(testStar));
    }

    @Test
    public void useItemTest(){
        testMarcos.addItem(testStar);
        testMarcos.addItem(testRedMushroom);
        testMarcos.addItem(testHoneySyrup);
        testMarcos.useItem(testStar);
        testMarcos.useItem(testRedMushroom);
        testMarcos.useItem(testHoneySyrup);
        assertFalse(testMarcos.hasItem(testStar));
        assertFalse(testMarcos.hasItem(testRedMushroom));
        assertFalse(testMarcos.hasItem(testHoneySyrup));
    }

    @Test
    public void effectRedMushRoomTest(){
        testMarcos.setHP((int) (testMarcos.getHPMax()*0.9));
        testMarcos.addItem(testRedMushroom);
        testMarcos.useItem(testRedMushroom);
        assertEquals(testMarcos.getHPMax(),testMarcos.getHP());
    }

    @Test
    public void effectHoneySyrupTest(){
        testMarcos.setFP(0);
        testMarcos.addItem(testHoneySyrup);
        testMarcos.useItem(testHoneySyrup);
        assertEquals(3,testMarcos.getFP());
    }

}
