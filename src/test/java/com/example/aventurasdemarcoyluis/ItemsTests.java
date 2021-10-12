package com.example.aventurasdemarcoyluis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ItemsTests {

    private Marcos testMarcos;
    private Chest testChest;

    private Star testStar;
    private RedMushroom testRedMushroom;
    private HoneySyrup testHoneySyrup;

    @BeforeEach
    public void setUp() {
        testMarcos = new Marcos(2, 10, 8, 50, 10);
        testChest = new Chest();

        testStar = new Star();
        testRedMushroom = new RedMushroom();
        testHoneySyrup = new HoneySyrup();
    }

    @Test
    public void hasItemTest(){
        assertFalse(testChest.hasItem(testStar));
        assertFalse(testChest.hasItem(testRedMushroom));
        assertFalse(testChest.hasItem(testHoneySyrup));
    }

    @Test
    public void addItemTest(){
        testChest.addItem(testStar);
        testChest.addItem(testRedMushroom);
        testChest.addItem(testHoneySyrup);
        assertTrue(testChest.hasItem(testStar));
        assertTrue(testChest.hasItem(testRedMushroom));
        assertTrue(testChest.hasItem(testHoneySyrup));
    }

    @Test
    public void addManyItemsTest(){
        testChest.addItem(testStar);
        testChest.addItem(testStar);
        testChest.useItem(testMarcos, testStar);
        assertTrue(testChest.hasItem(testStar));
        testChest.useItem(testMarcos, testStar);
        assertFalse(testChest.hasItem(testStar));
    }


    @Test
    public void removeItemTest(){
        testChest.addItem(testStar);
        assertTrue(testChest.hasItem(testStar));
        testChest.removeItem(testStar);
        assertFalse(testChest.hasItem(testStar));
    }

    @Test
    public void useItemTest(){
        testChest.addItem(testStar);
        testChest.addItem(testRedMushroom);
        testChest.addItem(testHoneySyrup);
        testChest.useItem(testMarcos, testStar);
        testChest.useItem(testMarcos, testRedMushroom);
        testChest.useItem(testMarcos, testHoneySyrup);
        assertFalse(testChest.hasItem(testStar));
        assertFalse(testChest.hasItem(testRedMushroom));
        assertFalse(testChest.hasItem(testHoneySyrup));
    }

    @Test
    public void effectRedMushRoomTest(){
        testMarcos.setHP((int) (testMarcos.getHPMax()*0.9));
        testChest.addItem(testRedMushroom);
        testChest.useItem(testMarcos, testRedMushroom);
        assertEquals(testMarcos.getHPMax(),testMarcos.getHP());
    }

    @Test
    public void effectHoneySyrupTest(){
        testMarcos.setFP(0);
        testChest.addItem(testHoneySyrup);
        testChest.useItem(testMarcos, testHoneySyrup);
        assertEquals(3,testMarcos.getFP());
    }

}
